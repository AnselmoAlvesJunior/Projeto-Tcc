package com.example.projetotcc.activity.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetotcc.R;
import com.example.projetotcc.activity.config.Config;
import com.example.projetotcc.activity.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;



public class CadastroActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private EditText senha;
    private Button botaoCadastro;
    private Usuario user;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome=(EditText) findViewById(R.id.nomeCad);
        email=(EditText) findViewById(R.id.emailCad);
        senha=(EditText) findViewById(R.id.senhaCad);
        botaoCadastro=(Button) findViewById(R.id.btnCadastro);

        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user=new Usuario();
                user.setNome(nome.getText().toString());
                user.setEmail(email.getText().toString());
                user.setSenha(senha.getText().toString());
                cadastrarUsuario();
            }
        });

    }
    private void cadastrarUsuario(){
        autenticacao= Config.getAutenticacao();
        autenticacao.createUserWithEmailAndPassword(user.getEmail(),user.getSenha()).addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Toast.makeText(CadastroActivity.this,"Sucesso ao cadastrar usuario",Toast.LENGTH_LONG).show();
                    FirebaseUser usuarioFirebase=task.getResult().getUser();
                    user.setId(usuarioFirebase.getUid());
                    user.salvar();

                    autenticacao.signOut();
                    finish();
                }else{

                    String erroExcecao="";
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        erroExcecao="Digite uma senha forte!";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erroExcecao="Digite um email válido!";
                    }
                    catch (FirebaseAuthUserCollisionException e) {
                        erroExcecao="Esse email já está em uso!";
                    }
                    catch (Exception e) {
                        erroExcecao="Erro ao cadastrar usuário!";
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroActivity.this,"Erro ao cadastrar usuario",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

        public void abrirLoginUsuario(View view) {
        Intent intent= new Intent(CadastroActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}