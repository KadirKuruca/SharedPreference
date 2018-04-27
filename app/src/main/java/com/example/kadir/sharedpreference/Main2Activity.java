package com.example.kadir.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView tvAd,tvMeslek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    public void removeProfessionKey(View view) {
    }

    public void clearData(View view) {
    }

    //İlk Activityde kaydedilen veriler okunuyor.
    public void loadData2(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+ ".myFile.xml",MODE_PRIVATE);
        String isim = sharedPreferences.getString(Sabitler.KEY_ISIM,"N/A");
        String meslek = sharedPreferences.getString(Sabitler.KEY_MESLEK,"N/A");
        int id = sharedPreferences.getInt(Sabitler.KEY_ID,0);

        tvAd.setText(isim.toString());
        tvMeslek.setText(meslek.toString());
        Toast.makeText(this,"Verileriniz Getirildi. ID : "+id,Toast.LENGTH_SHORT).show();
    }

    private void init() {
        tvAd = (TextView) findViewById(R.id.tvName);
        tvMeslek = (TextView) findViewById(R.id.tvJob);
    }
}
