package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("Inu");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText("12345");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main2,null);
                final EditText username = (EditText) view.findViewById(R.id.username);
                final EditText password = (EditText) view.findViewById(R.id.password);

                builder.setMessage("Login")
                        .setView(view)
                        .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String u = username.getText().toString();
                                String p = password.getText().toString();
                                if(u.equals("Inu") && p.equals("1234")){
                                    tv3.setText("5000");
                                }
                                else
                                    tv3.setText("Fuck off");

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .setCancelable(false)
                ;

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Really Exit")
                .setMessage("Are you sure you wanna exit?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false)
        ;
        AlertDialog alert = builder.create();
        alert.show();



}}