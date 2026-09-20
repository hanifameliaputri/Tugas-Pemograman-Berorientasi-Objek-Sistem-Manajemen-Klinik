/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */


import java.util.ArrayList;

public class Klinik {
    private final ArrayList<Pasien> daftarPasien = new ArrayList<>();
    private final ArrayList<Dokter> daftarDokter = new ArrayList<>();
    private final ArrayList<Kunjungan> daftarKunjungan = new ArrayList<>();

    public void tambahPasien(Pasien pasien) {
        daftarPasien.add(pasien);
    }

    public Pasien cariPasien(int id) {
        for (Pasien pasien : daftarPasien) {
            if (pasien.getId() == id) {
                return pasien;
            }
        }
        return null;
    }

    public boolean hapusPasien(int id) {
        Pasien pasien = cariPasien(id);
        if (pasien == null) {
            return false;
        }

        daftarPasien.remove(pasien);
        return true;
    }

    public ArrayList<Pasien> getDaftarPasien() {
        return daftarPasien;
    }

    public void tambahDokter(Dokter dokter) {
        daftarDokter.add(dokter);
    }

    public Dokter cariDokter(int id) {
        for (Dokter dokter : daftarDokter) {
            if (dokter.getId() == id) {
                return dokter;
            }
        }
        return null;
    }

    public ArrayList<Dokter> getDaftarDokter() {
        return daftarDokter;
    }

    public void tambahKunjungan(Kunjungan kunjungan) {
        daftarKunjungan.add(kunjungan);
    }

    public ArrayList<Kunjungan> getDaftarKunjungan() {
        return daftarKunjungan;
    }
}