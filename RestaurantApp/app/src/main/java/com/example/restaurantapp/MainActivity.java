package com.example.restaurantapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    TextView name, pass;
    Button loginButton, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        name = findViewById(R.id.userNameText);
        pass = findViewById(R.id.passwordText);
        loginButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.signUpButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameText = name.getText().toString();
                String passText = pass.getText().toString();
                if (nameText.equals("") || passText.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please fill all the data", Toast.LENGTH_LONG).show();
                }
                else {
                    if (db.validateLogin(nameText, passText)) {
                        Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();
                        // for testing
                        Intent i = new Intent(MainActivity.this, TimerActivity.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Incorrect Email or Password", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
    }
}