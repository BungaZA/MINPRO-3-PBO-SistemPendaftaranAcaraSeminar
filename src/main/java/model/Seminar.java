package model;

public class Seminar extends Acara {
    private String bidang;
    private double biaya;

    public Seminar(int id, String nama, String pemateri, String tanggal,
                   int kuota, String bidang, double biaya) {
        super(id, nama, pemateri, tanggal, kuota);
        this.bidang = bidang;
        this.biaya = biaya;
    }

    public String getBidang() { return bidang; }
    public void setBidang(String bidang) { this.bidang = bidang; }

    public double getBiaya() { return biaya; }
    public void setBiaya(double biaya) { this.biaya = biaya; }

    @Override
    public String getJenis() {
        return "Seminar";
    }

    @Override
    public String getInfoTambahan() {
        return "Bidang: " + bidang;
    }

    @Override
    public double hitungBiayaPendaftaran() {
        return biaya;
    }

    @Override
    public String toString() {
        return super.toString() + "\n   " + getInfoTambahan();
    }
}
