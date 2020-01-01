package com.ulask.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

    //Declare Variables
    Context context;
    String[] sehir_adi;
    String[] sehir_nufusu;
    String[] sehir_yuzolcumu;
    String[] sehir_rakim;
    int[] sehir_icon_int;
    LayoutInflater layoutInflater;

    //Set Variables
    public ListViewAdapter(Context context, String[] sehir_adi, String[] sehir_nufusu, String[] sehir_yuzolcumu, String[] sehir_rakim, int[] sehir_icon_int) {
        this.context = context;
        this.sehir_adi = sehir_adi;
        this.sehir_nufusu = sehir_nufusu;
        this.sehir_yuzolcumu = sehir_yuzolcumu;
        this.sehir_rakim = sehir_rakim;
        this.sehir_icon_int = sehir_icon_int;
    }

    @Override
    public int getCount() {
        return sehir_adi.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView sehir_adi_textview;
        TextView sehir_nufus_textview;
        TextView sehir_yuzolcumu_textview;
        TextView sehir_rakim_textview;
        ImageView sehir_icon_imageView;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.list_item_row, parent, false);

        sehir_adi_textview = itemView.findViewById(R.id.sehir_adi);
        sehir_nufus_textview = itemView.findViewById(R.id.sehir_nufus);
        sehir_yuzolcumu_textview = itemView.findViewById(R.id.sehir_yuzolcumu);
        sehir_rakim_textview = itemView.findViewById(R.id.sehir_rakim);
        sehir_icon_imageView = itemView.findViewById(R.id.sehir_icon);

        sehir_adi_textview.setText(sehir_adi[position]);
        sehir_nufus_textview.setText("Nüfus: " + sehir_nufusu[position]);
        sehir_yuzolcumu_textview.setText("Yüz Ölçümü: " + sehir_yuzolcumu[position]);
        sehir_rakim_textview.setText("Rakım: " + sehir_rakim[position]);
        sehir_icon_imageView.setImageResource(sehir_icon_int[position]);

        return  itemView;
    }

}
