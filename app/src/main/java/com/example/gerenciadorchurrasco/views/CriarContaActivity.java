package com.example.gerenciadorchurrasco.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gerenciadorchurrasco.R;

public class CriarContaActivity extends AppCompatActivity {
    Button buttonCadastroNovaConta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);
        
        buttonCadastroNovaConta = findViewById(R.id.buttonCadastroNovaConta);

        buttonCadastroNovaConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
        
        
    }
}
