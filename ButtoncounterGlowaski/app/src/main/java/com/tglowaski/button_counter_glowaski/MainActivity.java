package com.tglowaski.button_counter_glowaski;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView counterTxt;
    private Button minusBtn;
    private Button plusBtn;
    private Button resetBtn;
    private Button doubleBtn;
    private int counter;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.minusBtn :
                    minusCounter();
                    break;
                case R.id.plusBtn :
                    plusCounter();
                    break;
                case R.id.resetBtn :
                    initCounter();
                    break;
                case R.id.doubleBtn :
                    doubleCounter();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterTxt = (TextView) findViewById(R.id.counterTxt);
        minusBtn = (Button) findViewById(R.id.minusBtn);
        minusBtn.setOnClickListener(clickListener);
        plusBtn = (Button) findViewById(R.id.plusBtn);
        plusBtn.setOnClickListener(clickListener);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(clickListener);
        doubleBtn = (Button) findViewById(R.id.doubleBtn);
        doubleBtn.setOnClickListener(clickListener);

        initCounter();
    }

    private void initCounter(){
        counter = 0;
        findViewById(R.id.doubleBtn).setVisibility(View.INVISIBLE);
        counterTxt.setText(counter + "");
    }

    private void plusCounter(){
        counter++;
        findViewById(R.id.doubleBtn).setVisibility(View.VISIBLE);
        counterTxt.setText(counter + "");
    }

    private void minusCounter(){
        counter--;
        findViewById(R.id.doubleBtn).setVisibility(View.VISIBLE);
        counterTxt.setText(counter + "");
    }

    private void doubleCounter(){
        counter = counter * 2;
        counterTxt.setText(counter + "");
    }

}
