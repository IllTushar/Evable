package com.evable.cashandmitra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText loginPhone,loginPassword;
    Button btnLogin;
    TextView forgetPassword,registration;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*----------Type Casting-----------*/
        loginPassword = findViewById(R.id.loginPassword);
        loginPhone = findViewById(R.id.loginPhone);
        btnLogin = findViewById(R.id.btnLogin);
        checkBox = findViewById(R.id.loginCheckbox);
        registration = findViewById(R.id.registration);
        forgetPassword = findViewById(R.id.forgetPassword);

        /*-----------Perform Action on Login Button------------*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });
        /*------------Perform Action on forgetPassword-------------------*/
                forgetPassword.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(LoginActivity.this,"Reset Password !!",Toast.LENGTH_SHORT).show();
                        return;
                    }
                });

        /*------------Perform Action on Registration------*/
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"Registration !!",Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }
    private void validation() {
        String Phone = loginPhone.getText().toString();
        String Password = loginPassword.getText().toString();
        if (TextUtils.isEmpty(Phone)){
            Toast.makeText(LoginActivity.this,"Enter Username !!",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Password)){
            Toast.makeText(LoginActivity.this, "Enter Password !!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Password.length()<8){
            Toast.makeText(LoginActivity.this,"Password is too short with special charaters at the last: _.()$@# !!",Toast.LENGTH_SHORT).show();
            return;
        }
        if (checkBox.isChecked()){
            Toast.makeText(LoginActivity.this,"Login Successful !!",Toast.LENGTH_SHORT).show();
            return;
        }
        else if (!Password.matches("^(.*[_.()$@#])")){
            Toast.makeText(LoginActivity.this, "Enter special charaters at the last: _.()$@#!!", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            Toast.makeText(LoginActivity.this,"please checked the box !!",Toast.LENGTH_SHORT).show();
            return;
        }

    }

}
