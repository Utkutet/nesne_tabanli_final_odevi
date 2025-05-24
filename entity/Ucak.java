package entity;

public class Ucak {
    private String model;
    private String marka;
    private String firma;
    private String seriNo;
    private int koltukKapasitesi;

    public Ucak(String model, String marka, String seriNo, int koltukKapasitesi, String firma) {
        this.model = model;
        this.marka = marka;
        this.seriNo = seriNo;
        this.koltukKapasitesi = koltukKapasitesi;
        this.firma = firma;
    }

    public String getModel() {
        return model;
    }

    public String getMarka() {
        return marka;
    }

    public String getSeriNo() {
        return seriNo;
    }

    public int getKoltukKapasitesi() {
        return koltukKapasitesi;
    }

    public String getFirma() {
        return firma;
    }

    @Override
    public String toString() {
        return model + "," + marka + "," + seriNo + "," + koltukKapasitesi + "," + firma;
    }
}
