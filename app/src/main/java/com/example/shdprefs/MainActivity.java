package com.example.shdprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt1,txt2;
    Button btn,bto;
     SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=getSharedPreferences("asd",MODE_PRIVATE);
        txt1=findViewById(R.id.editText);
        txt2=findViewById(R.id.editText2);
        btn=findViewById(R.id.button);
        bto=findViewById(R.id.button3);
        bto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,registration.class);
                startActivity(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt1.getText().toString().isEmpty()||txt2.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"empty values",Toast.LENGTH_LONG).show();
                }
                else
                {
                  if(((sharedPreferences.getString("name",null).equals(txt1.getText().toString())) && (sharedPreferences.getString("password",null).equals(txt2.getText().toString()))))
                  {
                    Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
                  }
                  else
                  {
                      Toast.makeText(MainActivity.this,"invalid credentials",Toast.LENGTH_LONG).show();

                  }

                }

            }
        });
    }
}
