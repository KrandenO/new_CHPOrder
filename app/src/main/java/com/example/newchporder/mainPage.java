package com.example.newchporder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class mainPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
    }
    public void orderPage(View view) {
        Intent intent = new Intent(this, householdForm.class);
        startActivity(intent);
    }
    public void itemHelpPage(View view) {
        Intent intent = new Intent(this, itemlist.class);
        startActivity(intent);
    }
    public void aboutPage(View view) {
        Intent intent = new Intent(this, aboutPage.class);
        startActivity(intent);
    }
    public void contactPage(View view) {
        Intent intent = new Intent(this, contactPage.class);
        startActivity(intent);
    }
}
