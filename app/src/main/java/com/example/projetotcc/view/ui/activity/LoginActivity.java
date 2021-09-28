package com.example.projetotcc.view.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetotcc.R;
import com.example.projetotcc.config.Config;
import com.example.projetotcc.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText senha;
    private Button botaoLogar;
    private Usuario usuario;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        verificarUsuarioLogin();
        email = (EditText) findViewById(R.id.editTextLogin);
        senha = (EditText) findViewById(R.id.editTextTextPassword);
        botaoLogar= (Button) findViewById(R.id.btnLogin);

        botaoLogar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                usuario = new Usuario();
                usuario.setEmail(email.getText().toString());
                usuario.setSenha(senha.getText().toString());
                validarLogin();
            }
        });
    }

    private void verificarUsuarioLogin(){
        auth=Config.getAutenticacao();
        if (auth.getCurrentUser() != null){
            abrirTelaPrincipal();
        }
    }
    private void validarLogin(){
        auth = Config.getAutenticacao();
        auth.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    System.out.println();
                    Toast.makeText(LoginActivity.this,"Sucesso ao fazer Login!",Toast.LENGTH_LONG).show();
                    abrirTelaPrincipal();
                }else {
                    System.out.println(task.isSuccessful());

                    Toast.makeText(LoginActivity.this,"Erro ao fazer Login!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private void abrirTelaPrincipal(){
        Intent intent= new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void abrirCadastroUsuario(View view){
        Intent intent=new Intent(LoginActivity.this,CadastroActivity.class);
        startActivity(intent);
    }
}