package br.com.tiagors09.eletroshop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.dao.UsuarioDAO;
import br.com.tiagors09.eletroshop.dao.UsuarioDAOImpl;
import br.com.tiagors09.eletroshop.global.AppState;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText email, senha;
    private TextView textViewCadastro;
    private Button buttonLogin;
    private UsuarioDAO usuarioDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        textViewCadastro = findViewById(R.id.textViewCadastro);
        buttonLogin = findViewById(R.id.buttonSalvar);

        usuarioDAO = UsuarioDAOImpl.getInstance();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String emailUsuario = email.getText().toString();
//                String senhaUsuario = senha.getText().toString();
//
//                Usuario usuario = usuarioDAO.ler(emailUsuario);
//                if (usuario.getPassword().equals(senhaUsuario)) {
//                    AppState.estaLogado = true;
//                    AppState.usuario = usuario;
//                    startActivity(
//                            new Intent(getApplicationContext(),MainActivity.class)
//                                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                    );
//                }
                startActivity(
                        new Intent(getApplicationContext(),MainActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                );
            }
        });

        textViewCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getApplicationContext(), CriacaoDePerfilActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                );
            }
        });
    }


}