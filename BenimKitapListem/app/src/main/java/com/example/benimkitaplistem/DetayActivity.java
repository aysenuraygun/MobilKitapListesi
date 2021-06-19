package com.example.benimkitaplistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {
    private TextView txtKitapAdi,txtKitapYazari,txtKitapOzeti;

    private ImageView imgKitapResimi;
    private String kitapAdi,kitapYazari,kitapOzeti;
    private Bitmap kitapResimi;
    private Button buton;


    private void init(){
        imgKitapResimi=(ImageView)findViewById(R.id.detay_activity_imageViewKitapResim);
        txtKitapAdi=(TextView)findViewById(R.id.detay_activity_textViewKitapAdi);
        txtKitapYazari=(TextView)findViewById(R.id.detay_activity_textViewKitapYazari);
        txtKitapOzeti=(TextView)findViewById(R.id.detay_activity_textViewKitapOzeti);
        buton=(Button)findViewById(R.id.detay_activity_buttonPaylas);

        kitapAdi=MainActivity.kitapDetayi.getKitapAdi(); //kitap özelliklerinin içini doldurma kısmı
        kitapYazari=MainActivity.kitapDetayi.getKitapYazari();
        kitapOzeti=MainActivity.kitapDetayi.getKitapOzeti();
        kitapResimi=MainActivity.kitapDetayi.getKitapResimi();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        init(); //metotu çağırıyoruz.

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String mesaj = txtKitapAdi.getText().toString();
              paylas(mesaj);
            }
        });

        if(!TextUtils.isEmpty(kitapAdi) && !TextUtils.isEmpty(kitapYazari) && !TextUtils.isEmpty(kitapOzeti)) {
            txtKitapAdi.setText(kitapAdi);
            txtKitapYazari.setText(kitapYazari);
            txtKitapOzeti.setText(kitapOzeti);
            imgKitapResimi.setImageBitmap(kitapResimi);
        }
    }

    private void paylas(String mesaj) {
        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,mesaj);

        startActivity(Intent.createChooser(intent,"Bu uygulamayı paylaş"));

    }
}//buraya kadar vardı oklar