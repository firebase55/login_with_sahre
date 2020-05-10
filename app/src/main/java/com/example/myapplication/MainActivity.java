package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText Emailid, Passid;
    private Button Login_Button, ok;
    private TextView registerd_page;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerd_page = (TextView) findViewById(R.id.reg);
        Emailid = (TextInputEditText) findViewById(R.id.username);
        Passid = (TextInputEditText) findViewById(R.id.password);
        Login_Button = (Button) findViewById(R.id.login);

        registerd_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), registered.class);
                startActivity(intent);
            }
        });
        Login_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = Emailid.getText().toString().trim();
                String passid = Passid.getText().toString().trim();
                sharedPreferences = getSharedPreferences("Reg", MODE_PRIVATE);

                if (name.equals("") || passid.equals("")) {
                    Toast.makeText(MainActivity.this, "input data", Toast.LENGTH_SHORT).show();
                } else {
                    String user_name = sharedPreferences.getString("Name", "");
                    String pas = sharedPreferences.getString("pass", "");
                    if (name.equals(user_name) && passid.equals(pas)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        ViewGroup viewGroup = findViewById(android.R.id.content);
                        View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.custombox, viewGroup, false);
                        builder.setView(dialogView);
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        ok = (Button) dialogView.findViewById(R.id.buttonOk);
                        ok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent main = new Intent(getApplicationContext(), Mainpage.class);
                                startActivity(main);

                            }
                        });


                    }

                }

            }
        });


    }
}
