package com.ims_hr.latihan12;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView LV_Nama;
    String[] List_Nama = new String[] {"Andi","Agus","April","Inara","Almaira"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inisial();
        Isi_List();
        Listen_ListView();
    }

    private void Inisial() {
        LV_Nama = (ListView) findViewById(R.id.listView_Main_Nama);
    }

    private void Isi_List() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 ,List_Nama);
        LV_Nama.setAdapter(arrayAdapter);
    }

    private void Listen_ListView() {
        LV_Nama.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Nama = (String) LV_Nama.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this,AbsenActivity.class);
                intent.putExtra("nama",Nama);
                startActivity(intent);
            }
        });
    }

}
