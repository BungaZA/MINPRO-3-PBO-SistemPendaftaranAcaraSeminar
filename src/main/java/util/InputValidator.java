package util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public final class InputValidator {
    public static final int PANJANG_MIN = 3;
    public static final int PANJANG_MAKS = 60;
    public static final int KUOTA_MINIMAL = 1;
    public static final int KUOTA_MAKSIMAL = 500;
    public static final int DURASI_MINIMAL = 1;
    public static final int DURASI_MAKSIMAL = 12;
    public static final double BIAYA_MINIMAL = 10000;
    public static final double BIAYA_MAKSIMAL = 5000000;

    private InputValidator() {
    }

    private static boolean panjangValid(String teks) {
        return teks != null
                && teks.trim().length() >= PANJANG_MIN
                && teks.trim().length() <= PANJANG_MAKS;
    }

    public static boolean validasiNamaAcara(String nama) {
        return panjangValid(nama)
                && nama.trim().matches("^[a-zA-Z0-9 .,:&-]+$")
                && nama.matches(".*[a-zA-Z].*");
    }

    public static boolean validasiNamaOrang(String nama) {
        return panjangValid(nama) && nama.trim().matches("^[a-zA-Z .,'-]+$");
    }

    public static boolean validasiTeks(String teks) {
        return panjangValid(teks)
                && teks.trim().matches("^[a-zA-Z0-9 .,&/()-]+$")
                && teks.matches(".*[a-zA-Z].*");
    }

    public static boolean validasiTanggal(String tanggal) {
        if (tanggal == null || !tanggal.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            return false;
        }
        try {
            LocalDate.parse(tanggal);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean validasiTanggalTidakLampau(String tanggal) {
        if (!validasiTanggal(tanggal)) {
            return false;
        }
        return !LocalDate.parse(tanggal).isBefore(LocalDate.now());
    }

    public static boolean validasiKuota(int kuota) {
        return kuota >= KUOTA_MINIMAL && kuota <= KUOTA_MAKSIMAL;
    }

    public static boolean validasiBiaya(double biaya) {
        return biaya == 0 || (biaya >= BIAYA_MINIMAL && biaya <= BIAYA_MAKSIMAL);
    }

    public static boolean validasiDurasi(int durasi) {
        return durasi >= DURASI_MINIMAL && durasi <= DURASI_MAKSIMAL;
    }

    public static boolean validasiEmail(String email) {
        return email != null
                && email.length() <= PANJANG_MAKS
                && email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public static boolean validasiKataKunci(String kata) {
        return kata != null && !kata.trim().isEmpty() && kata.trim().length() <= PANJANG_MAKS;
    }
}
