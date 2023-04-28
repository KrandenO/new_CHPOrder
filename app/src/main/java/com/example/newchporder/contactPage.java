package com.example.newchporder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class contactPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactpage);
    }
    public void makeCall(View view) {
        String phoneNumber = "706-864-1400";
        Uri uri = Uri.parse("tel:" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }


    public void makeEmail(View view) {
        String body = "Message body";
        String subject = "Donation for Helping Hands";
        String recipient = "sjsart2323@ung.edu";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + recipient));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        startActivity(Intent.createChooser(intent, "Send email"));
        finish();
    }


    public void makeDirections(View view) {
        String location = "82 College Circle, Dahlonega, GA 30507";

        Uri locationUri = Uri.parse("geo:0,0?q=" + location);

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }
    public void homePage(View view) {
        Intent intent = new Intent(this, mainPage.class);
        startActivity(intent);
    }
}