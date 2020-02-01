package com.example.mutedexclusivecheckboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        final TextView paymentInfo = findViewById(R.id.paymentInfo);
        final TextView paymentValue = findViewById(R.id.paymentValue);
        final CheckBox bankCard = findViewById(R.id.bankCardBox);
        final CheckBox mobileDeposite = findViewById(R.id.mobileDepositeBox);
        final CheckBox readyCash = findViewById(R.id.readyCashBox);
        final Button save = findViewById(R.id.saveBut);
        bankCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobileDeposite.setChecked(false);
                readyCash.setChecked(false);
            }
        });
        mobileDeposite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bankCard.setChecked(false);
                readyCash.setChecked(false);
            }
        });
        readyCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobileDeposite.setChecked(false);
                bankCard.setChecked(false);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                String payInfo = paymentInfo.getText().toString();
                String payValue = paymentValue.getText().toString();
                if (!payInfo.equals("") && !payValue.equals("")) {
                    sb.append(payInfo + " ");
                    sb.append(payValue + "руб ");
                } else {
                    sb.append("Не введены все необходимые знания ");
                }
                if (bankCard.isChecked()) {
                    sb.append("Выбран тип оплаты Банковской картой");
                } else if (mobileDeposite.isChecked()) {
                    sb.append("Выбран тип оплаты Мобильным устройством");
                } else if (readyCash.isChecked()) {
                    sb.append("Выбран тип оплаты Наличными");
                } else {
                    sb.append("Не выбран тип оплаты");
                }
                Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
