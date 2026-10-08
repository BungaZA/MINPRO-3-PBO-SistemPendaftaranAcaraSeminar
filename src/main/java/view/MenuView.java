package view;

import java.util.List;
import model.Acara;
import util.FormatUtil;

public class MenuView {
    private static final String GARIS = "----------------------------------";

    public void tampilkanBanner() {
        System.out.println("==========================================");
        System.out.println(" SISTEM MANAJEMEN ACARA SEMINAR & WORKSHOP");
        System.out.println("==========================================");
    }

    public void tampilkanMenu() {
        System.out.println("\n=== MENU UTAMA ===");
        System.out.println("1. Tambah Seminar");
        System.out.println("2. Tambah Workshop");
        System.out.println("3. Lihat Daftar Acara");
        System.out.println("4. Cari Acara");
        System.out.println("5. Update Acara");
        System.out.println("6. Hapus Acara");
        System.out.println("7. Daftar Peserta");
        System.out.println("0. Keluar");
    }

    public void tampilkanSubmenuCari() {
        System.out.println("1. Cari berdasarkan ID");
        System.out.println("2. Cari berdasarkan kata kunci (nama/pemateri)");
    }

    public void tampilkanJudul(String judul) {
        System.out.println("\n=== " + judul + " ===");
    }

    public void pesanSukses(String pesan) {
        System.out.println("[OK] " + pesan);
    }

    public void pesanError(String pesan) {
        System.out.println("[!] " + pesan);
    }

    public void pesanInfo(String pesan) {
        System.out.println(pesan);
    }

    public void tampilkanPenutup() {
        System.out.println("\nTerima kasih. Program selesai.");
    }

    public void tampilkanDaftarAcara(List<Acara> daftar) {
        tampilkanDaftarAcara("DAFTAR ACARA", daftar);
    }

    public void tampilkanDaftarAcara(String judul, List<Acara> daftar) {
        tampilkanJudul(judul);
        if (daftar.isEmpty()) {
            pesanInfo("Belum ada acara yang terdaftar.");
            return;
        }
        pesanInfo("Total Acara: " + daftar.size());
        for (Acara a : daftar) {
            System.out.println(a);
            System.out.println("   Biaya Pendaftaran: " + FormatUtil.rupiah(a.hitungBiayaPendaftaran()));
            System.out.println(GARIS);
        }
    }

    public void tampilkanDetailAcara(Acara acara) {
        System.out.println("\nDetail Acara:");
        System.out.println(acara);
        System.out.println("   Biaya Pendaftaran: " + FormatUtil.rupiah(acara.hitungBiayaPendaftaran()));
        System.out.println("Daftar Peserta:");
        if (acara.getDaftarPeserta().isEmpty()) {
            System.out.println("   (belum ada peserta)");
        } else {
            for (String peserta : acara.getDaftarPeserta()) {
                System.out.println("   - " + peserta);
            }
        }
    }

    public void tampilkanStruk(Acara acara, String namaPeserta) {
        pesanSukses("Pendaftaran berhasil.");
        System.out.println("Nama Peserta : " + namaPeserta);
        System.out.println("Acara        : " + acara.getNama() + " (" + acara.getJenis() + ")");
        System.out.println("Biaya        : " + FormatUtil.rupiah(acara.hitungBiayaPendaftaran()));
        System.out.println("Sisa Kuota   : " + acara.getSisaKuota());
    }
}
