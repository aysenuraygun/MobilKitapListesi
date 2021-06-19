package com.example.benimkitaplistem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KitapAdapter extends RecyclerView.Adapter<KitapAdapter.KitapHolder>{

    private ArrayList<Kitap> kitapList; //kitap sınıfından gelen listeyi alabilmek için liste oluşturuyorum.
    private Context context;
    private OnItemClickListener listener;

    public KitapAdapter(ArrayList<Kitap> kitapList, Context context) {
        this.kitapList = kitapList;
        this.context = context;
    }

    @NonNull
    @Override
    public KitapHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //geriye değer döndüren bir metottur.
        View v = LayoutInflater.from(context).inflate(R.layout.kitap_item,parent,false);
        return new KitapHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull KitapHolder holder, int position) {
        Kitap kitap=kitapList.get(position); //eklediğimiz veri kadar pozisyon değeri artar.bu sayede verilere ulaşırız.
        holder.setData(kitap); //kitap ı gönderiyoruz.
    }

    @Override
    public int getItemCount() { //burada dönen nesne miktarına göre işlem yapılır.
        return kitapList.size();
    }

    class KitapHolder extends RecyclerView.ViewHolder {
        TextView txtKitapAdi,txtKitapYazari,txtKitapOzeti;
        ImageView imgKitapResim;

        public KitapHolder(@NonNull View itemView) {
            super(itemView);

            txtKitapAdi=(TextView)itemView.findViewById(R.id.kitap_item_textViewKitapAdi);
            txtKitapYazari=(TextView)itemView.findViewById(R.id.kitap_item_textViewKitapYazari);
            txtKitapOzeti=(TextView)itemView.findViewById(R.id.kitap_item_textViewKitapOzeti);
            imgKitapResim=(ImageView)itemView.findViewById(R.id.kitap_item_imageViewKitapResim);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position= getAdapterPosition();

                    if(listener != null && position !=RecyclerView.NO_POSITION)
                        listener.onItemClick(kitapList.get(position));
                }
            });
        }

        public  void setData(Kitap kitap){ //kitap sınıfından değer alıyor.
            this.txtKitapAdi.setText(kitap.getKitapAdi()); //kitap sınıfınfan gelen kitapadinı kullan demek.
            this.txtKitapYazari.setText(kitap.getKitapYazari());
            this.txtKitapOzeti.setText(kitap.getKitapOzeti());
            this.imgKitapResim.setImageBitmap(kitap.getKitapResim());
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Kitap kitap);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener =listener;
    }
}
