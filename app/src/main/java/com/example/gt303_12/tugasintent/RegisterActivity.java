package com.example.gt303_12.tugasintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    final RegisterActivity CONTEXT = RegisterActivity.this;
    public static String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static int RESULT_CODE = 110;

    TextView doSignUp, backLogin;
    EditText regUser, regPhone, regEmail, regPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        backLogin = findViewById(R.id.backLogin);
        backLogin.setOnClickListener(this);

        regUser = findViewById(R.id.regUser);
        regPhone = findViewById(R.id.regPhone);
        regEmail = findViewById(R.id.regEmail);
        regPassword = findViewById(R.id.regPassword);

        doSignUp = findViewById(R.id.doSignUp);
        doSignUp.setOnClickListener(this);
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backLogin:
                onBackPressed();
                break;
            case R.id.doSignUp:
                Toast.makeText(CONTEXT, "SUCCESS", Toast.LENGTH_SHORT).show();
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, regEmail.getText().toString().trim());
                setResult(RESULT_CODE);
                finish();
        }
    }
}
