package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {
    private String credential_shared_pref="our_credentials_pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         EditText edusername;
        EditText confirmpassword;
         EditText edpassword;
         Button btncreateuser;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edusername=findViewById(R.id.ede_username);
        edpassword=findViewById(R.id.ede_password);
        btncreateuser=findViewById(R.id.createuser);
        confirmpassword=findViewById(R.id.confirmpassword);
        btncreateuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPassword=edpassword.getText().toString();
                String strusername=edusername.getText().toString();
                String strconfirmpassword=confirmpassword.getText().toString();
                if(strconfirmpassword!=null && strPassword!=null && strPassword.equalsIgnoreCase(strconfirmpassword)){
                    SharedPreferences credentials=getSharedPreferences(credential_shared_pref, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=credentials.edit();
                editor.putString("password",strPassword);
                editor.putString("username",strusername);
                editor.commit();
                Signup.this.finish();

                }
            }
        });
    }
}