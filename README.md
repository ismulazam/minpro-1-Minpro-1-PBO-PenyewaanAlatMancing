# Minpro-1-PBO-SistemPenyewaanAlatMancing

Oleh: Muhammad Ismul Azam Atmoko

## 1. Deskripsi Singkat Program
Sistem Manajemen Penyewaan Alat Mancing adalah aplikasi berbasis Console (CLI) yang dibangun menggunakan bahasa Java. Program ini dirancang untuk memudahkan admin atau pemilik toko dalam mengelola ketersediaan inventaris alat pancing (seperti joran dan reel) sekaligus mencatat riwayat transaksi penyewaan dari pelanggan. Program ini mendukung operasi CRUD (Create, Read, Update, Delete) sederhana dan penyimpanan data dinamis dalam memori menggunakan struktur data `ArrayList`.

## 2. Penjelasan Alur Program
Program dijalankan secara terpusat melalui entry point pada class `Main.java`. Berikut adalah alur kerjanya:
1. **Inisialisasi Data**: Saat program pertama kali berjalan, sistem otomatis menyiapkan `ArrayList` dan mengisi beberapa data awal (dummy data) untuk alat mancing agar daftar tidak kosong.
2. **Menu Utama**: Pengguna akan dihadapkan pada antarmuka menu interaktif yang dibungkus di dalam perulangan `while(berjalan)`. Program tidak akan berhenti sampai pengguna secara eksplisit memilih opsi keluar.
3. **Penerimaan Input**: Pengguna memilih tindakan dengan mengetikkan angka (1-7). Menggunakan kontrol struktur `switch-case`, program akan diarahkan ke blok kode yang sesuai dengan pilihan tersebut.
4. **Eksekusi Fitur Utama**:
   - **Tampilkan Data**: Melakukan iterasi pada `ArrayList` menggunakan `for-each` loop dan mencetak informasi alat menggunakan format cetak tabel yang rapi.
   - **Tambah Data**: Mengumpulkan input teks dan angka dari pengguna via `Scanner`, memanggil *Constructor* dari class `AlatMancing`, lalu menyimpannya ke dalam List.
   - **Update & Hapus**: Program meminta input ID, melakukan perulangan untuk mencari kecocokan ID menggunakan method `.equalsIgnoreCase()`. Jika ditemukan, data diubah atau dihapus menggunakan method `.remove()`.
   - **Transaksi**: Menghubungkan entitas yang berbeda dengan menginstansiasi objek `Penyewa` dan `Transaksi`, lalu mencatatnya ke List riwayat transaksi.
5. **Keluar**: Jika opsi 7 dipilih, nilai *boolean* perulangan diatur menjadi `false` dan eksekusi program akan ditutup.

## 3. Penjelasan Letak Penerapan Nilai Tambah
Sesuai dengan spesifikasi tugas, aplikasi ini telah mengimplementasikan konsep pilar Object-Oriented Programming (OOP) untuk menjaga integritas data:

* **Access Modifier (Private)**: Diterapkan pada seluruh atribut/properties di dalam kelas Model (yaitu `AlatMancing.java`, `Penyewa.java`, dan `Transaksi.java`). Atribut seperti `stok`, `namaAlat`, dan `lamaSewaHari` dilindungi dan tidak bisa disentuh secara langsung (*direct access*) dari class `Main`.
* **Encapsulation**: Atribut yang diproteksi dengan `private` tersebut dihubungkan melalui pintu perantara resmi, yakni method **Getter** dan **Setter** (misalnya `setStok()`, `getNamaAlat()`).
* **Validasi Input**: Berlaku secara ketat di dalam metode Setter. Sebagai contoh implementasinya:
  - Pada class `AlatMancing.java` bagian method `setStok(int stok)`, terdapat algoritma pengecekan `if(stok >= 0)`. Jika pengguna atau sistem secara tidak sengaja mencoba memasukkan stok bernilai negatif, sistem akan menolaknya, memunculkan pesan *error*, dan memaksa nilai kembali menjadi `0`.
  - Pada class `Transaksi.java`, terdapat logika pengecekan di method `setLamaSewaHari(int lamaSewaHari)` yang memvalidasi dan mencegah nilai penyewaan di bawah 1 hari.
  - Validasi ini juga dipanggil langsung di dalam *Constructor* saat objek pertama kali dibuat, memastikan tidak ada "jalur belakang" untuk memasukkan data yang cacat.
