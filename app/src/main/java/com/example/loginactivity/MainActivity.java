package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText edeusername;
    private EditText edepassword;
    private Button btnLogin;
    private Button btnSignup;
    private String credential_shared_pref="our_credentials_pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edeusername = findViewById(R.id.ede_username);
        edepassword = findViewById(R.id.ede_password);
        btnLogin = findViewById(R.id.login);
        btnSignup = findViewById(R.id.Signup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences credentials=getSharedPreferences(credential_shared_pref, Context.MODE_PRIVATE);
                String strusername=credentials.getString("username",null);
                String strpassword=credentials.getString("password",null);
                String username_from_ed=edeusername.getText().toString();
                String password_from_ed=edepassword.getText().toString();

                if(strusername!=null && username_from_ed!=null && strusername.equalsIgnoreCase(username_from_ed)){
                    if(strpassword!=null && password_from_ed!=null && strpassword.equalsIgnoreCase(password_from_ed)){
                        Toast.makeText(MainActivity.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}