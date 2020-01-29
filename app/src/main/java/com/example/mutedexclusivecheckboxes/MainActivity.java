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
    private void init(){
        final TextView paymentInfo=findViewById(R.id.paymentInfo);
        final TextView paymentValue=findViewById(R.id.paymentValue);
        final CheckBox BankCard=findViewById(R.id.BankCardBox);
        final CheckBox MobileDeposite=findViewById(R.id.MobileDepositeBox);
        final CheckBox ReadyCash=findViewById(R.id.ReadyCashBox);
        final Button save=findViewById(R.id.saveBut);
        BankCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MobileDeposite.setChecked(false);
                ReadyCash.setChecked(false);
            }
        });
        MobileDeposite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BankCard.setChecked(false);
                ReadyCash.setChecked(false);
            }
        });
        ReadyCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MobileDeposite.setChecked(false);
                BankCard.setChecked(false);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb=new StringBuilder();
                String payInfo =paymentInfo.getText().toString();
                String payValue =paymentValue.getText().toString();
                if(!payInfo.equals("") && !payValue.equals("")) {
                    sb.append(payInfo + " ");
                    sb.append(payValue + "руб ");
                }else{
                    sb.append("Не введены все необходимые знания ");
                }
                if(BankCard.isChecked()){
                    sb.append("Выбран тип оплаты Банковской картой");
                }else if(MobileDeposite.isChecked()){
                    sb.append("Выбран тип оплаты Мобильным устройством");
                }else if(ReadyCash.isChecked()){
                    sb.append("Выбран тип оплаты Наличными");
                }else{
                    sb.append("Не выбран тип оплаты");
                }
                Toast viewReadedData = Toast.makeText(getApplicationContext(),sb.toString() , Toast.LENGTH_LONG);
                viewReadedData.show();
            }
        });
    }
}
