package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class AnimationActivity extends AppCompatActivity {
    Button button,done2,done3,done4,done5,done6,done7,done8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        button=findViewById(R.id.done);
        done2=findViewById(R.id.done2);
        done3=findViewById(R.id.done3);
        done4=findViewById(R.id.done4);
        //Animation animation= AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.mixed_anim);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.mixed_anim);
                button.startAnimation(animation);
            }
        });
        done2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.fadein);
                done2.startAnimation(animation);
            }
        });
        done3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.zoomin);
                done3.startAnimation(animation);
                finish();
                Intent intent=new Intent(AnimationActivity.this,ChooseYourActionActivity.class);
                startActivity(intent);
                
            }
        });
        done4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.mixed_anim);
                done4.startAnimation(animation);
            }
        });


    }
}
