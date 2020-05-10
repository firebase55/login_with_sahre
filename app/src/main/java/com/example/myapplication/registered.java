package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class registered extends AppCompatActivity {
    private Button registered_Button;
    private TextInputEditText uname, fullName, Emails, pass, number;
    private TextView login;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        registered_Button = (Button) findViewById(R.id.reg);
        fullName = (TextInputEditText) findViewById(R.id.Full_name);
        uname = (TextInputEditText) findViewById(R.id.user_name);
        Emails = (TextInputEditText) findViewById(R.id.Email_id);
        pass = (TextInputEditText) findViewById(R.id.pass_id);
        number = (TextInputEditText) findViewById(R.id.mobile_no);
        login = (TextView) findViewById(R.id.login_page);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(login);
            }
        });
        registered_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yourFirstName = uname.getText().toString().trim();
                String pass_text = pass.getText().toString();
                if (yourFirstName.equals("") && pass_text.equals("")) {
                    Toast.makeText(registered.this, "put your data", Toast.LENGTH_SHORT).show();
                } else {
                    sharedPreferences = getSharedPreferences("Reg", MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Name", yourFirstName);
                    editor.putString("pass", pass_text);
                    editor.apply();
                    Intent login = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(login);
                    Toast.makeText(registered.this, "Your data is Saved ", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
