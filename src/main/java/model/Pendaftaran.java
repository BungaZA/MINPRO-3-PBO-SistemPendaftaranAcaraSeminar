package model;

import exception.KuotaPenuhException;

public interface Pendaftaran {
    void tambahPeserta(String namaPeserta) throws KuotaPenuhException;

    boolean isKuotaPenuh();

    int getSisaKuota();
}