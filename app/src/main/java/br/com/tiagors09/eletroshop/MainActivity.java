package br.com.tiagors09.eletroshop;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.splashscreen.SplashScreen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}