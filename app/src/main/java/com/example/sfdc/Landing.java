package com.example.sfdc;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;



import com.example.sfdc.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Landing extends AppCompatActivity {
    String message = "Are you sure you want to exit?";
    String title = "Confirm exit";
    AlertDialog.Builder builder;
    private AppBarConfiguration mAppBarConfiguration;
    public static final String SHAREDPREFERENCIES = "shared";
    public static final String FULLNAME = "fullName";
    public String field1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_scanCamera , R.id.nav_schedule,R.id.nav_showProfile)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.content_landing_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        SharedPreferences shared = getSharedPreferences(SHAREDPREFERENCIES, MODE_PRIVATE);
        field1 = shared.getString(FULLNAME,null);
    }

//    @Override
//    public void onDestroy(){
//        super.onDestroy();
//        //Uncomment the below code to Set the message and title from the strings.xml file
//        builder.setMessage(message) .setTitle(title);
//
//        //Setting message manually and performing action on button click
//        builder.setMessage("Do you want to close this application ?")
//                .setCancelable(false)
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        finish();
//                    }
//                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        //  Action for 'NO' Button
//                        dialog.cancel();
//
//                    }
//                });
//        //Creating dialog box
//        AlertDialog alert = builder.create();
//        //Setting the title manually
//        alert.setTitle("AlertDialogExample");
//        alert.show();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_landing , menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.content_landing_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}