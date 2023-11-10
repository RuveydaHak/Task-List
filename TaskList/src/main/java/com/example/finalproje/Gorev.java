package com.example.finalproje;

public class Gorev {
    private int id;
    private String gorev_adi;
    private String gorev_tanimi;
    private String gorev_oncelik;
    private String gorev_durum;

    public Gorev(int id, String gorev_adi, String gorev_tanimi, String gorev_oncelik, String gorev_durum) {
        this.id = id;
        this.gorev_adi = gorev_adi;
        this.gorev_tanimi = gorev_tanimi;
        this.gorev_oncelik = gorev_oncelik;
        this.gorev_durum = gorev_durum;
    }
    public Gorev(String gorev_adi, String gorev_tanimi, String gorev_oncelik, String gorev_durum) {
        this.gorev_adi = gorev_adi;
        this.gorev_tanimi = gorev_tanimi;
        this.gorev_oncelik = gorev_oncelik;
        this.gorev_durum = gorev_durum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGorev_adi() {
        return gorev_adi;
    }

    public void setGorev_adi(String gorev_adi) {
        this.gorev_adi = gorev_adi;
    }

    public String getGorev_tanimi() {
        return gorev_tanimi;
    }

    public void setGorev_tanim(String gorev_tanimi) {
        this.gorev_tanimi = gorev_tanimi;
    }

    public String getGorev_oncelik() {
        return gorev_oncelik;
    }

    public void setGorev_oncelik(String gorev_oncelik) {
        this.gorev_oncelik = gorev_oncelik;
    }

    public String getGorev_durum() {
        return gorev_durum;
    }

    public void setGorev_durum(String gorev_durum) {
        this.gorev_durum = gorev_durum;
    }
}

