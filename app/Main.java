package app;

import entity.*;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Ucak> ucakListesi = new ArrayList<>();
    static ArrayList<Lokasyon> lokasyonListesi = new ArrayList<>();
    static ArrayList<Ucus> ucusListesi = new ArrayList<>();
    static ArrayList<Rezervasyon> rezervasyonListesi = new ArrayList<>();



    static VeriKaydedici kaydedici = new CSVKaydedici();

    public static void main(String[] args) {
        lokasyonListesi = LokasyonYukleyici.yukle("data/lokasyonlar.csv");
        ucakListesi = UcakYukleyici.yukle("data/ucaklar.csv");
        ucusListesi = UcusYukleyici.yukle("data/ucuslar.csv", lokasyonListesi, ucakListesi);




        System.out.println("=== Uçak Bilet Rezervasyon Sistemi ===");

        while (true) {
            System.out.println("\n1. Uçak Ekle\n2. Lokasyon Ekle\n3. Uçuş Ekle\n4. Uçuşları Listele\n5. Rezervasyon Yap\n6. Mevcut Rezervasyonları Göster\n7. Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = Integer.parseInt(scanner.nextLine());

            switch (secim) {
                case 1 -> ucakEkle();
                case 2 -> lokasyonEkle();
                case 3 -> ucusEkle();
                case 4 -> ucuslariListele();
                case 5 -> rezervasyonYap();
                case 6 -> DosyaOkuyucu.okuVeYazdir("data/rezervasyonlar.csv");
                case 7 -> {
                    System.out.println("Çıkış yapılıyor...");
                    return;
                }
                default -> System.out.println("Geçersiz seçim.");
            }
        }
    }

    static void ucakEkle() {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Marka: ");
        String marka = scanner.nextLine();
        System.out.print("Firma (örn: Pegasus, JetGlobal): ");
        String firma = scanner.nextLine();
        System.out.print("Seri No: ");
        String seriNo = scanner.nextLine();
        System.out.print("Koltuk Kapasitesi: ");
        int kapasite = Integer.parseInt(scanner.nextLine());

        Ucak ucak = new Ucak(model, marka, seriNo, kapasite, firma);
        ucakListesi.add(ucak);
        kaydedici.kaydet(ucak.toString(), "data/ucaklar.csv");
        System.out.println("Uçak eklendi.");
    }

    static void lokasyonEkle() {
        System.out.print("Ülke: ");
        String ulke = scanner.nextLine();
        System.out.print("Şehir: ");
        String sehir = scanner.nextLine();
        System.out.print("Havaalanı: ");
        String havaalani = scanner.nextLine();
        System.out.print("Aktif mi? (true/false): ");
        boolean aktif = Boolean.parseBoolean(scanner.nextLine());

        Lokasyon lokasyon = new Lokasyon(ulke, sehir, havaalani, aktif);
        lokasyonListesi.add(lokasyon);
        kaydedici.kaydet(lokasyon.toString(), "data/lokasyonlar.csv");
        System.out.println("Lokasyon eklendi.");
    }

    static void ucusEkle() {
        if (ucakListesi.isEmpty() || lokasyonListesi.isEmpty()) {
            System.out.println("Önce uçak ve lokasyon eklemelisiniz.");
            return;
        }

        System.out.println("Uçaklar:");
        for (int i = 0; i < ucakListesi.size(); i++) {
            System.out.println((i + 1) + ". " + ucakListesi.get(i).getModel());
        }
        System.out.print("Uçak seç (numara): ");
        int ucakIndex = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.println("Lokasyonlar:");
        for (int i = 0; i < lokasyonListesi.size(); i++) {
            System.out.println((i + 1) + ". " + lokasyonListesi.get(i).getSehir());
        }
        System.out.print("Lokasyon seç (numara): ");
        int lokasyonIndex = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.print("Uçuş Saati (örn: 15:30): ");
        String saat = scanner.nextLine();

        Ucus ucus = new Ucus(lokasyonListesi.get(lokasyonIndex), saat, ucakListesi.get(ucakIndex));
        ucusListesi.add(ucus);
        kaydedici.kaydet(ucus.toString(), "data/ucuslar.csv");
        System.out.println("Uçuş eklendi.");
    }

    static void ucuslariListele() {
        if (ucusListesi.isEmpty()) {
            System.out.println("Hiç uçuş yok.");
            return;
        }

        for (int i = 0; i < ucusListesi.size(); i++) {
            System.out.println((i + 1) + ". " + ucusListesi.get(i));
        }
    }

    static void rezervasyonYap() {
        if (ucusListesi.isEmpty()) {
            System.out.println("Önce uçuş eklenmeli.");
            return;
        }

        ucuslariListele();
        System.out.print("Uçuş seç (numara): ");
        int ucusIndex = Integer.parseInt(scanner.nextLine()) - 1;

        Ucus seciliUcus = ucusListesi.get(ucusIndex);

        if (seciliUcus.getKalanKoltuk() == 0) {
            System.out.println("Bu uçuşta boş koltuk kalmamış.");
            return;
        }

        System.out.print("Ad: ");
        String ad = scanner.nextLine();
        System.out.print("Soyad: ");
        String soyad = scanner.nextLine();
        System.out.print("Yaş: ");
        int yas = Integer.parseInt(scanner.nextLine());

        if (seciliUcus.rezervasyonYap()) {
            Rezervasyon rez = new Rezervasyon(seciliUcus, ad, soyad, yas);
            rezervasyonListesi.add(rez);
            kaydedici.kaydet(rez.toString(), "data/rezervasyonlar.csv");
            System.out.println("Rezervasyon başarılı.");
        } else {
            System.out.println("Rezervasyon başarısız. Boş koltuk yok.");
        }
    }
}
