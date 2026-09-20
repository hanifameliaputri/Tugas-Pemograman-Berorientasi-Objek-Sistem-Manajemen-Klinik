
# Sistem Manajemen Klinik

**Nama:** Hanif Amelia Putri 

**NIM:** 2509116075  

**Mata kuliah:** Pemrograman Berorientasi Objek (PBO)

## Deskripsi Program

Sistem Manajemen Klinik adalah program Java untuk mencatat pasien yang berobat. Petugas memilih pasien dan dokter yang menangani melalui menu yang tersedia.

Saat memilih menu pendaftaran, petugas menentukan apakah pasien tersebut baru atau sudah pernah terdaftar. Untuk pasien baru, petugas mengisi nama, umur, dan keluhan. Untuk pasien lama, petugas cukup memilih ID pasien dari daftar yang sudah ada. Setelah itu, program menampilkan pilihan dokter. Petugas memilih dokter yang menangani pasien, lalu program membuat nomor kunjungan dan mencatat tanggal secara otomatis. Status awal setiap kunjungan adalah **Terdaftar**.

Petugas dapat melihat daftar pasien dan daftar kunjungan yang telah dicatat. Jika ada kesalahan pada nama, umur, atau keluhan, data pasien dapat diubah. Petugas juga dapat menghapus data pasien beserta kunjungannya setelah memberikan konfirmasi. Setelah pemeriksaan selesai, status kunjungan dapat diubah menjadi **Selesai**.

Data pasien dan kunjungan disimpan sementara menggunakan `ArrayList`. Karena belum menggunakan database atau file penyimpanan, data tersebut akan kosong kembali saat program ditutup.

## Fitur Program

1. Mendaftarkan kunjungan pasien baru atau pasien lama
2. Memilih dokter yang menangani pasien
3. Melihat daftar pasien
4. Mengubah data pasien
5. Menghapus pasien dan seluruh kunjungannya
6. Melihat daftar kunjungan
7. Menyelesaikan kunjungan

## Menu Program

```text
1. Daftarkan kunjungan pasien
2. Lihat daftar pasien
3. Ubah data pasien
4. Hapus data pasien
5. Lihat daftar kunjungan
6. Selesaikan kunjungan
7. Keluar
```
