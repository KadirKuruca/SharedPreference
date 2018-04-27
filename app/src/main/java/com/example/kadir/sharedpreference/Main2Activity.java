package com.example.kadir.sharedpreference;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView tvAd,tvMeslek;
    ConstraintLayout pageLayout2;
    boolean s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    //Verilerin kaydedildiği dosyadaki remove() metoduna parametre verilen veri silinir.
    public void removeProfessionKey(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+ ".myFile.xml",MODE_PRIVATE);
        int id = sharedPreferences.getInt(Sabitler.KEY_ID,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(Sabitler.KEY_ID);

        editor.apply();
        Toast.makeText(this,"Verileriniz Getirildi. ID : "+id,Toast.LENGTH_SHORT).show();
    }

    //Verilerin kaydedildiği dosyadaki tüm veriler silinir.
    public void clearData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+ ".myFile.xml",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();
    }

    //İlk Activityde kaydedilen veriler okunuyor.
    public void loadData2(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+ ".myFile.xml",MODE_PRIVATE);
        String isim = sharedPreferences.getString(Sabitler.KEY_ISIM,"N/A");
        String meslek = sharedPreferences.getString(Sabitler.KEY_MESLEK,"N/A");
        int id = sharedPreferences.getInt(Sabitler.KEY_ID,0);
        s = sharedPreferences.getBoolean(Sabitler.KEY_SWITCH.toString(),false);

        tvAd.setText(isim.toString());
        tvMeslek.setText(meslek.toString());
        if(s == true){
            pageLayout2.setBackgroundResource(R.color.myGreen);
        }
        else
            pageLayout2.setBackgroundColor(Color.WHITE);
        Toast.makeText(this,"Verileriniz Getirildi. ID : "+id,Toast.LENGTH_SHORT).show();
    }

    private void init() {
        tvAd = (TextView) findViewById(R.id.tvName);
        tvMeslek = (TextView) findViewById(R.id.tvJob);
        pageLayout2 = (ConstraintLayout) findViewById(R.id.pageLayout2);
    }
}
