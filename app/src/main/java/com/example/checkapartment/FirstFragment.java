package com.example.checkapartment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.checkapartment.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {
  private FragmentFirstBinding mbinding2;
    @Override

   //View onCreateView
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        //proyecto todos los componentes en la vista

        mbinding2=FragmentFirstBinding.inflate(inflater,container,false);
        mbinding2.Recyclerid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(mbinding2.getRoot()).navigate(R.id.action_firstFragment_to_secondFragment2);
            }
        });

        // Inflate the layout for this fragment
        return mbinding2.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.Recyclerid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_firstFragment_to_secondFragment2);
            }
        });
    }
}