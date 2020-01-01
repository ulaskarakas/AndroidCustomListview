package com.ulask.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ListViewAdapter adapter;
    private String[] sehir_adi;
    private String[] sehir_nufusu;
    private String[] sehir_yuzolcumu;
    private String[] sehir_rakim;
    private TypedArray sehir_icon;
    private int[] sehir_icon_int; // iconların resource id lerini tutacak array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sehir_adi = getResources().getStringArray(R.array.sehir_array);
        sehir_nufusu = getResources().getStringArray(R.array.nufus_array);
        sehir_yuzolcumu = getResources().getStringArray(R.array.yuzolcumu_array);
        sehir_rakim = getResources().getStringArray(R.array.rakim_array);
        sehir_icon = getResources().obtainTypedArray(R.array.icon_array);

        sehir_icon_int = new int[sehir_icon.length()]; //Iconların resource idlerini tutacak arrayi oluşturuyoruz

        for (int i=0; i<sehir_icon.length(); i++) {
            sehir_icon_int[i] = sehir_icon.getResourceId(i, -1); //iconların resource id değerlerini atıyoruz
        }

        //sehir_icon array'i içinde iconları tuttuğu için hafızada fazla yer kaplıyor.
        //Artık onunla işimiz bittiği için tuttuğu veriyi boşaltıyoruz.
        sehir_icon.recycle();

        list = findViewById(R.id.sehirList);

        adapter = new ListViewAdapter(this, sehir_adi, sehir_nufusu, sehir_yuzolcumu, sehir_rakim, sehir_icon_int);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                i.putExtra("sehir_adi", sehir_adi[position]);
                startActivity(i);
            }
        });

        list.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> paent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Uyarı!");
                builder.setInverseBackgroundForced(true);
                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });
    }
}
