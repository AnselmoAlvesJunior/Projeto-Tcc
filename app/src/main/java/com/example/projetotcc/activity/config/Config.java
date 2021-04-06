package com.example.projetotcc.activity.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public final class Config  {

    private static DatabaseReference databaseReference;
    private static FirebaseAuth autenticacao;

    public static DatabaseReference getFirebase(){
        if(databaseReference==null){
            databaseReference= FirebaseDatabase.getInstance().getReference();
        }
        return databaseReference;
    }

    public static FirebaseAuth getAutenticacao(){
        if (autenticacao==null){
            autenticacao=FirebaseAuth.getInstance();
        }
        return autenticacao;

    }

}