package com.example.projetotcc.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projetotcc.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void abrirCadastroUsuario(View view){
        Intent intent=new Intent(LoginActivity.this,CadastroActivity.class);
        startActivity(intent);
    }
}