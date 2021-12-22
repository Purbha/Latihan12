package com.ims_hr.latihan12;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView LV_Nama;
    String[] List_Nama = new String[] {"Andi","Agus","April","Inara","Almaira"};
    public static final String KEY_NAMA = "key_nama";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inisial();
        Isi_List();
        Listen_ListView();
    }

    private void Inisial() {
        LV_Nama = findViewById(R.id.listView_Main_Nama);
    }

    private void Isi_List() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1 ,List_Nama);
        LV_Nama.setAdapter(arrayAdapter);
    }

    private void Listen_ListView() {
        LV_Nama.setOnItemClickListener((parent, view, position, id) -> {
            String Nama = (String) LV_Nama.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this,AbsenActivity.class);
            intent.putExtra(KEY_NAMA,Nama);
            startActivity(intent);
        });
    }

}
