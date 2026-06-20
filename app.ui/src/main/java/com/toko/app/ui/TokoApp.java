package com.toko.app.ui;

import com.toko.app.logic.TokoService;
import java.util.List;
import java.util.Scanner;

public class TokoApp {

    public static void main(String[] args) {
        TokoService service = new TokoService();
        Scanner scanner = new Scanner(System.in);

        int pilihan;
        do {
            System.out.println("\n=== Sistem Manajemen Toko Buku Digital ===");
            System.out.println("1. Lihat Daftar Buku");
            System.out.println("2. Beli Buku");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tampilkanDaftarBuku(service);
                    break;
                case 2:
                    prosesBeliBuku(scanner, service);
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 3);

        scanner.close();
    }

    private static void tampilkanDaftarBuku(TokoService service) {
        List<String> daftarBuku = service.getDaftarBukuFormatted();
        System.out.println("\n--- Daftar Buku ---");
        for (String b : daftarBuku) {
            System.out.println(b);
        }
    }

    private static void prosesBeliBuku(Scanner scanner, TokoService service) {
        scanner.nextLine(); // konsumsi sisa newline dari nextInt sebelumnya
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan jumlah beli: ");
        int jumlah = scanner.nextInt();

        if (service.prosesPembelian(judul, jumlah)) {
            double total = service.hitungTotal(judul, jumlah);
            System.out.println("Pembelian berhasil! Total: " + total);
        } else {
            System.out.println("Pembelian gagal. Cek judul atau stok buku.");
        }
    }
}