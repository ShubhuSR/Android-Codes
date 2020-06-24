package com.shubh.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    TextView t1, t2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);

        t1 = v.findViewById(R.id.tv_username);
        t2 = v.findViewById(R.id.tv_password);

        Bundle bundle2 = getArguments();

        if (bundle2 != null) {
            String name = bundle2.getString("name");
            String pwd = bundle2.getString("pwd");

            t1.setText(name);
            t2.setText(pwd);
        }

        return v;
    }
}