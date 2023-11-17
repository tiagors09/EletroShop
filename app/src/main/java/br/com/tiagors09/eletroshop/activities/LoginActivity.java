package br.com.tiagors09.eletroshop.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText email, senha;
    private TextInputEditText[] campos;
    private TextView textViewCadastro;
    private Button buttonLogin;
    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.textInputEditTextEmail);
        senha = findViewById(R.id.textInputEditTextSenha);

        campos = new TextInputEditText[]{email, senha};

        textViewCadastro = findViewById(R.id.textViewCadastro);
        buttonLogin = findViewById(R.id.buttonSalvar);

        usuarioDAO = UsuarioDAOImpl.getInstance();

        buttonLogin.setOnClickListener(v -> {
            validarCampos();

            if (Arrays.stream(campos).allMatch(campo -> !TextUtils.isEmpty(campo.getText()))) {
                usuarioDAO
                        .entrar(new Usuario(email.getText().toString(), senha.getText().toString()))
                                .addOnSuccessListener(authResult -> startActivity(
                                                new Intent(getApplicationContext(), MainActivity.class)
                                                        .addFlags(
                                                                Intent.FLAG_ACTIVITY_NEW_TASK |
                                                                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                                                        )
                                        )
                                )
                                .addOnFailureListener(
                                        e -> {
                                            Toast
                                                    .makeText(
                                                            LoginActivity.this,
                                                            e.getMessage(),
                                                            Toast.LENGTH_SHORT
                                                    )
                                                    .show();
                                        }
                                );
            }
        });

        textViewCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getApplicationContext(), CriacaoDePerfilActivity.class)
                );
            }
        });
    }

    private void validarCampos() {
        for (TextInputEditText campo: campos) {
            if (TextUtils.isEmpty(campo.getText()))
                campo.setError("Esse campo tá vazio");
        }
    }
}