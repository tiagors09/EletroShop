package br.com.tiagors09.eletroshop.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class CriacaoDePerfilActivity extends AppCompatActivity {
    private Button btnCancelar, btnSalvar;
    private TextInputEditText email, senha;
    private TextInputEditText[] campos;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criacao_de_perfil);

        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);

        campos = new TextInputEditText[]{email, senha};

        btnSalvar = findViewById(R.id.buttonSalvar);
        btnCancelar = findViewById(R.id.buttonCancelar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCampos();

                if (Arrays.stream(campos).allMatch(campo -> !TextUtils.isEmpty(campo.getText()))) {
                    firebaseAuth
                            .createUserWithEmailAndPassword(
                                    email.getText().toString(),
                                    senha.getText().toString()
                            )
                            .addOnSuccessListener(
                                    CriacaoDePerfilActivity.this,
                                    new OnSuccessListener<AuthResult>() {
                                        @Override
                                        public void onSuccess(AuthResult authResult) {
                                           finish();
                                        }
                                    }
                            )
                            .addOnFailureListener(
                                    CriacaoDePerfilActivity.this,
                                    new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast
                                                    .makeText(
                                                            CriacaoDePerfilActivity.this,
                                                            e.getMessage(),
                                                            Toast.LENGTH_SHORT)
                                                    .show();
                                        }
                                    }
                            );
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void validarCampos() {
        for (TextInputEditText campo : campos) {
            if (TextUtils.isEmpty(campo.getText()))
                campo.setError("O campo está vazio");
        }
    }
}