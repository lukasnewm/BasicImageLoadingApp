package com.example.lukas.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.lukas.inclass03.DisplayActivity.TYPE_KEY;
import static com.example.lukas.inclass03.DisplayActivity.USER_KEY;
import static com.example.lukas.inclass03.DisplayActivity.VAL_KEY;

public class EditActivity extends AppCompatActivity {

    String textForBox;
    String valueToEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        textForBox = getIntent().getSerializableExtra(TYPE_KEY).toString();

        final EditText editValue = (EditText) findViewById(R.id.editAsset);

        TextView textBox = (TextView) findViewById(R.id.textDisplay);
        textBox.setText(textForBox);

        valueToEdit = (String) getIntent().getSerializableExtra(VAL_KEY);

        /*
        if (textForBox.equals("Name"))
        {
            editValue.setText(u.getName());
        }
        else if (textForBox.equals("Phone"))
        {
            editValue.setText(u.getPhoneNumber());
        }
        else if (textForBox.equals("Address"))
        {
            editValue.setText(u.getAddress());
        }
        else if (textForBox.equals("Mood"))
        {
            editValue.setText(u.getMood());
        }
        else if (textForBox.equals("Email"))
        {
            editValue.setText(u.getEmail());
        }
        */

        editValue.setText(valueToEdit);


        Button saveBtn = (Button) findViewById(R.id.buttonSave);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent inten = new Intent (EditActivity.this, DisplayActivity.class);
                /*
                if (textForBox.equals("Name") && editValue.getText().toString().length() > 0)
                {
                    valueToEdit = editValue.getText().toString().trim();
                    inten.putExtra(VAL_KEY, valueToEdit);
                    startActivity(inten);
                }
                else if (textForBox.equals("Phone") && editValue.getText().toString().length() > 0)
                {
                    valueToEdit = editValue.getText().toString().trim();
                    inten.putExtra(USER_KEY, u);
                    startActivity(inten);
                }
                else if (textForBox.equals("Address") && editValue.getText().toString().length() > 0)
                {
                    valueToEdit = editValue.getText().toString().trim();
                    inten.putExtra(USER_KEY, u);
                    startActivity(inten);
                }
                else if (textForBox.equals("Mood") && editValue.getText().toString().length() > 0)
                {
                    valueToEdit = editValue.getText().toString().trim();
                    inten.putExtra(USER_KEY, u);
                    startActivity(inten);
                }
                else if (textForBox.equals("Email") && editValue.getText().toString().length() > 0)
                {
                    valueToEdit = editValue.getText().toString().trim();
                    inten.putExtra(USER_KEY, u);
                    startActivity(inten);
                }
                else
                {
                    Toast.makeText(EditActivity.this,"Enter All Required Fields", Toast.LENGTH_SHORT).show();
                }
                */
                if (editValue.getText().toString().length() > 0)
                {
                    valueToEdit = editValue.getText().toString().trim();
                    Intent intented = new Intent();

                    intented.putExtra(DisplayActivity.GET_KEY, valueToEdit);
                    setResult(RESULT_OK, intented);
                    finish();

                }
                else
                {
                    Toast.makeText(EditActivity.this,"Enter All Required Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
