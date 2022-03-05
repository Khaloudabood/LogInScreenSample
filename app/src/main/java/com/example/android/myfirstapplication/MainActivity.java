package com.example.android.myfirstapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
EditText userName, password;
Button login, cancel;
String CorrectUserName = "k";
String CorrectPassword = "123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);

        login = findViewById(R.id.login);
        login.setOnClickListener(this);
        cancel = findViewById(R.id.cencel);
        cancel.setOnClickListener(this);

    }//end onCreate()

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                //code
                String InputUserName = userName.getText().toString();
                String InputPassword = password.getText().toString();

                if (InputUserName.equalsIgnoreCase(CorrectUserName) && InputPassword.equalsIgnoreCase(CorrectPassword))
                {
                    Toast.makeText(this,"Sucsses",Toast.LENGTH_LONG).show();

                    //save User name and password
                    SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("user_name_pref", InputUserName);
                    editor.putString("password_pref", InputPassword);
                    editor.commit();

                    //read from sharedPref.
                    SharedPreferences readPref = getPreferences(Context.MODE_PRIVATE);
                    String SavedName = readPref.getString("user_name_pref", "");
                    Toast.makeText(this, "User name is:" + SavedName, Toast.LENGTH_LONG).show();

                }//end if
                else {
                    Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show();
                }//end else

                break;
            case R.id.cencel:
                //code
                userName.setText("");
                password.setText("");
                break;
        }//end switch
    }//end onClick()
}//end class