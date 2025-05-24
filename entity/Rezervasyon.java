package entity;

public class Rezervasyon {
    private Ucus ucus;
    private String ad;
    private String soyad;
    private int yas;

    public Rezervasyon(Ucus ucus, String ad, String soyad, int yas) {
        this.ucus = ucus;
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
    }

    public Ucus getUcus() {
        return ucus;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public int getYas() {
        return yas;
    }

    @Override
    public String toString() {
        return "Ad Soyad: " + ad + " " + soyad + "\n" +
                "Yaş: " + yas + "\n" +
                "Bilet Firması: " + ucus.getUcak().getFirma() + "\n" +
                "Uçuş Yeri: " + ucus.getLokasyon().getSehir() + "\n" +
                "Saat: " + ucus.getSaat() + "\n";
    }

}
