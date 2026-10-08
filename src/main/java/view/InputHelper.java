package view;

import java.util.Scanner;
import java.util.function.Predicate;
import util.FormatUtil;
import util.InputValidator;

public class InputHelper {
    private final Scanner scanner;

    public InputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public void tutup() {
        scanner.close();
    }

    private String bacaTeks(String prompt, boolean opsional,
                            Predicate<String> valid, String pesanError) {
        while (true) {
            System.out.print(prompt);
            String masukan = scanner.nextLine().trim();
            if (masukan.isEmpty()) {
                if (opsional) {
                    return null;
                }
                System.out.println("[!] Input tidak boleh kosong.");
            } else if (valid.test(masukan)) {
                return masukan;
            } else {
                System.out.println("[!] " + pesanError);
            }
        }
    }

    private Integer bacaAngkaBulat(String prompt, boolean opsional,
                                   Predicate<Integer> valid, String pesanError) {
        while (true) {
            String masukan = bacaTeks(prompt, opsional, s -> true, "");
            if (masukan == null) {
                return null;
            }
            try {
                int nilai = Integer.parseInt(masukan);
                if (valid.test(nilai)) {
                    return nilai;
                }
                System.out.println("[!] " + pesanError);
            } catch (NumberFormatException e) {
                System.out.println("[!] Input harus berupa angka bulat.");
            }
        }
    }

    private Double bacaAngkaDesimal(String prompt, boolean opsional,
                                    Predicate<Double> valid, String pesanError) {
        while (true) {
            String masukan = bacaTeks(prompt, opsional, s -> true, "");
            if (masukan == null) {
                return null;
            }
            if (!masukan.matches("^\\d+(\\.\\d+)?$")) {
                System.out.println("[!] Input harus berupa angka tanpa pemisah ribuan (contoh: 50000).");
                continue;
            }
            double nilai = Double.parseDouble(masukan);
            if (valid.test(nilai)) {
                return nilai;
            }
            System.out.println("[!] " + pesanError);
        }
    }

    public int bacaPilihan(String prompt, int min, int max) {
        return bacaAngkaBulat(prompt, false, v -> v >= min && v <= max,
                "Pilihan harus antara " + min + " dan " + max + ".");
    }

    public int bacaId(String prompt) {
        return bacaAngkaBulat(prompt, false, v -> v > 0, "ID harus berupa bilangan positif.");
    }

    public String bacaNamaAcara(String prompt, boolean opsional) {
        return bacaTeks(prompt, opsional, InputValidator::validasiNamaAcara,
                "Nama harus " + InputValidator.PANJANG_MIN + "-" + InputValidator.PANJANG_MAKS
                        + " karakter, hanya huruf, angka, spasi, dan tanda . , : & -");
    }

    public String bacaNamaOrang(String prompt, boolean opsional) {
        return bacaTeks(prompt, opsional, InputValidator::validasiNamaOrang,
                "Nama harus " + InputValidator.PANJANG_MIN + "-" + InputValidator.PANJANG_MAKS
                        + " karakter, hanya huruf, spasi, dan tanda . , ' -");
    }

    public String bacaTeksUmum(String prompt, boolean opsional) {
        return bacaTeks(prompt, opsional, InputValidator::validasiTeks,
                "Isian harus " + InputValidator.PANJANG_MIN + "-" + InputValidator.PANJANG_MAKS
                        + " karakter dan mengandung huruf (simbol yang boleh: . , & / ( ) -)");
    }

    public String bacaKataKunci(String prompt) {
        return bacaTeks(prompt, false, InputValidator::validasiKataKunci,
                "Kata kunci maksimal " + InputValidator.PANJANG_MAKS + " karakter.");
    }

    public String bacaEmail(String prompt, boolean opsional) {
        return bacaTeks(prompt, opsional, InputValidator::validasiEmail,
                "Format email tidak valid (contoh: nama@email.com).");
    }

    public String bacaTanggal(String prompt, boolean opsional) {
        while (true) {
            String tanggal = bacaTeks(prompt, opsional, InputValidator::validasiTanggal,
                    "Tanggal tidak valid. Gunakan format YYYY-MM-DD dan tanggal yang benar-benar ada.");
            if (tanggal == null || InputValidator.validasiTanggalTidakLampau(tanggal)) {
                return tanggal;
            }
            System.out.println("[!] Tanggal tidak boleh sebelum hari ini.");
        }
    }

    public Integer bacaKuota(String prompt, boolean opsional) {
        return bacaAngkaBulat(prompt, opsional, InputValidator::validasiKuota,
                "Kuota harus antara " + InputValidator.KUOTA_MINIMAL + " dan "
                        + InputValidator.KUOTA_MAKSIMAL + ".");
    }

    public Integer bacaDurasi(String prompt, boolean opsional) {
        return bacaAngkaBulat(prompt, opsional, InputValidator::validasiDurasi,
                "Durasi harus antara " + InputValidator.DURASI_MINIMAL + " dan "
                        + InputValidator.DURASI_MAKSIMAL + " jam.");
    }

    public Double bacaBiaya(String prompt, boolean opsional) {
        return bacaAngkaDesimal(prompt, opsional, InputValidator::validasiBiaya,
                "Biaya harus 0 (gratis) atau antara "
                        + FormatUtil.rupiah(InputValidator.BIAYA_MINIMAL) + " dan "
                        + FormatUtil.rupiah(InputValidator.BIAYA_MAKSIMAL) + ".");
    }

    public boolean bacaKonfirmasi(String prompt) {
        while (true) {
            System.out.print(prompt);
            String masukan = scanner.nextLine().trim();
            if (masukan.equalsIgnoreCase("y")) {
                return true;
            }
            if (masukan.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("[!] Jawab dengan 'y' atau 'n'.");
        }
    }
}
