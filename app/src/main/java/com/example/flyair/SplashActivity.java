package com.example.flyair;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView plane = findViewById(R.id.planeImage);
        TextView splashText = findViewById(R.id.splashText);

        // הטקסט מופיע ישר
        splashText.setAlpha(1f);

        // --- שלב 1: תנועה מלמטה למרכז המסך ---
        TranslateAnimation translate = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0.3f,
                Animation.RELATIVE_TO_PARENT, 1f,
                Animation.RELATIVE_TO_PARENT, 0f
        );
        translate.setDuration(2000); // מטוס מגיע למרכז תוך 2 שניות
        translate.setFillAfter(true);

        // --- שלב 2: הגדלה קלה של המטוס ---
        ScaleAnimation scale = new ScaleAnimation(
                1f, 1.2f,
                1f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        scale.setDuration(1000); // גדילה תוך 1 שניה
        scale.setStartOffset(2000); // מתחילה אחרי התנועה
        scale.setFillAfter(true);

        // --- שמים את שניהם יחד ---
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(translate);
        set.addAnimation(scale);

        plane.startAnimation(set);

        // --- מעבר למסך הבא אחרי 3 שניות ---
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, 3000);
    }
}
