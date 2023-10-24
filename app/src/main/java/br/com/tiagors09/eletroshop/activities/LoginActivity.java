package br.com.tiagors09.eletroshop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

import br.com.tiagors09.eletroshop.R;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText email, senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}