package service;

import entity.Ucak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UcakYukleyici {
    public static ArrayList<Ucak> yukle(String dosyaYolu) {
        ArrayList<Ucak> ucakListesi = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                String[] parcalar = satir.split(",");
                if (parcalar.length >= 4) {
                    String model = parcalar[0];
                    String marka = parcalar[1];
                    String seriNo = parcalar[2];
                    int kapasite = Integer.parseInt(parcalar[3]);
                    String firma = parcalar[4];

                    Ucak ucak = new Ucak(model, marka, seriNo, kapasite, firma);
                    ucakListesi.add(ucak);
                }
            }
        } catch (IOException e) {
            System.out.println("Uçak verileri okunamadı: " + e.getMessage());
        }

        return ucakListesi;
    }
}
