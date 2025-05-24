package entity;

public class Ucus {
    private Lokasyon lokasyon;
    private String saat;
    private Ucak ucak;
    private int kalanKoltuk;

    public Ucus(Lokasyon lokasyon, String saat, Ucak ucak) {
        this.lokasyon = lokasyon;
        this.saat = saat;
        this.ucak = ucak;
        this.kalanKoltuk = ucak.getKoltukKapasitesi(); // Başlangıçta tüm koltuklar boş
    }

    public Lokasyon getLokasyon() {
        return lokasyon;
    }

    public String getSaat() {
        return saat;
    }

    public Ucak getUcak() {
        return ucak;
    }

    public int getKalanKoltuk() {
        return kalanKoltuk;
    }

    public boolean rezervasyonYap() {
        if (kalanKoltuk > 0) {
            kalanKoltuk--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return lokasyon.getSehir() + "," + saat + "," + ucak.getFirma() + "," + kalanKoltuk + " koltuk";
    }
}
