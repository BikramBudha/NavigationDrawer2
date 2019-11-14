package com.bikram.navigationdrawer2.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bikram.navigationdrawer2.R;
import com.bikram.navigationdrawer2.model.User;


import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment implements View.OnClickListener {

    private EditText user, pass;
    Button btnregister;
    static List<User> userList = new ArrayList<User>();

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        user = view.findViewById(R.id.etuserr);
        pass = view.findViewById(R.id.etpassr);
        btnregister = view.findViewById(R.id.btnregister);
        btnregister.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(user.getText().toString())) {
            user.setError("please enter username");
        } else if (TextUtils.isEmpty(pass.getText().toString())) {
            pass.setError("please enter password");
        } else {
            User userModel = new User();
            userModel.setUsername(user.getText().toString());
            userModel.setPassword(pass.getText().toString());
            userList.add(userModel);
            userModel.setUserList(userList);

            user.setText("");
            pass.setText("");
            Toast.makeText(getActivity(), "User Registered!!!!!" + "     " + userList.size(), Toast.LENGTH_LONG).show();
        }


    }
}

