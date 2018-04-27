package com.example.kadir.sharedpreference;

import java.util.List;

/**
 * Created by Kadir on 27.04.2018.
 */

public class Calisan {

    private String isim;
    private String meslek;
    private Integer id;
    private List<String> gorev;
    private Boolean aktif;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getMeslek() {
        return meslek;
    }

    public void setMeslek(String meslek) {
        this.meslek = meslek;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getGorev() {
        return gorev;
    }

    public void setGorev(List<String> gorev) {
        this.gorev = gorev;
    }

    public Boolean getAktif() {
        return aktif;
    }

    public void setAktif(Boolean aktif) {
        this.aktif = aktif;
    }
}
