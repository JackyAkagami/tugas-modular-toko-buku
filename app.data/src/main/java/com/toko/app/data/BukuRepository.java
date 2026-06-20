package com.toko.app.data;

import java.util.ArrayList;
import java.util.List;

public class BukuRepository {
    private List<Buku> daftarBuku;

    public BukuRepository() {
        this.daftarBuku = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public List<Buku> getSemuaBuku() {
        return daftarBuku;
    }

    public Buku cariBukuByJudul(String judul) {
        for (Buku b : daftarBuku) {
            if (b.getJudul().equalsIgnoreCase(judul)) {
                return b;
            }
        }
        return null;
    }
}