/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penyewaan;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author mismu
 */
public class Main {
    public static void main(String[] args) {
        // ArrayList untuk menyimpan data secara dinamis
        ArrayList<AlatMancing> daftarAlat = new ArrayList<>();
        ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

        // Data awal (Dummy) agar tabel tidak kosong
        daftarAlat.add(new AlatMancing("A001", "Joran Shimano", "Joran", 10));
        daftarAlat.add(new AlatMancing("A002", "Reel Daiwa", "Reel", 5));

        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\n==============================================");
            System.out.println(" SISTEM MANAJEMEN PENYEWAAN ALAT MANCING");
            System.out.println("==============================================");
            System.out.println("1. Tampilkan Data Alat Mancing");
            System.out.println("2. Tambah Alat Mancing Baru");
            System.out.println("3. Update Stok Alat Mancing");
            System.out.println("4. Hapus Alat Mancing");
            System.out.println("5. Catat Transaksi Sewa Baru");
            System.out.println("6. Tampilkan Riwayat Transaksi");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu (1-7): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear buffer newline dari nextInt()

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- DAFTAR ALAT MANCING ---");
                    if (daftarAlat.isEmpty()) {
                        System.out.println("Belum ada data alat mancing.");
                    } else {
                        System.out.printf("%-6s | %-25s | %-15s | %-5s\n", "ID", "Nama Alat", "Jenis", "Stok");
                        System.out.println("---------------------------------------------------------------");
                        for (AlatMancing alat : daftarAlat) {
                            alat.tampilkanInfo();
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- TAMBAH ALAT MANCING ---");
                    System.out.print("Masukkan ID Alat    : ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Nama Alat  : ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Jenis Alat : ");
                    String jenis = scanner.nextLine();
                    System.out.print("Masukkan Stok       : ");
                    int stok = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer

                    // Menginstansiasi objek baru & menambahkan ke ArrayList
                    AlatMancing alatBaru = new AlatMancing(id, nama, jenis, stok);
                    daftarAlat.add(alatBaru);
                    System.out.println(">> SUCCESS: Data alat mancing berhasil ditambahkan!");
                    break;

                case 3:
                    System.out.println("\n--- UPDATE STOK ALAT MANCING ---");
                    System.out.print("Masukkan ID Alat: ");
                    String idUpdate = scanner.nextLine();
                    AlatMancing alatDitemukan = null;

                    for (AlatMancing a : daftarAlat) {
                        if (a.getIdAlat().equalsIgnoreCase(idUpdate)) {
                            alatDitemukan = a;
                            break;
                        }
                    }

                    if (alatDitemukan != null) {
                        System.out.print("Masukkan Stok Baru: ");
                        int stokBaru = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer
                        alatDitemukan.setStok(stokBaru); // Terlindungi oleh validasi Setter
                        System.out.println(">> SUCCESS: Stok alat " + alatDitemukan.getNamaAlat() + " berhasil diupdate!");
                    } else {
                        System.out.println(">> ERROR: ID Alat tidak ditemukan!");
                    }
                    break;

                case 4:
                    System.out.println("\n--- HAPUS ALAT MANCING ---");
                    System.out.print("Masukkan ID Alat yang akan dihapus: ");
                    String idHapus = scanner.nextLine();
                    AlatMancing alatHapus = null;

                    for (AlatMancing a : daftarAlat) {
                        if (a.getIdAlat().equalsIgnoreCase(idHapus)) {
                            alatHapus = a;
                            break;
                        }
                    }

                    if (alatHapus != null) {
                        daftarAlat.remove(alatHapus);
                        System.out.println(">> SUCCESS: Alat '" + alatHapus.getNamaAlat() + "' berhasil dihapus!");
                    } else {
                        System.out.println(">> ERROR: ID Alat tidak ditemukan!");
                    }
                    break;

                case 5:
                    System.out.println("\n--- CATAT TRANSAKSI SEWA ---");
                    System.out.print("Masukkan ID Transaksi : ");
                    String idTrans = scanner.nextLine();
                    System.out.print("Masukkan Nama Penyewa : ");
                    String namaPenyewa = scanner.nextLine();
                    System.out.print("Masukkan Nama Alat    : ");
                    String namaAlatSewa = scanner.nextLine();
                    System.out.print("Masukkan Lama Sewa    : ");
                    int lama = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    
                    // Membuat instance profil penyewa baru (sebagai bukti pemakaian class ke-2)
                    Penyewa penyewa = new Penyewa("P-" + idTrans, namaPenyewa, "0812xxx");

                    // Membuat instance transaksi (pemakaian class ke-3)
                    Transaksi transaksiBaru = new Transaksi(idTrans, penyewa.getNamaPenyewa(), namaAlatSewa, lama);
                    daftarTransaksi.add(transaksiBaru);
                    System.out.println(">> SUCCESS: Transaksi penyewaan berhasil dicatat!");
                    break;

                case 6:
                    System.out.println("\n--- RIWAYAT TRANSAKSI ---");
                    if (daftarTransaksi.isEmpty()) {
                        System.out.println("Belum ada data transaksi.");
                    } else {
                        System.out.printf("%-10s | %-20s | %-20s | %-10s\n", "ID Trans", "Nama Penyewa", "Alat Disewa", "Lama (Hari)");
                        System.out.println("-------------------------------------------------------------------------");
                        for (Transaksi t : daftarTransaksi) {
                            t.tampilkanTransaksi();
                        }
                    }
                    break;

                case 7:
                    berjalan = false;
                    System.out.println("\nTerima kasih telah menggunakan sistem ini!");
                    break;

                default:
                    System.out.println(">> ERROR: Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}
