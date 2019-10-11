package com.example.shdprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity {
    EditText txt3, txt4, txt5, txt6;
    Button btm;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        txt3 = findViewById(R.id.editText3);
        txt4 = findViewById(R.id.editText4);
        txt5 = findViewById(R.id.editText5);
        txt6 = findViewById(R.id.editText6);
        btm = findViewById(R.id.button2);

        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(txt3.getText().toString().isEmpty() || txt4.getText().toString().isEmpty() || txt5.getText().toString().isEmpty() || txt6.getText().toString().isEmpty()) && (txt5.getText().toString().equals(txt6.getText().toString())))
                {
                    sharedPreferences=getSharedPreferences("asd",MODE_PRIVATE);
                    SharedPreferences.Editor e=sharedPreferences.edit();
                    e.putString("name",txt3.getText().toString());
                    e.putString("email",txt4.getText().toString());
                    e.putString("password",txt5.getText().toString());
                    e.apply();
                    Toast.makeText(registration.this, "success", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(registration.this,"Enter the fields correctly",Toast.LENGTH_SHORT).show();
                }

                }

        });
    }
}
