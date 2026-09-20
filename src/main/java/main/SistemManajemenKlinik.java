/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

/**
 *
 * @author User
 */


import java.time.LocalDate;
import java.util.Scanner;
import model.Dokter;
import model.Klinik;
import model.Kunjungan;
import model.Pasien;

public class SistemManajemenKlinik {
    private static final Scanner input = new Scanner(System.in);
    private static final Klinik klinik = new Klinik();

    private static int idPasienBerikutnya = 1;
    private static int nomorKunjunganBerikutnya = 1;

    public static void main(String[] args) {
        // Data dokter contoh yang tersedia di klinik
        klinik.tambahDokter(new Dokter(1, "Hanif", "Umum"));
        klinik.tambahDokter(new Dokter(2, "Amelia", "Gigi"));

        int pilihan;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN KLINIK ===");
            System.out.println("1. Daftarkan kunjungan pasien");
            System.out.println("2. Lihat daftar pasien");
            System.out.println("3. Ubah data pasien");
            System.out.println("4. Hapus data pasien");
            System.out.println("5. Lihat daftar kunjungan");
            System.out.println("6. Selesaikan kunjungan");
            System.out.println("7. Keluar");

            pilihan = bacaAngka("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    daftarkanKunjungan();
                    break;
                case 2:
                    lihatPasien();
                    break;
                case 3:
                    ubahPasien();
                    break;
                case 4:
                    hapusPasien();
                    break;
                case 5:
                    lihatKunjungan();
                    break;
                case 6:
                    selesaikanKunjungan();
                    break;
                case 7:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 7);
    }

    private static void daftarkanKunjungan() {
        System.out.println("\n=== PENDAFTARAN KUNJUNGAN ===");
        System.out.println("1. Pasien baru");
        System.out.println("2. Pasien sudah terdaftar");

        int jenisPasien = bacaAngka("Pilih jenis pasien: ");
        Pasien pasien;
        boolean pasienBaru = false;

        switch (jenisPasien) {
            case 1 -> {
                String nama = bacaTeks("Nama pasien: ");
                int umur = bacaAngka("Umur: ");
                String keluhan = bacaTeks("Keluhan: ");
                pasien = new Pasien(
                        idPasienBerikutnya, nama, umur, keluhan
                );  pasienBaru = true;
            }
            case 2 -> {
                if (klinik.getDaftarPasien().isEmpty()) {
                    System.out.println("Belum ada pasien terdaftar.");
                    return;
                }   lihatPasien();
                int id = bacaAngka("ID pasien: ");
                pasien = klinik.cariPasien(id);
                if (pasien == null) {
                    System.out.println("Pasien tidak ditemukan.");
                    return;
                }
            }
            default -> {
                System.out.println("Pilihan jenis pasien tidak tersedia.");
                return;
            }
        }

        System.out.println("\nDokter tersedia:");
        for (Dokter dokter : klinik.getDaftarDokter()) {
            System.out.println(
                dokter.getId() + ". dr. " + dokter.getNama()
                + " — " + dokter.getSpesialisasi()
            );
        }

        int idDokter = bacaAngka("Pilih ID dokter: ");
        Dokter dokter = klinik.cariDokter(idDokter);

        if (dokter == null) {
            System.out.println("Dokter tidak ditemukan. Pendaftaran dibatalkan.");
            return;
        }

        if (pasienBaru) {
            klinik.tambahPasien(pasien);
            idPasienBerikutnya++;
        }

        Kunjungan kunjungan = new Kunjungan(
            nomorKunjunganBerikutnya,
            pasien,
            dokter,
            LocalDate.now().toString()
        );

        klinik.tambahKunjungan(kunjungan);
        nomorKunjunganBerikutnya++;

        System.out.println("\nKunjungan berhasil didaftarkan.");
        System.out.println("Nomor kunjungan : " + kunjungan.getNomor());
        System.out.println("ID pasien       : " + pasien.getId());
        System.out.println("Pasien          : " + pasien.getNama());
        System.out.println("Dokter          : dr. " + dokter.getNama());
        System.out.println("Status          : " + kunjungan.getStatus());
    }

    private static void lihatPasien() {
        if (klinik.getDaftarPasien().isEmpty()) {
            System.out.println("Belum ada pasien.");
            return;
        }

        System.out.println("\n=== DAFTAR PASIEN ===");
        for (Pasien pasien : klinik.getDaftarPasien()) {
            System.out.println(
                "ID: " + pasien.getId()
                + " | Nama: " + pasien.getNama()
                + " | Umur: " + pasien.getUmur()
                + " | Keluhan: " + pasien.getKeluhan()
            );
        }
    }

    private static void ubahPasien() {
        if (klinik.getDaftarPasien().isEmpty()) {
            System.out.println("Belum ada pasien yang bisa diubah.");
            return;
        }

        lihatPasien();
        int id = bacaAngka("ID pasien yang akan diubah: ");
        Pasien pasien = klinik.cariPasien(id);

        if (pasien == null) {
            System.out.println("Pasien tidak ditemukan.");
            return;
        }

        String nama = bacaTeks("Nama baru: ");
        int umur = bacaAngka("Umur baru: ");
        String keluhan = bacaTeks("Keluhan baru: ");

        pasien.setNama(nama);
        pasien.setUmur(umur);
        pasien.setKeluhan(keluhan);

        System.out.println("Data pasien berhasil diubah.");
    }

    private static void hapusPasien() {
        if (klinik.getDaftarPasien().isEmpty()) {
            System.out.println("Belum ada pasien yang bisa dihapus.");
            return;
        }

        lihatPasien();
        int id = bacaAngka("ID pasien yang akan dihapus: ");
        Pasien pasien = klinik.cariPasien(id);

        if (pasien == null) {
            System.out.println("Pasien tidak ditemukan.");
            return;
        }

        String konfirmasi = bacaTeks(
            "Hapus pasien dan seluruh kunjungannya? (ya/tidak): "
        );

        if (!konfirmasi.equalsIgnoreCase("ya")) {
            System.out.println("Penghapusan dibatalkan.");
            return;
        }

        klinik.getDaftarKunjungan().removeIf(
            kunjungan -> kunjungan.getPasien().getId() == id
        );
        klinik.hapusPasien(id);

        System.out.println("Pasien dan kunjungannya berhasil dihapus.");
    }

    private static void lihatKunjungan() {
        if (klinik.getDaftarKunjungan().isEmpty()) {
            System.out.println("Belum ada kunjungan.");
            return;
        }

        System.out.println("\n=== DAFTAR KUNJUNGAN ===");
        for (Kunjungan kunjungan : klinik.getDaftarKunjungan()) {
            System.out.println(
                "No: " + kunjungan.getNomor()
                + " | Tanggal: " + kunjungan.getTanggal()
                + " | Pasien: " + kunjungan.getPasien().getNama()
                + " | Dokter: dr. " + kunjungan.getDokter().getNama()
                + " | Status: " + kunjungan.getStatus()
            );
        }
    }

    private static void selesaikanKunjungan() {
        if (klinik.getDaftarKunjungan().isEmpty()) {
            System.out.println("Belum ada kunjungan.");
            return;
        }

        lihatKunjungan();
        int nomor = bacaAngka("Nomor kunjungan yang selesai: ");

        for (Kunjungan kunjungan : klinik.getDaftarKunjungan()) {
            if (kunjungan.getNomor() == nomor) {
                if (kunjungan.getStatus().equals("Selesai")) {
                    System.out.println("Kunjungan ini sudah selesai.");
                } else {
                    kunjungan.selesaikan();
                    System.out.println("Kunjungan berhasil diselesaikan.");
                }
                return;
            }
        }

        System.out.println("Nomor kunjungan tidak ditemukan.");
    }

    private static String bacaTeks(String pesan) {
        while (true) {
            System.out.print(pesan);
            String teks = input.nextLine().trim();

            if (!teks.isEmpty()) {
                return teks;
            }

            System.out.println("Input tidak boleh kosong.");
        }
    }

    private static int bacaAngka(String pesan) {
        while (true) {
            System.out.print(pesan);
            String teks = input.nextLine().trim();

            try {
                return Integer.parseInt(teks);
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }
    }
}