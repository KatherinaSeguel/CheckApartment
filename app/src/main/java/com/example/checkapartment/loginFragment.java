package com.example.checkapartment;

import android.os.Binder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.checkapartment.databinding.FragmentLoginBinding;


public class loginFragment extends Fragment {
   
   private FragmentLoginBinding mbinding;

    public loginFragment() {
        // Required empty public constructor
    }


    public static loginFragment newInstance(String param1, String param2) {
        loginFragment fragment = new loginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //proyecto todos los componentes en la vista
        mbinding=FragmentLoginBinding.inflate(inflater,container,false);
      mbinding.button1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Navigation.findNavController(mbinding.getRoot()).navigate(R.id.action_loginFragment3_to_firstFragment);
          }
      });
        return mbinding.getRoot();
    }
}