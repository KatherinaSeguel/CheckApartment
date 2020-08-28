package com.example.checkapartment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.checkapartment.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {
    private FragmentSecondBinding mbinding3;
    private String url;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
          //traer la foto
        if(getArguments()!= null){
            url=getArguments().getString("URL");
        }


        //proyecto todos los componentes en la vista

        mbinding3= FragmentSecondBinding.inflate(inflater,container,false);
       // Glide.with(getContext()).load(url).into(mbinding3.imagen2);
        //Glide.with(holder.itemView.getContext()).load(aparment.getUrlImageBuilding()).into(holder.imagen2);

        // Inflate the layout for this fragment
        return mbinding3.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.alerta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_secondFragment_to_loginFragment3);
            }
        });
    }
}