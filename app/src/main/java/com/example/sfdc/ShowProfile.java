package com.example.sfdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ShowProfile extends AppCompatActivity {


    public static final String SHAREDPREFERENCIES = "shared";
    public static final String FULLNAME = "fullName";
    public static final String PHONENUMBER = "phoneNumber";
    public static final String FARMNAME = "farmName";
    public static final String FARMINGTYPE = "farmingType";
    public static final String DISTRICT = "district";
    TextView fullName, phoneNumber,farmName,farmType,district;
    String text1,text2,text3,text4,text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);

        fullName = findViewById(R.id.profName);
        phoneNumber = findViewById(R.id.profPhonNumber);
        farmName = findViewById(R.id.profFarmName);
        farmType = findViewById(R.id.profFarmingType);
        district = findViewById(R.id.profDistrict);

        SharedPreferences shared = getApplicationContext().getSharedPreferences(SHAREDPREFERENCIES,MODE_PRIVATE);
        text1 = shared.getString(FULLNAME,"");
        fullName.setText(text1);

        text2 = shared.getString(PHONENUMBER,"");
        phoneNumber.setText(text2);

        text3 = shared.getString(FARMNAME,"");
        farmName.setText(text3);

        text4 = shared.getString(FARMINGTYPE,"");
        farmType.setText(text4);

        text5 = shared.getString(DISTRICT,"");
        district.setText(text5);


    }
}