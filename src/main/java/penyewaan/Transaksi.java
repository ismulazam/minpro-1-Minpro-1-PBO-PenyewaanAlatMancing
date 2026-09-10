/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penyewaan;

/**
 *
 * @author mismu
 */
public class Transaksi {
    private String idTransaksi;
    private String namaPenyewa;
    private String namaAlat;
    private int lamaSewaHari;

    public Transaksi(String idTransaksi, String namaPenyewa, String namaAlat, int lamaSewaHari) {
        this.idTransaksi = idTransaksi;
        this.namaPenyewa = namaPenyewa;
        this.namaAlat = namaAlat;
        setLamaSewaHari(lamaSewaHari);
    }

    public void setLamaSewaHari(int lamaSewaHari) {
        if (lamaSewaHari >= 1) {
            this.lamaSewaHari = lamaSewaHari;
        } else {
            System.out.println(">> ERROR VALIDASI: Lama sewa minimal 1 hari! Otomatis diset ke 1.");
            this.lamaSewaHari = 1;
        }
    }

    public void tampilkanTransaksi() {
        System.out.printf("%-10s | %-20s | %-20s | %-10d\n", idTransaksi, namaPenyewa, namaAlat, lamaSewaHari);
    }
}
