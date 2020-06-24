package com.shubh.fragmentexample;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

//send data of fragment 1 to main activity then main activity to fragment 2

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();

        FirstFragment firstFragment=new FirstFragment();
        SecondFragment secondFragment=new SecondFragment();

        transaction.add(R.id.frame_one,firstFragment);
        transaction.add(R.id.frame_two,secondFragment);
        transaction.commit();
    }

    public void showData(String name, String pwd) {

        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();

        //we send data to fragment 2
        SecondFragment secondFragment=new SecondFragment();

        //for sending data
        Bundle bundle2=new Bundle();
        bundle2.putString("name",name);
        bundle2.putString("pwd",pwd);

        secondFragment.setArguments(bundle2);
        transaction.add(R.id.frame_two,secondFragment);
        transaction.commit();

    }
}