
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

## Class yang Digunakan

| Class | Peran |
|---|---|
| `Orang` | Class induk yang menyimpan ID dan nama |
| `Pasien` | Turunan dari `Orang`; menyimpan umur dan keluhan pasien |
| `Dokter` | Turunan dari `Orang`; menyimpan spesialisasi dokter |
| `Kunjungan` | Mencatat pasien, dokter, tanggal, nomor, dan status kunjungan |
| `Klinik` | Menyimpan daftar pasien, dokter, dan kunjungan |
| `SistemManajemenKlinik` | Menjalankan menu dan menerima pilihan pengguna |

## Struktur dan Hierarki Class

Susunan class pada proyek:

```text
Source Packages
├── main
│   └── SistemManajemenKlinik.java
└── model
    ├── Dokter.java
    ├── Klinik.java
    ├── Kunjungan.java
    ├── Orang.java
    └── Pasien.java
```

Hubungan pewarisan class:

```text
Orang
├── Dokter
└── Pasien
```



## Penerapan Inheritance

Program ini menggunakan inheritance pada class `Pasien` dan `Dokter`. Keduanya merupakan turunan dari class `Orang`.

Class `Orang` menyimpan data yang sama-sama dimiliki pasien dan dokter, yaitu `id` dan `nama`. Karena `Pasien` dan `Dokter` menggunakan `extends Orang`, kedua class tersebut tidak perlu menulis ulang atribut dan method untuk ID serta nama.

```java
public class Pasien extends Orang
public class Dokter extends Orang
```

Di dalam constructor `Pasien` dan `Dokter`, `super(id, nama)` digunakan untuk mengirim ID dan nama ke constructor `Orang`. Setelah itu, masing-masing class menyimpan data khususnya: `Pasien` menyimpan umur dan keluhan, sedangkan `Dokter` menyimpan spesialisasi.

- `Orang` menyimpan ID dan nama.
- `Dokter` mewarisi ID dan nama dari `Orang`, lalu menambahkan spesialisasi.
- `Pasien` mewarisi ID dan nama dari `Orang`, lalu menambahkan umur dan keluhan.
- `Kunjungan` mencatat pasien, dokter, tanggal, nomor, dan status kunjungan.
- `Klinik` menyimpan daftar pasien, dokter, dan kunjungan.
- `SistemManajemenKlinik` menjalankan menu program.
