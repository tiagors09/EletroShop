package br.com.tiagors09.eletroshop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class CriacaoDePerfilActivity extends AppCompatActivity {
    private Button btnCancelar, btnSalvar;
    private TextInputEditText cpf, nome, dataNasc, localizacao, email, senha, bio;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criacao_de_perfil);

        cpf = findViewById(R.id.cpf);
        nome = findViewById(R.id.nome);
        dataNasc = findViewById(R.id.dataNasc);
        localizacao = findViewById(R.id.localizacao);
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        bio = findViewById(R.id.bio);

        btnSalvar = findViewById(R.id.buttonSalvar);
        btnCancelar = findViewById(R.id.buttonCancelar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth
                        .createUserWithEmailAndPassword(
                                email.getText().toString(),
                                senha.getText().toString()
                        )
                        .addOnSuccessListener(CriacaoDePerfilActivity.this, new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                databaseReference.child("usuarios").push().setValue(
                                        new Usuario(
                                                cpf.getText().toString(),
                                                nome.getText().toString(),
                                                dataNasc.getText().toString(),
                                                new Localizacao(2, 3),
                                                bio.getText().toString(),
                                                email.getText().toString()
                                        )
                                )
                                        .addOnSuccessListener(CriacaoDePerfilActivity.this, new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Toast
                                                        .makeText(CriacaoDePerfilActivity.this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT)
                                                        .show();
                                            }
                                        });
                            }
                        });
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}