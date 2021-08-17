package com.example.sfdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
Button button;
public static final String SHAREDPREFERENCIES = "shared";
public static final String FULLNAME = "fullName";

public String field1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        SharedPreferences shared = getSharedPreferences(SHAREDPREFERENCIES, MODE_PRIVATE);
        field1 = shared.getString(FULLNAME,null);
        if(field1 != null){
            Intent intent = new Intent(getApplicationContext(), Landing.class);
            startActivity(intent);
            finish();
        }
        else {
            button = findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), Profile.class);
                    startActivity(intent);
                }
            });
        }
    }
}