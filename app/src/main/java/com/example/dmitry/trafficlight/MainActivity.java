package com.example.dmitry.trafficlight;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button red;
    private Button yellow;
    private Button green;
    private View view;
    private int currentBackgroundColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Определение элементов экрана по id
        red = findViewById(R.id.red_button);
        yellow = findViewById(R.id.yellow_button);
        green = findViewById(R.id.green_button);
        view = findViewById(R.id.activity);

        //установка обработчика для кнопок
        red.setOnClickListener(this);
        yellow.setOnClickListener(this);
        green.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        currentBackgroundColor = Color.TRANSPARENT;
        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable)
            currentBackgroundColor = ((ColorDrawable) background).getColor();

        outState.putInt("background_color", currentBackgroundColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null && savedInstanceState.containsKey("background_color")) {
            view.setBackgroundColor(savedInstanceState.getInt("background_color"));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.red_button:
                view.setBackgroundColor(Color.RED);
                break;
            case R.id.yellow_button:
                view.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.green_button:
                view.setBackgroundColor(Color.GREEN);
                break;
        }
    }
}
