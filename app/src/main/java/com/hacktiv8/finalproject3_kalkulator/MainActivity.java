package com.hacktiv8.finalproject3_kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPersen,btnTambah,btnKurang,btnKali,btnBagi,btnHasil,btnHapus,btnBackSpace,btnTitik;
    TextView angkaMasuk,angkaKeluar;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnPersen = findViewById(R.id.btnPersen);
        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnKali = findViewById(R.id.btnKali);
        btnBagi =findViewById(R.id.btnBagi);

        btnHasil = findViewById(R.id.btnHasil);
        btnHapus = findViewById(R.id.btnHapus);
        btnBackSpace = findViewById(R.id.btnBackSpace);
        btnTitik = findViewById(R.id.btnTitik);

        angkaMasuk = findViewById(R.id.angkamasuk);
        angkaKeluar = findViewById(R.id.angkakeluar);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angkaMasuk.setText("");
                angkaKeluar.setText("");
            }
        });


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "0" );
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "1" );
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "2" );
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "3" );
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "4" );
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "5" );
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "6" );
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "7" );
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "8" );
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "9" );
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "+" );
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "-" );
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "*" );
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "÷" );
            }
        });

        btnTitik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "." );
            }
        });

        btnPersen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();
                angkaMasuk.setText(process + "%" );
            }
        });

        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = angkaMasuk.getText().toString();
                int input = word.length();
                if (input > 0 ) {
                    angkaMasuk.setText(word.substring(0, input - 1));
                }
            }
        });

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkaMasuk.getText().toString();

                process = process.replaceAll("x", "*");
                process = process.replaceAll("%", "/100");
                process = process.replaceAll("÷", "/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    finalResult = rhino.evaluateString(scriptable, process, "javascript code", 1, null).toString();
                } catch (Exception e) {
                    finalResult = "0";
                }


                try {
                    double result = Double.parseDouble(finalResult);

                    if (result % 1 == 0) {

                        angkaKeluar.setText(String.valueOf((long) result));
                    } else {

                        angkaKeluar.setText(finalResult);
                    }
                } catch (NumberFormatException e) {
                    angkaKeluar.setText(finalResult);
                }
            }
        });
    }
}
