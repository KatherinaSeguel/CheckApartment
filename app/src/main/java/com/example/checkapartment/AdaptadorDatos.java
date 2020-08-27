package com.example.checkapartment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorDatos extends RecyclerView.Adapter<AdaptadorDatos.ViewHolderDatos> {

    ArrayList<String>  listDatos;
    private TraspasoDatos traspaso;

    public AdaptadorDatos(ArrayList<String> listDatos,TraspasoDatos traspaso) {
        this.listDatos = listDatos;
        this.traspaso=traspaso;
    }



    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
     holder.datos.setText(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView datos;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            datos= itemView.findViewById(R.id.idDatos);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            traspaso.asignardatos(listDatos.get(getAdapterPosition()));

        }


        //      datos.setText(s);

    }
    interface TraspasoDatos{
        void asignardatos (String s);

    }
}
