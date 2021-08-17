package com.example.sfdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Profile extends AppCompatActivity {

    public static final String SHAREDPREFERENCIES = "shared";
    public static final String FULLNAME = "fullName";
    public static final String PHONENUMBER = "phoneNumber";
    public static final String FARMNAME = "farmName";
    public static final String FARMINGTYPE = "farmingType";
    public static final String DISTRICT = "district";

    Button createProfile;
    String name;
    EditText fullName, phoneNumber, farmName, farmingType, district;

    boolean isAllFieldsChecked = false;

//    private Boolean validateName() {
//
//        String val = fullName.getEditableText().toString();
//
//        if (val.isEmpty()){
//            fullName.setError("Empty Field");
//            return false;
//        } else {
//            fullName.setError(null);
//            return true;
//        }
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        createProfile = findViewById(R.id.createProfileButton);
        fullName = findViewById(R.id.profileNameInput);
        phoneNumber = findViewById(R.id.profilePhoneNumberInput);
        farmName = findViewById(R.id.profileFarmNameInput);
        farmingType = findViewById(R.id.profileFarmingTypeInput);
        district = findViewById(R.id.profileDistrictNameInput);

        createProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //storing user data to local storage
                name = String.valueOf(fullName.getText());
                SharedPreferences shared = getSharedPreferences(SHAREDPREFERENCIES, MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putString(FULLNAME, name);
                editor.putString(PHONENUMBER, phoneNumber.getText().toString());
                editor.putString(FARMNAME, farmName.getText().toString());
                editor.putString(FARMINGTYPE, farmingType.getText().toString());
                editor.putString(DISTRICT, district.getText().toString());
                editor.apply();

                //Showing a toast message after successful profile creation

                if (fullName.getText().toString().isEmpty() && phoneNumber.getText().toString().isEmpty() && farmName.getText().toString().isEmpty() && farmingType.getText().toString().isEmpty() && district.getText().toString().isEmpty()) {
                    fullName.setError("This field is required");
                    phoneNumber.setError("This field is required");
                    farmName.setError("Email is required");
                    farmingType.setError("Password is required");
                    district.setError("Password is required");

                } else {

                    Intent intent = new Intent(getApplicationContext(), Landing.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(getApplicationContext(), "Profile Created", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}



