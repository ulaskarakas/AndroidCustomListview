package com.ulask.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);//xmli  bağladık

        text = (TextView) findViewById(R.id.textView1);
        String sehir_adi = getIntent().getStringExtra("sehir_adi");
        text.setText(sehir_adi);
    }
}
