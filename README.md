
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

## Tampilan Program
### Menu Utama

Saat program dijalankan, pengguna melihat tujuh menu untuk mendaftarkan kunjungan, mengelola data pasien, melihat dan menyelesaikan kunjungan, serta keluar dari program.

<img width="623" height="410" alt="image" src="https://github.com/user-attachments/assets/a3687543-771a-4cbf-a43b-3b9d3f34d74e" />

*Gambar 1. Menu utama Sistem Manajemen Klinik.*

### Pendaftaran Kunjungan

Pada menu 1, petugas memilih pasien baru, mengisi nama, umur, dan keluhan, lalu memilih dokter yang menangani. Program membuat nomor kunjungan secara otomatis dengan status awal **Terdaftar**.

<img width="575" height="582" alt="image" src="https://github.com/user-attachments/assets/b340bdca-2b26-4096-b244-4e6212d1f291" />


*Gambar 2. Proses pendaftaran kunjungan pasien.*

### Lihat Daftar Pasien

Menu 2 menampilkan pasien yang sudah terdaftar. Setiap baris berisi ID, nama, umur, dan keluhan pasien.

<img width="683" height="147" alt="image" src="https://github.com/user-attachments/assets/5df4decd-e5c6-414b-9329-b18d47d2f5f2" />


*Gambar 3. Daftar pasien yang tersimpan dalam program.*

### Ubah Data Pasien

Menu 3 menampilkan daftar pasien terlebih dahulu. Petugas memilih ID pasien, lalu memasukkan nama, umur, dan keluhan yang baru. Setelah disimpan, perubahan terlihat pada daftar pasien.

<img width="732" height="653" alt="image" src="https://github.com/user-attachments/assets/26d74f80-d9ef-4a66-b61f-05804cd83683" />


*Gambar 4. Perubahan data pasien dan hasilnya pada daftar pasien.*

### Hapus Data Pasien

Menu 4 menampilkan daftar pasien dan meminta ID yang akan dihapus. Program meminta konfirmasi terlebih dahulu. Jika petugas menjawab `ya`, data pasien beserta kunjungannya dihapus.

<img width="677" height="587" alt="image" src="https://github.com/user-attachments/assets/f8af2ce1-aa06-4dd6-a917-4f9feb93363e" />


*Gambar 5. Penghapusan pasien setelah petugas memberikan konfirmasi.*

### Lihat Daftar Kunjungan

Menu 5 menampilkan kunjungan yang telah didaftarkan. Setiap kunjungan berisi nomor, tanggal, nama pasien, dokter yang menangani, dan statusnya.

<img width="932" height="372" alt="Screenshot 2026-09-21 094747" src="https://github.com/user-attachments/assets/f9476438-5ed4-4614-b7c0-14d169d0205d" />


*Gambar 6. Daftar kunjungan pasien dengan status Terdaftar.*

### Selesaikan Kunjungan

Pada menu 6, petugas memilih nomor kunjungan yang sudah selesai diperiksa. Program mengubah status kunjungan dari **Terdaftar** menjadi **Selesai**.

<img width="1021" height="532" alt="image" src="https://github.com/user-attachments/assets/495aa883-b6c9-48b9-8041-26e4ff7ad281" />


*Gambar 7. Perubahan status kunjungan menjadi Selesai.*

### Keluar Program

Menu 7 digunakan untuk mengakhiri program. Setelah dipilih, program menampilkan pesan **Program selesai**.

<img width="846" height="468" alt="image" src="https://github.com/user-attachments/assets/2bf182c6-ff36-44e9-ac87-ee3341768896" />

*Gambar 8. Program berakhir dengan BUILD SUCCESS.*

