package service;

import java.io.FileWriter;
import java.io.IOException;

public class CSVKaydedici implements VeriKaydedici {
    @Override
    public void kaydet(String veri, String dosyaYolu) {
        try (FileWriter writer = new FileWriter(dosyaYolu, true)) {
            writer.write(veri + "\n");
        } catch (IOException e) {
            System.out.println("Dosyaya yazarken hata oluştu: " + e.getMessage());
        }
    }
}
