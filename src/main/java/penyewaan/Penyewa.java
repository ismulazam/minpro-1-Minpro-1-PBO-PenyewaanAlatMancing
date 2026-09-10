/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penyewaan;

/**
 *
 * @author mismu
 */
public class Penyewa {
    private String idPenyewa;
    private String namaPenyewa;
    private String noTelp;

    public Penyewa(String idPenyewa, String namaPenyewa, String noTelp) {
        this.idPenyewa = idPenyewa;
        setNamaPenyewa(namaPenyewa);
        this.noTelp = noTelp;
    }

    public String getIdPenyewa() { return idPenyewa; }
    public String getNamaPenyewa() { return namaPenyewa; }
    
    public void setNamaPenyewa(String namaPenyewa) {
        if (namaPenyewa != null && !namaPenyewa.trim().isEmpty()) {
            this.namaPenyewa = namaPenyewa;
        } else {
            this.namaPenyewa = "Anonim";
        }
    }

    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
}
