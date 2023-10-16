package br.com.tiagors09.eletroshop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import br.com.tiagors09.eletroshop.R;

public class SplashScreenCompraFinalizada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_compra_finalizada);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenCompraFinalizada.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}