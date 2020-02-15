package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2;
    Button getstarted;
    Animation myanimations,animation1,animation2;
    ImageView myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView) findViewById(R.id.vSplash);
        tv2=(TextView) findViewById(R.id.ivSplash);
        getstarted=(Button) findViewById(R.id.get_started);
        myImage=findViewById(R.id.Splash);

        myanimations= AnimationUtils.loadAnimation(this,R.anim.myanimations);
        animation1= AnimationUtils.loadAnimation(this,R.anim.animation1);
        animation2= AnimationUtils.loadAnimation(this,R.anim.animation2);

        myImage.startAnimation(myanimations);
        tv1.startAnimation(animation1);
        tv2.startAnimation(animation1);
        getstarted.startAnimation(animation2);

        getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ChooseYourActionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        Typeface LatoLight= Typeface.createFromAsset(getAssets(),"fonts/LatoLight.ttf");
        Typeface LatoRegular= Typeface.createFromAsset(getAssets(),"fonts/LatoRegular.ttf");
        Typeface MMedium=Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");


        tv1.setTypeface(LatoLight);
        tv2.setTypeface(LatoRegular);
        getstarted.setTypeface(MMedium);



    }
}
