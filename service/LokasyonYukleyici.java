package service;

import entity.Lokasyon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LokasyonYukleyici {
    public static ArrayList<Lokasyon> yukle(String dosyaYolu) {
        ArrayList<Lokasyon> lokasyonListesi = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                String[] parcalar = satir.split(",");
                if (parcalar.length >= 4) {
                    String ulke = parcalar[0];
                    String sehir = parcalar[1];
                    String havaalani = parcalar[2];
                    boolean aktif = parcalar[3].equalsIgnoreCase("Aktif");

                    Lokasyon lokasyon = new Lokasyon(ulke, sehir, havaalani, aktif);
                    lokasyonListesi.add(lokasyon);
                }
            }
        } catch (IOException e) {
            System.out.println("Lokasyon verileri okunamadı: " + e.getMessage());
        }

        return lokasyonListesi;
    }
}
