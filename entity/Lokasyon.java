package entity;

public class Lokasyon {
    private String ulke;
    private String sehir;
    private String havaalani;
    private boolean aktif;

    public Lokasyon(String ulke, String sehir, String havaalani, boolean aktif) {
        this.ulke = ulke;
        this.sehir = sehir;
        this.havaalani = havaalani;
        this.aktif = aktif;
    }

    public String getUlke() {
        return ulke;
    }

    public String getSehir() {
        return sehir;
    }

    public String getHavaalani() {
        return havaalani;
    }

    public boolean isAktif() {
        return aktif;
    }

    @Override
    public String toString() {
        return ulke + "," + sehir + "," + havaalani + "," + (aktif ? "Aktif" : "Pasif");
    }
}
