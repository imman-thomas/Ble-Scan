package com.example.foregroundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button startService,stopService;
    public static final  String TAG= "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text_input);

    }

    public void startService(View v)
    {
        String input = editText.getText().toString();
        Intent serviceIntent = new Intent(this,ForegroundService.class);
        serviceIntent.putExtra(TAG,input);
        startService(serviceIntent);
    }

    public void stopService(View v)
    {
        Intent serviceIntent = new Intent(this,ForegroundService.class);
        stopService(serviceIntent);
    }
}