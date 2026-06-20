package com.toko.app.logic;

import com.toko.app.data.Buku;
import com.toko.app.data.BukuRepository;
import java.util.ArrayList;
import java.util.List;

public class TokoService {
    private BukuRepository repository;

    public TokoService() {
        this.repository = new BukuRepository();
        muatDataAwal();
    }

    private void muatDataAwal() {
        repository.tambahBuku(new Buku("Laskar Pelangi", "Andrea Hirata", "Novel", 75000, 10));
        repository.tambahBuku(new Buku("Bumi Manusia", "Pramoedya Ananta Toer", "Novel", 85000, 5));
    }

    public List<String> getDaftarBukuFormatted() {
        List<String> hasil = new ArrayList<>();
        for (Buku b : repository.getSemuaBuku()) {
            hasil.add(b.toString());
        }
        return hasil;
    }

    public boolean validasiStok(String judulBuku, int jumlahBeli) {
        Buku buku = repository.cariBukuByJudul(judulBuku);
        if (buku == null) {
            return false;
        }
        return buku.getStok() >= jumlahBeli;
    }

    public double hitungTotal(String judulBuku, int jumlahBeli) {
        Buku buku = repository.cariBukuByJudul(judulBuku);
        if (buku == null) {
            return 0;
        }
        return buku.getHarga() * jumlahBeli;
    }

    public boolean prosesPembelian(String judulBuku, int jumlahBeli) {
        if (!validasiStok(judulBuku, jumlahBeli)) {
            return false;
        }
        Buku buku = repository.cariBukuByJudul(judulBuku);
        buku.setStok(buku.getStok() - jumlahBeli);
        return true;
    }
}