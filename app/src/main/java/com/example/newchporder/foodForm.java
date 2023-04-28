package com.example.newchporder;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class foodForm extends AppCompatActivity {
    private String riceValue;
    private String grainValue;
    private String juiceValue;
    private String milkValue;
    private String seniorAddOn;
    private String adultAddOn;
    private String childAddOn;
    ArrayList<String> multiChoice = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodform);


        seniorAddOn = getIntent().getStringExtra("oldAgeAddOn");
        adultAddOn = getIntent().getStringExtra("midAgeAddOn");
        childAddOn = getIntent().getStringExtra("youngAgeAddOn");

        //establishers
        riceValue = "White";
        grainValue = "Grits";
        milkValue = "Milk";
        juiceValue = "No";

    }

    public void masterClick(View view){
        int viewId = view.getId();
        switch (viewId) {
            case R.id.whiteRice:
            case R.id.brownRice:
                riceValue = ((RadioButton) view).getText().toString();
                break;
            case R.id.oatMeal:
            case R.id.grits:
                grainValue = ((RadioButton) view).getText().toString();
                break;
            case R.id.juiceToggle:
                ToggleButton juiceObject = (ToggleButton) view;
                juiceValue = juiceObject.getText().toString();
                if (juiceObject.isChecked()) {
                    juiceObject.setBackgroundColor(getResources().getColor(R.color.grapeColor));
                } else {
                    juiceObject.setBackgroundColor(getResources().getColor(R.color.appleColor));
                }
                break;
            case R.id.yesMilk:
                milkValue = (((RadioButton) view).getText().toString().equals("Yes")) ? "Milk" : "No Milk";
                break;
            // Add cases for other views as needed
            case R.id.check2:
            case R.id.check3:
            case R.id.check4:
            case R.id.check5:
            case R.id.check6:
            case R.id.check1:
                CheckBox variousObject = (CheckBox) view;
                if (variousObject.isChecked()) {
                    multiChoice.add(variousObject.getText().toString());
                } else {
                    multiChoice.remove(variousObject.getText().toString());
                }
                break;
        }
    }

    public void previousPage(View view) {
        Intent intent = new Intent(this, householdForm.class);
        startActivity(intent);
    }
    public void nextPage(View view) {
        EditText editText = findViewById(R.id.cereal_Input);
        String cerealValue = "";
        if (editText.getText().toString().equals("Enter cereal here:")){
            cerealValue = "None chosen";
        }
        else {
            cerealValue = editText.getText().toString();
        }

        Intent intent = new Intent(foodForm.this,results.class);
        intent.putExtra("riceKey",riceValue);
        intent.putExtra("grainKey",grainValue);
        intent.putExtra("juiceKey",juiceValue);
        intent.putExtra("cerealKey", cerealValue);
        intent.putExtra("milkKey", milkValue);
        intent.putStringArrayListExtra("multiChoiceKey", multiChoice);
        intent.putExtra("seniorAddOn", seniorAddOn);
        intent.putExtra("adultAddOn", adultAddOn);
        intent.putExtra("childAddOn", childAddOn);
        startActivity(intent);
    }
}