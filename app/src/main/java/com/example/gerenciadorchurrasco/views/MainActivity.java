package com.example.gerenciadorchurrasco.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gerenciadorchurrasco.R;

public class MainActivity extends AppCompatActivity {
    Button buttonLogin;
    Button buttonNovaConta;
    EditText userName;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonLogin = findViewById(R.id.buttonLogin);
        buttonNovaConta = findViewById(R.id.buttonCriarConta);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);

       // userName.setBackgroundColor(Color.WHITE);
       // password.setBackgroundColor(Color.WHITE);

      //  password.setTextColor(Color.BLACK);
     //   userName.setTextColor(Color.BLACK);

    //mudar a cor do action bar
        //ActionBar bar = getSupportActionBar();
        //bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1EB9DD")));


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        });


        buttonNovaConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CriarContaActivity.class);
                startActivity(intent);
            }
        });




        //


    }
}
