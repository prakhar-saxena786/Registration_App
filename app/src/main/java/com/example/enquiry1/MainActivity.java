package com.example.enquiry1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Register,login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Name=(EditText) findViewById(R.id.name);
        Password=(EditText) findViewById(R.id.password);
        Login =(Button) findViewById(R.id.login);
        Register =(TextView) findViewById(R.id.tv_sign_up);
        login = (TextView)findViewById(R.id.tv_sign_in);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setTextColor(getResources().getColor(R.color.gray));
                Register.setTextColor(getResources().getColor(R.color.blue));
                Register.setTextSize(40);
                login.setTextSize(30);
                findViewById(R.id.lay_sign_in).setVisibility(View.GONE);
                findViewById(R.id.lay_sign_up).setVisibility(View.VISIBLE);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register.setTextColor(getResources().getColor(R.color.gray));
                login.setTextColor(getResources().getColor(R.color.blue));
                Register.setTextSize(30);
                login.setTextSize(40);
                findViewById(R.id.lay_sign_up).setVisibility(View.GONE);
                findViewById(R.id.lay_sign_in).setVisibility(View.VISIBLE);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });




    }
    private void validate(String UserName, String UserPassword){
        if((UserName.equals("Prakhar"))&&(UserPassword.equals("1234"))){
            Intent intent= new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);

        }else{
            Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
        }
    }
    private void newly(){
        Intent intent= new Intent(MainActivity.this,ThirdActivity.class);
        startActivity(intent);
    }
}


