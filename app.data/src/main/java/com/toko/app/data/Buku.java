package com.toko.app.data;

public class Buku {
    private String judul;
    private String penulis;
    private String kategori;
    private double harga;
    private int stok;

    public Buku(String judul, String penulis, String kategori, double harga, int stok) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getKategori() {
        return kategori;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return judul + " oleh " + penulis + " (Kategori: " + kategori + ", Harga: " + harga + ", Stok: " + stok + ")";
    }
}