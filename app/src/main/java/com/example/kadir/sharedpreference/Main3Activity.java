package com.example.kadir.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Arrays;

public class Main3Activity extends AppCompatActivity {

    public TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
    }

    public void saveGsonData(View view) {

        Calisan calisan = calisanOlustur();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Gson ile Calisan sinifindan calisan nesnesi String'e çevrildi ve kaydedildi.
        Gson gson = new Gson();
        String gsonStr = gson.toJson(calisan,Calisan.class);
        editor.putString("calisan_key",gsonStr);
        Log.e("Calisan Kaydedildi : ",gsonStr);

        editor.apply();
    }

    public void loadGsonData(View view) {

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String gsonVeri = sharedPreferences.getString("calisan_key","");
        Log.e("KADİR","Load Data : "+gsonVeri);

        Gson gsonToStr = new Gson();
        Calisan calisan = gsonToStr.fromJson(gsonVeri,Calisan.class);

        calisanGoster(calisan);
    }

    private void calisanGoster(Calisan calisan) {

        String goster = calisan.getIsim()+"\n"+
                calisan.getMeslek()+"\n"+
                calisan.getGorev()+"\n"+
                (calisan.getAktif() ? "Çalışıyor" : "Çalışmıyor")+"\n"+
                "ID = "+calisan.getId();

        tvData.setText(goster);
    }

    private void init() {
        tvData = findViewById(R.id.tvData);
    }

    private Calisan calisanOlustur(){

        Calisan calisan = new Calisan();
        calisan.setIsim("Kadir");
        calisan.setMeslek("Mühendis");
        calisan.setAktif(true);
        calisan.setGorev(Arrays.asList("Yönetici","Developer"));
        calisan.setId(1);

        return calisan;
    }
}
