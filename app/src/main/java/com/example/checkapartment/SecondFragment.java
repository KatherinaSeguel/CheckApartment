package com.example.checkapartment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.checkapartment.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {
    private FragmentSecondBinding mbinding3;
    private String url;
    private String tex1,text2;

    int valor=0,punt=0,resul=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //traer la foto
        if(getArguments()!= null){
            url=getArguments().getString("imagendept");
            tex1=getArguments().getString("text1depto");
            text2=getArguments().getString("texto2depto");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        //proyecto todos los componentes en la vista

        mbinding3= FragmentSecondBinding.inflate(inflater,container,false);
      Glide.with(getContext()).load(url).into(mbinding3.imagen2);
       mbinding3.text1ok.setText(tex1);
       mbinding3.text2ok.setText(text2);
      //Glide.with(getContext()).load(tex1).into(mbinding3.text1ok);
      //  Glide.with(getContext()).load(text2).into(mbinding3.text2ok);

        //Glide.with(holder.itemView.getContext()).load(aparment.getUrlImageBuilding()).into(holder.imagen2);
         mbinding3.rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int i) {

                 if (mbinding3.switch1.isChecked()){
                     punt+=10;
                 }
                 if (mbinding3.switch2.isChecked()){
                     punt+=40;
                 }
                 if (mbinding3.switch3.isChecked()){
                     punt+=30;
                 }
                 if (mbinding3.switch4.isChecked()){
                     punt+=20;
                 }

                 if (mbinding3.rb1.isChecked()){
                     valor=3;
                 }
                 if (mbinding3.rb2.isChecked()){
                     valor=2;
                 }
                 if (mbinding3.rb3.isChecked()){
                     valor=1;
                 }
              resul=punt*valor;
              ///mbinding3.resul1.setText(resul);
                 mbinding3.resul1.setText(String.valueOf(resul));
             }

         });
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

        mbinding3.guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mbinding3.resul1.setText(resul);
            }
        });
    }


}