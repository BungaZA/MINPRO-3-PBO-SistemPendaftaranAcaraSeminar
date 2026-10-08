package model;

public class Workshop extends Acara {
    public static final double BIAYA_MATERI = 25000;
    public static final double TARIF_PER_JAM = 20000;

    private int durasiJam;
    private String alat;

    public Workshop(int id, String nama, String pemateri, String tanggal,
                    int kuota, int durasiJam, String alat) {
        super(id, nama, pemateri, tanggal, kuota);
        this.durasiJam = durasiJam;
        this.alat = alat;
    }

    public int getDurasiJam() { return durasiJam; }
    public void setDurasiJam(int durasiJam) { this.durasiJam = durasiJam; }

    public String getAlat() { return alat; }
    public void setAlat(String alat) { this.alat = alat; }

    @Override
    public String getJenis() {
        return "Workshop";
    }

    @Override
    public String getInfoTambahan() {
        return "Durasi: " + durasiJam + " jam | Alat: " + alat;
    }

    @Override
    public double hitungBiayaPendaftaran() {
        return BIAYA_MATERI + (TARIF_PER_JAM * durasiJam);
    }

    @Override
    public String toString() {
        return super.toString() + "\n   " + getInfoTambahan();
    }
}
