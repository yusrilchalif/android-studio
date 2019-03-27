package com.example.gt303_12.tugasintent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText username, password;
    TextView toLogin, toRegister;

    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Login");

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        toLogin = findViewById(R.id.toLogin);
        toLogin.setOnClickListener(this);

        toRegister = findViewById(R.id.toRegister);
        toRegister.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toLogin:
                if(!username.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, drawActivity.class);
                    intent.putExtra("USERNAME_LOGGED", username.getText().toString().trim() );
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.toRegister:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RegisterActivity.RESULT_CODE) {
            String resultValue = data.getStringExtra(RegisterActivity.EXTRA_SELECTED_VALUE);
            username.setText(resultValue);
        }
    }
}
