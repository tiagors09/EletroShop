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

import java.util.Arrays;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.dao.UsuarioDAO;
import br.com.tiagors09.eletroshop.dao.UsuarioDAOImpl;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class CriacaoDePerfilActivity extends AppCompatActivity {
    private Button btnCancelar, btnSalvar;
    private TextInputEditText email, senha;
    private TextInputEditText[] campos;
    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criacao_de_perfil);

        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);

        campos = new TextInputEditText[]{email, senha};

        btnSalvar = findViewById(R.id.buttonSalvar);
        btnCancelar = findViewById(R.id.buttonCancelar);

        usuarioDAO = UsuarioDAOImpl.getInstance();

        btnSalvar.setOnClickListener(v -> {
            validarCampos();

            if (Arrays.stream(campos).allMatch(campo -> !TextUtils.isEmpty(campo.getText()))) {
                usuarioDAO
                        .salvar(
                                new Usuario(
                                        "123.456.784.353.95",
                                        "Tiago",
                                        "28/01/2001",
                                        new Localizacao(2, 3),
                                        "teste",
                                        email.getText().toString(),
                                        senha.getText().toString()
                                )
                        )
                        .addOnSuccessListener(
                                aBoolean -> {
                                    if (aBoolean) {
                                        Toast
                                                .makeText(
                                                        CriacaoDePerfilActivity.this,
                                                        "Deu bom!",
                                                        Toast.LENGTH_SHORT
                                                )
                                                .show();
                                    }
                                }
                        )
                        .addOnFailureListener(
                                e -> Toast
                                        .makeText(
                                                CriacaoDePerfilActivity.this,
                                                e.getMessage(),
                                                Toast.LENGTH_SHORT
                                        )
                                        .show()
                        );
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