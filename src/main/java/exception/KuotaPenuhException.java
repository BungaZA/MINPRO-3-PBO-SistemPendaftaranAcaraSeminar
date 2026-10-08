package exception;

public class KuotaPenuhException extends Exception {
    public KuotaPenuhException(String namaAcara, int jumlahPendaftar, int kuota) {
        super("Maaf, kuota acara '" + namaAcara + "' sudah penuh ("
                + jumlahPendaftar + "/" + kuota + ").");
    }
}
