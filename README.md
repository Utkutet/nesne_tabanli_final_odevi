## ✨ Uçak Bilet Rezervasyon Sistemi – Java OOP

Bu projede Java programlama dili kullanılarak konsol tabanlı bir uçak bilet rezervasyon sistemi geliştirilmiştir. Uygulama nesne yönelimli programlama (OOP) ilkelerine uygun olarak yazılmıştır.

---
### Sınıflar (Entity):
- `Ucak`: Model, marka, seri no, koltuk kapasitesi, firma
- `Lokasyon`: Ülke, şehir, havaalanı, aktif/pasif
- `Ucus`: Uçuş saati, uçak, lokasyon, kalan koltuk
- `Rezervasyon`: Ad, soyad, yaş, uçuş bilgisi

###  Servisler:
- `CSVKaydedici`: Verileri `.csv` formatında kaydeder
- `DosyaOkuyucu`: CSV verilerini konsola yazdırır
- `Yukleyiciler`: Başlangıçta verileri dosyadan yükler (Ucak, Lokasyon, Ucus)

###  Interface:
- `VeriKaydedici`: Dosya kaydetme işlemi için kullanılır.

---

##   Uygulama Özellikleri

- Kullanıcıdan uçak, lokasyon, uçuş ve rezervasyon bilgileri alınır
- Her şey kullanıcı tarafından sıfırdan girilir (hazır veri yoktur.)
- Koltuk kapasitesine göre rezervasyon kontrolü yapılır.
- Tüm bilgiler `.csv` dosyalarına kaydedilir.
- Önceden kayıtlı veriler uygulama açıldığında geri yüklenir.
- Yapılan rezervasyonlar okunabilir biçimde gösterilir.


---

## ▶️ Çalıştırmak İçin

1. Java 17+ ve bir IDE (IntelliJ önerilir) kurulu olmalıdır
2. `Main.java` dosyası çalıştırıldığında menü üzerinden işlemler yapılabilir
3. `data/` klasörü otomatik olarak CSV dosyalarını günceller