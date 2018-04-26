package com.example.kadir.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etAd,etMeslek;
    private TextView tvAd,tvMeslek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void loadData(View view) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        String isim = sharedPreferences.getString(Sabitler.KEY_ISIM,"N/A");
        String meslek = sharedPreferences.getString(Sabitler.KEY_MESLEK,"N/A");
        int id = sharedPreferences.getInt(Sabitler.KEY_ID,0);

        tvAd.setText(isim.toString());
        tvMeslek.setText(meslek.toString());
        Toast.makeText(this,"Verileriniz Getirildi. ID : "+id,Toast.LENGTH_SHORT).show();
    }

    //Veriler Kaydediliyor.
    public void saveData(View view) {

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Sabitler.KEY_ISIM,etAd.getText().toString());
        editor.putString(Sabitler.KEY_MESLEK,etMeslek.getText().toString());
        editor.putInt(Sabitler.KEY_ID,1);

        editor.apply();
        Toast.makeText(this,"Verileriniz Kaydedildi.",Toast.LENGTH_SHORT).show();
    }

    private void init() {
        etAd = (EditText) findViewById(R.id.etAd);
        etMeslek = (EditText) findViewById(R.id.etMeslek);
        tvAd = (TextView) findViewById(R.id.tvAd);
        tvMeslek = (TextView) findViewById(R.id.tvMeslek);
    }
}
