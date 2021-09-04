package com.example.wk01hw02;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    List<User> users = new ArrayList<>();


    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText mUsername;
        EditText mPassword;

        loginButton = findViewById(R.id.login);

        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();
                boolean usernameFound = false;

                for(int i = 0; i < users.size(); i++) {
                    if(checkUsername(users.get(i).getUsername(), username)) {
                        usernameFound = true;
                        if (checkPassword(users.get(i).getPassword(), password)) {
                            Intent j = new Intent(MainActivity.this, LandingPageActivity.class);
                            Bundle extraInfo = new Bundle();
                            extraInfo.putString("userId", users.get(i).getId());
                            extraInfo.putString("username", username);
                            j.putExtras(extraInfo);
                            startActivity(j);
                            finish();
                        } else {
                            mUsername.clearFocus();
                            mUsername.setSelectAllOnFocus(false);

                            mPassword.setSelectAllOnFocus(true);
                            mPassword.requestFocus();

                            Context context = getApplicationContext();
                            CharSequence text = "Wrong password. Please re-enter credentials.";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                    }
                }
                if(!usernameFound) {
                    mPassword.clearFocus();
                    mPassword.setSelectAllOnFocus(false);

                    mUsername.setSelectAllOnFocus(true);
                    mUsername.requestFocus();

                    Context context = getApplicationContext();
                    CharSequence text = "Wrong Username. Please re-enter credentials.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });


        users.add(new User("Bret", "bret", "1"));
        users.add(new User("Antonette", "anton", "2"));
        users.add(new User("Samantha", "sam", "3"));
        users.add(new User("Karianne", "kar", "4"));
        users.add(new User("Kamren", "kam", "5"));
        users.add(new User("Leopoldo_Corkery", "leo", "6"));
        users.add(new User("Elwyn.Skyles", "el", "7"));
        users.add(new User("Maxime_Nienow", "max", "8"));
        users.add(new User("Delphine", "del", "9"));
        users.add(new User("Moriah.Stanton", "mo", "10"));

    }

    public static boolean checkUsername(String username1, String username2) {
        return username1.equals(username2);
    }

    public static boolean checkPassword(String password1, String password2) {
        return password1.equals(password2);
    }
}