package com.example.benimkitaplistem;

import android.graphics.Bitmap;

public class KitapDetayi { //listedeki kitaplara tıklandığında içerisindeki nesneleri almak için sınıf oluşturduk.

    private String kitapAdi,kitapYazari,kitapOzeti;
    private Bitmap kitapResimi;

    public KitapDetayi(String kitapAdi, String kitapYazari, String kitapOzeti, Bitmap kitapResimi) { //değerleri direk contructor ile alıyoruz.
        this.kitapAdi = kitapAdi;
        this.kitapYazari = kitapYazari;
        this.kitapOzeti = kitapOzeti;
        this.kitapResimi = kitapResimi;
    }

    public String getKitapAdi() { //nesneleri getter komutuyla alıcaz.
        return kitapAdi;
    }

    public String getKitapYazari() {
        return kitapYazari;
    }

    public String getKitapOzeti() {
        return kitapOzeti;
    }

    public Bitmap getKitapResimi() {
        return kitapResimi;
    }
}
