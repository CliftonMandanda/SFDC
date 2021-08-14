package com.example.sfdc;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;


import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Handler;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.opencv.android.OpenCVLoader;

import java.lang.annotation.Annotation;

public class MainActivity extends AppCompatActivity implements View.OnCreateContextMenuListener {

    private static String TAG = "MainActivity";

    static
    {
        if (OpenCVLoader.initDebug()) Log.d(TAG, "OpenCV is Configured Successfully");
        else {
            Log.d(TAG,"OpenCV not Working");
        }
    }

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private static int SPLASH_SCREEN = 5000;

    //Variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView homeLogo1, homeLogo2, homeLogo3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animatiom);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        /*---------------------HOOKS------------------------------*/
        image = findViewById(R.id.imageView);
        homeLogo1 = findViewById(R.id.homeLogo1);
        homeLogo2 = findViewById(R.id.homeLogo2);
        homeLogo3 = findViewById(R.id.homeLogo3);
        /*---------------------animation------------------------------*/
        image.setAnimation(topAnim);
        homeLogo1.setAnimation(bottomAnim);
        homeLogo2.setAnimation(bottomAnim);
        homeLogo3.setAnimation(bottomAnim);

        /*---------------------HOOKS------------------------------*/
//        drawerLayout = findViewById(R.id.drawer_layout);
//        navigationView = findViewById(R.id.nav_view);
//        toolbar = findViewById(R.id.toolbar);
        /*---------------------tool bar------------------------------*/
//        setSupportActionBar(toolbar);
        /*---------------------Navigation Drawer Menu------------------------------*/
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();






        new Handler() .postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}