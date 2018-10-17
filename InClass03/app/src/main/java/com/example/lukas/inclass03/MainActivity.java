package com.example.lukas.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/*
Lukas Newman and Jonathan Evans
Inclass03
 */

public class MainActivity extends AppCompatActivity {

    String name;
    String email;
    String phoneNumber;
    String address;
    String mood;
    static String USER_KEY = "USER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editName = (EditText)findViewById(R.id.editName);
        final EditText editEmail = (EditText)findViewById(R.id.editEmail);
        final EditText editPhone = (EditText)findViewById(R.id.editPhone);
        final EditText editAddress = (EditText)findViewById(R.id.editAddress);
        final EditText editMood = (EditText)findViewById(R.id.editMood);

        Button submit = (Button) findViewById(R.id.buttonSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editName.getText().toString();
                email = editEmail.getText().toString();
                phoneNumber = editPhone.getText().toString();
                address = editAddress.getText().toString();
                mood = editMood.getText().toString();

                if (name.length() <= 0 || email.length() <= 0 || phoneNumber.length() <= 0 || address.length() <= 0 || mood.length() <= 0)
                {
                    Toast.makeText(MainActivity.this,"Enter All Required Fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    User user1 = new User (name, email, phoneNumber, address, mood);

                    Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                    intent.putExtra(USER_KEY, user1);
                    startActivity(intent);


                }
            }
        });

    }
}
