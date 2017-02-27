package com.progdawn.currencyconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double currencyEntered;
    double currencyConverted;
    double euroRate = 0.95;
    double pesoRate = 19.89;
    double canadianRate = 1.31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText currency = (EditText)findViewById(R.id.txtCurrency);
        final RadioButton euro = (RadioButton)findViewById(R.id.radEuros);
        final RadioButton peso = (RadioButton)findViewById(R.id.radPesos);
        final RadioButton canadian = (RadioButton)findViewById(R.id.radCanadian);
        final TextView result = (TextView)findViewById(R.id.txtResult);

        Button convert = (Button)findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currencyEntered = Double.parseDouble(currency.getText().toString());
                DecimalFormat euroFormat = new DecimalFormat("€##.##");
                DecimalFormat moneyFormat = new DecimalFormat("$##.##");
                if(currencyEntered > 100000.00)
                {
                    Toast.makeText(MainActivity.this,"Please enter amount less than $100,000", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(euro.isChecked())
                    {
                        currencyConverted = currencyEntered * euroRate;
                        result.setText(euroFormat.format(currencyConverted));
                    }
                    if(peso.isChecked())
                    {
                        currencyConverted = currencyEntered * pesoRate;
                        result.setText(moneyFormat.format(currencyConverted));
                    }
                    if(canadian.isChecked())
                    {
                        currencyConverted = currencyEntered * canadianRate;
                        result.setText(moneyFormat.format(currencyConverted));
                    }
                }
            }
        });
    }
}
