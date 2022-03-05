package com.example.android.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


public class SplashActivity extends Activity implements View.OnClickListener{
   LinearLayout mysplash;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        mysplash = findViewById(R.id.mySpalishlinerlayout);
        mysplash.setOnClickListener(this);
    }//end onCreate()

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"you are on Paues",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        //what to do on click
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
    }//end onClick
}//end class
