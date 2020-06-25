package com.shubh.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et_number;
    TextView tv_num_display;
    Button btn_rus, btn_usa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_number = findViewById(R.id.edt_text);
        tv_num_display = findViewById(R.id.tv_text);
        btn_rus = findViewById(R.id.btn_russia);
        btn_usa = findViewById(R.id.btn_us);

        btn_rus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String russian = et_number.getText().toString();
                Double drupees = Double.parseDouble(russian);

//                Double dollarsINR = 70.67 * dDollars;//for dollars to rupees conversion
                Double russianRUB = 0.92 * drupees;//for rupees to dollars conversion

                tv_num_display.setText(String.valueOf(russianRUB) + " RUB");
            }
        });

        btn_usa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String american = et_number.getText().toString();
                Double dDollars = Double.parseDouble(american);

                Double dollarsINR = 75.60 * dDollars;//for dollars to rupees conversion
//                Double dollarsINR = 75.60 / dDollars;//for rupees to dollars conversion

                tv_num_display.setText(String.valueOf(dollarsINR) + " $");
            }
        });
    }
}