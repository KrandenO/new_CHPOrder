package com.example.newchporder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class results extends AppCompatActivity {
    private TextView Ticket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        Ticket = findViewById(R.id.testCase);

        showResults();


    }
    public void showResults(){
        Intent intent = getIntent();
        ArrayList<String> multiChoiceList = intent.getStringArrayListExtra("multiChoiceKey");

        String Extra = "";

        if (multiChoiceList != null) {
            StringBuilder builder = new StringBuilder();
            for (String value : multiChoiceList) {
                builder.append(value).append(", ").append("\n");
            }
            Extra = builder.toString();
        }
        else {
            Extra = "";
        }

        Ticket.setText(getIntent().getStringExtra("riceKey") + " Rice"
        + "\n" + getIntent().getStringExtra("grainKey")
        + "\n" + getIntent().getStringExtra("juiceKey") + " Juice"
        + "\n" + "Cereal: " + getIntent().getStringExtra("cerealKey")
        + "\n" + getIntent().getStringExtra("milkKey")
        + "\n" + getIntent().getStringExtra("seniorAddOn")
        + "\n" + getIntent().getStringExtra("adultAddOn")
        + "\n" + getIntent().getStringExtra("childAddOn")
        + "\n" + Extra
        );
    }
    public void homePage(View view) {
        Intent intent = new Intent(this, mainPage.class);
        startActivity(intent);
    }

}
