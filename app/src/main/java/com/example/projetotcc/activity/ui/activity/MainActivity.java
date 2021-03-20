package com.example.projetotcc.activity.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projetotcc.R;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

   private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}