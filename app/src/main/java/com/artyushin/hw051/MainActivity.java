package com.artyushin.hw051;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private EditText settingField;
    private final static String PREF_NAME = "MY_PREF";
    private final static String PREF_KEY = "MY_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        initViews();
    }

    protected void initViews() {
        settingField = findViewById(R.id.text_note);
        settingField.setText(prefs.getString(PREF_KEY, ""));
        Button button = findViewById(R.id.save_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().putString(PREF_KEY, settingField.getText().toString()).apply();
                Toast.makeText(MainActivity.this, R.string.save_info, Toast.LENGTH_LONG).show();
            }
        });
    }
}