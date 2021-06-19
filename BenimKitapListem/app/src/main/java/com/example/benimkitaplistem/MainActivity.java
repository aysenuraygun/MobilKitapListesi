package com.example.benimkitaplistem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private KitapAdapter adapter;
    static public KitapDetayi kitapDetayi;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.add_menu_add_book){
            //intent geçiş
            Intent kitapekle=new Intent(this,AddBookActivity.class);
            finish(); //aktiviteyi bitiriyoruz
            startActivity(kitapekle);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView)findViewById(R.id.main_activity_recyclerView);
        adapter= new KitapAdapter(Kitap.getData(this),this);

        mRecyclerView.setHasFixedSize(true);
       GridLayoutManager manager= new GridLayoutManager(this,1);

        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new GridManagerDecoration());
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new KitapAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Kitap kitap) {
                kitapDetayi= new KitapDetayi(kitap.getKitapAdi(),kitap.getKitapYazari(),kitap.getKitapOzeti(),kitap.getKitapResim());

                Intent detayIntent= new Intent(MainActivity.this,DetayActivity.class);
                startActivity(detayIntent);
            }
        });
    }
    private  class GridManagerDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull  View view, @NonNull  RecyclerView parent, @NonNull  RecyclerView.State state) {
           outRect.bottom=25;
        }
    }
}