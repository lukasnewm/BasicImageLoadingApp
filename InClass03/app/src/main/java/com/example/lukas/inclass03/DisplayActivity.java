package com.example.lukas.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    String name;
    String address;
    String phoneNumber;
    String email;
    String mood;
    static String TYPE_KEY;
    static String USER_KEY = "USER";
    public static String VAL_KEY = "VALUE";
    public static String GET_KEY = "GET";
    public static final int NAMECODE = 100;
    public static final int EMAILCODE = 200;
    public static final int PHONECODE = 300;
    public static final int ADDRESSCODE = 400;
    public static final int MOODCODE = 500;
    public User u;
    TextView editName;
    TextView editEmail;
    TextView editPhone;
    TextView editAddress;
    TextView editMood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //final Intent i = new Intent(DisplayActivity.this, EditActivity.class);

        //Intent imI = new Intent("com.example.lukas.inclass03.android.intent.action.VIEW");

        u = (User) getIntent().getSerializableExtra(USER_KEY);

        name = u.getName();
        address = u.getAddress();
        phoneNumber = u.getPhoneNumber();
        email = u.getEmail();
        mood = u.getMood();

        editName = (TextView)findViewById(R.id.nameText);
        editEmail = (TextView)findViewById(R.id.textEmail);
        editPhone = (TextView)findViewById(R.id.phoneText);
        editAddress = (TextView)findViewById(R.id.addressText);
        editMood = (TextView)findViewById(R.id.textMood);

        editName.setText(u.getName());
        editEmail.setText(u.getEmail());
        editMood.setText(u.getMood());
        editPhone.setText(u.getPhoneNumber());
        editAddress.setText(u.getAddress());

        ImageButton butName = (ImageButton)findViewById(R.id.buttonName);
        ImageButton butEmail = (ImageButton)findViewById(R.id.buttonEmail);
        ImageButton butAddress = (ImageButton)findViewById(R.id.buttonAddress);
        ImageButton butMood = (ImageButton)findViewById(R.id.buttonMood);
        ImageButton butPhone = (ImageButton)findViewById(R.id.buttonPhone);

        butName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imI = new Intent("com.example.lukas.inclass03.android.intent.action.VIEW");
                imI.putExtra(TYPE_KEY, "Name");
                imI.putExtra(VAL_KEY, name);
                startActivityForResult(imI, NAMECODE);

            }
        });
        butEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imI = new Intent("com.example.lukas.inclass03.android.intent.action.VIEW");
                imI.putExtra(TYPE_KEY, "Email");
                imI.putExtra(VAL_KEY, email);
                startActivityForResult(imI, EMAILCODE);
            }
        });
        butAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imI = new Intent("com.example.lukas.inclass03.android.intent.action.VIEW");
                imI.putExtra(TYPE_KEY, "Address");
                imI.putExtra(VAL_KEY, address);
                startActivityForResult(imI, ADDRESSCODE);
            }
        });
        butMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imI = new Intent("com.example.lukas.inclass03.android.intent.action.VIEW");
                imI.putExtra(TYPE_KEY, "Mood");
                imI.putExtra(VAL_KEY, mood);
                startActivityForResult(imI, MOODCODE);
            }
        });
        butPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imI = new Intent("com.example.lukas.inclass03.android.intent.action.VIEW");
                imI.putExtra(TYPE_KEY, "Phone");
                imI.putExtra(VAL_KEY, phoneNumber);
                startActivityForResult(imI, PHONECODE);
            }
        });






    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NAMECODE && resultCode == RESULT_OK) {
            name = data.getExtras().getString(GET_KEY);
            u.setName(name);
            editName.setText(name);
        }
        else if (requestCode == PHONECODE && resultCode == RESULT_OK) {
            phoneNumber = data.getExtras().getString(GET_KEY);
            u.setPhoneNumber(phoneNumber);
            editPhone.setText(phoneNumber);
        }
        else if (requestCode == ADDRESSCODE && resultCode == RESULT_OK) {
            address = data.getExtras().getString(GET_KEY);
            u.setAddress(address);
            editAddress.setText(address);
        }
        else if (requestCode == EMAILCODE && resultCode == RESULT_OK) {
            email = data.getExtras().getString(GET_KEY);
            u.setEmail(email);
            editEmail.setText(email);
        }
        else if (requestCode == MOODCODE && resultCode == RESULT_OK) {
            mood = data.getExtras().getString(GET_KEY);
            u.setMood(mood);
            editMood.setText(mood);
        }
        else {
            Toast.makeText(DisplayActivity.this,"Error!", Toast.LENGTH_SHORT).show();
        }
    }
}
