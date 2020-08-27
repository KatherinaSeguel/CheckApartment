package com.example.checkapartment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorDatos extends RecyclerView.Adapter<AdaptadorDatos.ViewHolderDatos> {

    private List<Apartment> listDatos;
    private TraspasoDatos traspaso;

    public AdaptadorDatos(List<Apartment> listDatos, TraspasoDatos traspaso) {
        this.listDatos = listDatos;
        this.traspaso = traspaso;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
    // holder.datos.setText(listDatos.get(position));
        Apartment aparment=listDatos.get(position);
        holder.text1.setText(aparment.getBuildingName());
        holder.text2.setText(aparment.getUnitId());
        holder.text3.setText(aparment.getAddress());
        Glide.with(holder.itemView.getContext()).load(aparment.getUrlImageBuilding()).into(holder.imagen1);
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView text1,text2,text3;
        ImageView imagen1;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            text1=itemView.findViewById(R.id.tv1);
            text2=itemView.findViewById(R.id.tv2);
            text3=itemView.findViewById(R.id.tv3);
            imagen1=itemView.findViewById(R.id.ima1);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            traspaso.asignardatos(listDatos.get(getAdapterPosition()));

        }


        //      datos.setText(s);

    }
    interface TraspasoDatos{
        void asignardatos (Apartment apartment);

    }
}
