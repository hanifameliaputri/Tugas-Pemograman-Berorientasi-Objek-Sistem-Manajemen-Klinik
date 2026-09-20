/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */

public class Kunjungan {
    private final int nomor;
    private final Pasien pasien;
    private final Dokter dokter;
    private final String tanggal;
    private String status;

    public Kunjungan(int nomor, Pasien pasien, Dokter dokter, String tanggal) {
        this.nomor = nomor;
        this.pasien = pasien;
        this.dokter = dokter;
        this.tanggal = tanggal;
        this.status = "Terdaftar";
    }

    public int getNomor() {
        return nomor;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void selesaikan() {
        this.status = "Selesai";
    }
}