package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DosyaOkuyucu {
    public static void okuVeYazdir(String dosyaYolu) {
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                System.out.println(satir);
            }
        } catch (IOException e) {
            System.out.println("Dosya okunamadı: " + e.getMessage());
        }
    }
}
