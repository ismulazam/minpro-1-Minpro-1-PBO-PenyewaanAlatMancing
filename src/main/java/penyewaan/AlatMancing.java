/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penyewaan;

/**
 *
 * @author mismu
 */
public class AlatMancing {
    private String idAlat;
    private String namaAlat;
    private String jenis;
    private int stok;

    public AlatMancing(String idAlat, String namaAlat, String jenis, int stok) {
        this.idAlat = idAlat;
        setNamaAlat(namaAlat);
        this.jenis = jenis;
        setStok(stok); 
    }

    public String getIdAlat() { return idAlat; }
    public void setIdAlat(String idAlat) { this.idAlat = idAlat; }

    public String getNamaAlat() { return namaAlat; }
    public void setNamaAlat(String namaAlat) {
        if (namaAlat != null && !namaAlat.trim().isEmpty()) {
            this.namaAlat = namaAlat;
        } else {
            System.out.println(">> ERROR VALIDASI: Nama alat tidak boleh kosong! Set ke 'Tanpa Nama'.");
            this.namaAlat = "Tanpa Nama";
        }
    }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public int getStok() { return stok; }
    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            System.out.println(">> ERROR VALIDASI: Stok tidak boleh negatif (" + stok + ")! Stok di-set ke 0.");
            this.stok = 0;
        }
    }

    public void tampilkanInfo() {
        System.out.printf("%-6s | %-25s | %-15s | %-5d\n", idAlat, namaAlat, jenis, stok);
    }
}
