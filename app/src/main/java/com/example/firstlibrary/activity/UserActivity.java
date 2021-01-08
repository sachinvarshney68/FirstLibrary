package com.example.firstlibrary.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.firstlibrary.R;
import com.example.firstlibrary.SDK;
import com.example.firstlibrary.model.User;
import com.google.android.material.snackbar.Snackbar;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        TextView name = findViewById(R.id.name);
        TextView password = findViewById(R.id.password);
        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(view -> {
            if (name.getText().toString().trim().isEmpty()) {
                Snackbar.make(view, "Please enter the name", Snackbar.LENGTH_LONG).show();
                return;
            }
            if (password.getText().toString().trim().isEmpty()) {
                Snackbar.make(view, "Please enter the password", Snackbar.LENGTH_LONG).show();
                return;
            }

            User user = new User(name.getText().toString().trim(), password.getText().toString().trim());
            SDK.getInstance().setUserData(user);
            finish();
        });

    }
}