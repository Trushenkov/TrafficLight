package com.example.dmitry.trafficlight;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    private Button red;
    private Button yellow;
    private Button green;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button-элементы
        red = findViewById(R.id.red_button);
        yellow = findViewById(R.id.yellow_button);
        green = findViewById(R.id.green_button);
        view = findViewById(R.id.activity);


        red.setOnClickListener(this);
        yellow.setOnClickListener(this);
        green.setOnClickListener(this);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        int color = Color.TRANSPARENT;
        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable)
            color = ((ColorDrawable) background).getColor();

        outState.putInt("background_color", color);
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
            // кнопка "Красный"
            case R.id.red_button:
                view.setBackgroundColor(Color.RED);
                break;
            // кнопка "Желтый"
            case R.id.yellow_button:
                view.setBackgroundColor(Color.YELLOW);
                break;
            //кнопка "Зеленый"
            case R.id.green_button:
                view.setBackgroundColor(Color.GREEN);
                break;
        }
    }
}
