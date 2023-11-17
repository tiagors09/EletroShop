package br.com.tiagors09.eletroshop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.dao.UsuarioDAO;
import br.com.tiagors09.eletroshop.dao.UsuarioDAOImpl;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class CriacaoDePerfilActivity extends AppCompatActivity {
    private Button btnCancelar, btnSalvar;
    private TextInputEditText textInputEditTextNome, textInputEditTextDataNasc, textInputEditTextLocal, textInputEditTextEmail, textInputEditTextSenha, textInputEditTextBio;
    private TextInputEditText[] campos;
    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criacao_de_perfil);

        textInputEditTextNome = findViewById(R.id.textInputEditTextNome);
        textInputEditTextDataNasc = findViewById(R.id.textInputEditTextDataNasc);
        textInputEditTextLocal = findViewById(R.id.textInputEditTextLocal);
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        textInputEditTextSenha = findViewById(R.id.textInputEditTextSenha);
        textInputEditTextBio = findViewById(R.id.textInputEditTextBio);

        campos = new TextInputEditText[]{textInputEditTextNome, textInputEditTextDataNasc, textInputEditTextLocal, textInputEditTextEmail, textInputEditTextSenha, textInputEditTextBio};

        btnSalvar = findViewById(R.id.buttonSalvar);
        btnCancelar = findViewById(R.id.buttonCancelar);

        usuarioDAO = UsuarioDAOImpl.getInstance();

        btnSalvar.setOnClickListener(v -> {
            validarCampos();

            if (Arrays.stream(campos).allMatch(campo -> !TextUtils.isEmpty(campo.getText()))) {
                usuarioDAO
                        .salvar(
                                new Usuario(
                                        textInputEditTextNome.getText().toString(),
                                        textInputEditTextDataNasc.getText().toString(),
                                        textInputEditTextBio.getText().toString(),
                                        textInputEditTextEmail.getText().toString(),
                                        textInputEditTextSenha.getText().toString()
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


                                        finish();
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

        btnCancelar.setOnClickListener(view -> finish());
    }

    private void validarCampos() {
        for (TextInputEditText campo : campos) {
            if (TextUtils.isEmpty(campo.getText()))
                campo.setError("O campo está vazio");
        }
    }
}