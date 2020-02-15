package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.spark.submitbutton.SubmitButton;

public class ChooseYourActionActivity extends AppCompatActivity {
    SubmitButton steps,stopwatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_action);

        steps=(SubmitButton) findViewById(R.id.step_anim_btn);
        stopwatch=(SubmitButton) findViewById(R.id.stop_anim_btn);

        steps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(ChooseYourActionActivity.this,StepsandDistanceActivity.class);
                //startActivity(intent);
                Runnable r=new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ChooseYourActionActivity.this,StepsandDistanceActivity.class));
                    }
                };
                view.postDelayed(r,3000);
            }
        });
        stopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(ChooseYourActionActivity.this,Stopwatch.class);
                Runnable r=new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ChooseYourActionActivity.this,Stopwatch.class));
                    }
                };
                view.postDelayed(r,3000);

            }
        });
    }
}
