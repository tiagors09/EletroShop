package br.com.tiagors09.eletroshop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.tiagors09.eletroshop.R;

public class EdicaoDePerfil extends AppCompatActivity {
    Button buttonEditarPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_de_perfil);

        buttonEditarPerfil = findViewById(R.id.buttonEditarImagem);

        buttonEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try {
                    startActivity(takePictureIntent);
                } catch (ActivityNotFoundException e) {
                    Toast
                            .makeText(
                                    getApplicationContext(),
                                    e.getMessage(),
                                    Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

    }
}