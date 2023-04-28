package com.example.newchporder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class itemlist extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlist);
    }
    public void backToHome(View view){
        Intent intent = new Intent(this, mainPage.class);
        startActivity(intent);
    }
}

