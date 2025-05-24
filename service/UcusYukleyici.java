package service;

import entity.Lokasyon;
import entity.Ucak;
import entity.Ucus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UcusYukleyici {
    public static ArrayList<Ucus> yukle(String dosyaYolu, ArrayList<Lokasyon> lokasyonlar, ArrayList<Ucak> ucaklar) {
        ArrayList<Ucus> ucusListesi = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                String[] parcalar = satir.split(",");
                if (parcalar.length >= 4) {
                    String sehir = parcalar[0];
                    String saat = parcalar[1];
                    String ucakModel = parcalar[2];
                    // kalanKoltuk kısmı CSV'de var ama yeniden hesaplansın istersen, yoksa oku

                    // Lokasyonu bul
                    Lokasyon secilenLokasyon = null;
                    for (Lokasyon lok : lokasyonlar) {
                        if (lok.getSehir().equalsIgnoreCase(sehir)) {
                            secilenLokasyon = lok;
                            break;
                        }
                    }

                    // Uçağı bul
                    Ucak secilenUcak = null;
                    for (Ucak ucak : ucaklar) {
                        if (ucak.getModel().equalsIgnoreCase(ucakModel)) {
                            secilenUcak = ucak;
                            break;
                        }
                    }

                    // Her şey bulunduysa uçuşu oluştur
                    if (secilenLokasyon != null && secilenUcak != null) {
                        Ucus ucus = new Ucus(secilenLokasyon, saat, secilenUcak);
                        ucusListesi.add(ucus);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Uçuş verileri okunamadı: " + e.getMessage());
        }

        return ucusListesi;
    }
}
