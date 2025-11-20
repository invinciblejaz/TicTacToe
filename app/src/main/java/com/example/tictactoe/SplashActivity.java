package com.example.tictactoe; // <-- change if your package is different

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        LottieAnimationView lottieView = findViewById(R.id.animation);

        lottieView.addAnimatorListener(new android.animation.AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(android.animation.Animator animation) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Disable back on splash
    }
}
