package com.example.newchporder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class householdForm extends AppCompatActivity {
    private TextView numShow;
    private String seniorAddOn;
    private String adultAddOn;
    private String childAddOn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.householdform);


        numShow = findViewById(R.id.textView2);
        seniorAddOn = "No Senior Add Ons";
        adultAddOn = "1 canned meat + 2 canned veggies.";
        childAddOn = "No Child Add Ons";

        SeekBar seekSlide = findViewById(R.id.seekBar);
        seekSlide.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numChanger(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekbar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekbar) {
            }
        });
    }
    public void dualPicker(View view) {
        RadioButton radioButton = (RadioButton) view;
        String radioButtonLabel = radioButton.getText().toString();
        switch (view.getId()) {
            case R.id.noSenior:
            case R.id.yesSenior:
                seniorAddOn = radioButtonLabel.equals("Yes") ? "1 can meat + 1 Jelly" : "No Senior Add Ons";
                break;
            case R.id.noKid:
            case R.id.yesKid:
                childAddOn = radioButtonLabel.equals("Yes") ? "1 canned meat, 1 jelly, and 1 pasta + sauce." : "No Child Add Ons";
                break;
        }
    }
    public void numChanger(int number){
        switch (number) {
            default:
                numShow.setText("" + (number+1));
                adultAddOn = "No Adult Add Ons";
                break;
            case 1:
            case 2:
                adultAddOn = "1 canned meat + 2 canned veggies.";
                numShow.setText("" + (number+1));
                break;
            case 3:
                adultAddOn = "Various";
                numShow.setText("4+");
                break;
        }

    }
    public void previousPage(View view) {
        Intent intent = new Intent(this, mainPage.class);
        startActivity(intent);
    }
    public void nextPage(View view) {
        Intent intent = new Intent(this, foodForm.class);
        intent.putExtra("oldAgeAddOn", seniorAddOn);
        intent.putExtra("midAgeAddOn", adultAddOn);
        intent.putExtra("youngAgeAddOn", childAddOn);
        startActivity(intent);
    }
}
