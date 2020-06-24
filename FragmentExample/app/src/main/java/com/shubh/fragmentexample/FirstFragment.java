package com.shubh.fragmentexample;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {

    EditText et1, et2;
    Button b;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        et1 = v.findViewById(R.id.ed_username);
        et2 = v.findViewById(R.id.ed_password);
        b = v.findViewById(R.id.btn_sign_in);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=et1.getText().toString();
                String pwd=et2.getText().toString();

                //cannot directly pass data to fragment 2 from fragment 1
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.showData(name,pwd);
            }
        });

        return v;
    }
}