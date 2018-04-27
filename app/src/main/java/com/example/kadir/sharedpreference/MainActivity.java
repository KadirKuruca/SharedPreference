package com.example.kadir.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etAd,etMeslek;
    private TextView tvAd,tvMeslek;
    private Switch aSwitch;
    private ConstraintLayout pageLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                arkaPlanDegistir(b);
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+".myFile.xml",MODE_PRIVATE);
        boolean isChecked = sharedPreferences.getBoolean(Sabitler.KEY_SWITCH.toString(),false);
        aSwitch.setChecked(isChecked);
    }

    private void arkaPlanDegistir(boolean b) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+".myFile.xml",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(Sabitler.KEY_SWITCH.toString(),b);
        editor.apply();
        if(b == true){
            pageLayout.setBackgroundResource(R.color.myGreen);
        }
        else
            pageLayout.setBackgroundColor(Color.WHITE);


    }

    //Verileri Application Düzeyinde okuyoruz.
    public void loadData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+ ".myFile.xml",MODE_PRIVATE);
        String isim = sharedPreferences.getString(Sabitler.KEY_ISIM,"N/A");
        String meslek = sharedPreferences.getString(Sabitler.KEY_MESLEK,"N/A");
        int id = sharedPreferences.getInt(Sabitler.KEY_ID,0);
        boolean s = sharedPreferences.getBoolean(Sabitler.KEY_SWITCH.toString(),false);

        tvAd.setText(isim.toString());
        tvMeslek.setText(meslek.toString());
        Toast.makeText(this,"Verileriniz Getirildi. ID : "+id+" Switch Durumu : "+s,Toast.LENGTH_SHORT).show();
    }

    //Veriler Application Düzeyinde Kaydediliyor.
    public void saveData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + ".myFile.xml",MODE_PRIVATE);
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
        tvAd = (TextView) findViewById(R.id.tvName);
        tvMeslek = (TextView) findViewById(R.id.tvMeslek);
        aSwitch = (Switch) findViewById(R.id.switch1);
        pageLayout = (ConstraintLayout) findViewById(R.id.pageLayout);
    }

    public void applicationDuzeyineGit(View view) {

        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }

    public void gsonDuzeyineGit(View view) {
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
}
