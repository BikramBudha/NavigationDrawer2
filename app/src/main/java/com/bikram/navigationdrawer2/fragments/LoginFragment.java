package com.bikram.navigationdrawer2.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bikram.navigationdrawer2.MainActivity;
import com.bikram.navigationdrawer2.R;
import com.bikram.navigationdrawer2.model.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{

    EditText etusert, etpasst;
    Button btnlogint;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        etusert = view.findViewById(R.id.etuser);
        etpasst = view.findViewById(R.id.etpass);
        btnlogint = view.findViewById(R.id.btnlogin);
        btnlogint.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        String username=etusert.getText().toString().trim();
        String password=etpasst.getText().toString().trim();

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        Boolean status=user.userLogin();
            if(status){
                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(getActivity(), "Username or password dont match", Toast.LENGTH_SHORT).show();
                etusert.setText("");
                etpasst.setText("");
            }



    }
}
