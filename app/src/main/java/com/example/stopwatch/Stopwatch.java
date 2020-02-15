package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Stopwatch extends AppCompatActivity {
    Button start,stop;
    ImageView anchor;
    Animation rotate;
    Chronometer timer;
    PublisherAdView mPublisherAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        //Initializes mobile adds
        MobileAds.initialize(this,"ca-app-pub-1354053422039438~4488291229");
        /*
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });*/

        mPublisherAdView = findViewById(R.id.publisherAdView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mPublisherAdView.loadAd(adRequest);
        //start


        start=findViewById(R.id.start_stop_watch);
        anchor=findViewById(R.id.anchor);
        stop=findViewById(R.id.stop);
        timer=findViewById(R.id.watch_chronometer);
        stop.setAlpha(0);

        rotate= AnimationUtils.loadAnimation(this,R.anim.rotate);

        Typeface MMedium=Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");

        start.setTypeface(MMedium);
        stop.setTypeface(MMedium);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anchor.startAnimation(rotate);
                stop.animate().alpha(1).translationY(-80).setDuration(300).start();
                start.animate().alpha(0).setDuration(300).start();
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                anchor.clearAnimation();
                start.animate().alpha(1).translationY(-80).setDuration(300).start();
                stop.animate().alpha(0).setDuration(300).start();

               // timer.setBase(SystemClock.elapsedRealtime());


                timer.stop();

            }
        });
    }
}
