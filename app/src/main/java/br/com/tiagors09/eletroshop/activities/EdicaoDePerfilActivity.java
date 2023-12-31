package br.com.tiagors09.eletroshop.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.dao.UsuarioDAO;
import br.com.tiagors09.eletroshop.dao.UsuarioDAOImpl;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class EdicaoDePerfilActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Button buttonEditarImagem, buttonCancelar, buttonSalvar;
    private TextInputEditText textInputEditTextNome, textInputEditTextNomeDataNasc, textInputEditTextLocal, textInputEditTextEmail, textInputEditTextSenha, textInputEditTextNomeBio;
    private ImageView imgPerfil;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_de_perfil);

        buttonEditarImagem = findViewById(R.id.buttonEditarImagem);
        textInputEditTextNome = findViewById(R.id.textInputEditTextNome);
        textInputEditTextNomeDataNasc = findViewById(R.id.textInputEditTextNomeDataNasc);
        textInputEditTextLocal = findViewById(R.id.localizacao);
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        textInputEditTextSenha = findViewById(R.id.textInputEditTextSenha);
        textInputEditTextNomeBio = findViewById(R.id.textInputEditTextNomeBio);
        imgPerfil = findViewById(R.id.imgPerfil);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonCancelar = findViewById(R.id.buttonCancelar);

        Bundle extras = getIntent().getExtras();
        String usuarioChave = extras.getString("USUARIO_CHAVE");

        usuarioDAO = UsuarioDAOImpl.getInstance();
        usuarioDAO
                .ler()
                        .addOnSuccessListener(
                                new OnSuccessListener<Usuario>() {
                                    @Override
                                    public void onSuccess(Usuario usuario) {
                                        textInputEditTextNome.setText(usuario.getNome());
                                        textInputEditTextNomeDataNasc.setText(usuario.getDataNascimento().toString());
                                        textInputEditTextLocal.setText(usuario.getLocal().toString());
                                        textInputEditTextEmail.setText(usuario.getEmail());
                                        //        textInputEditTextSenha.setText(usuario.get);
                                        textInputEditTextNomeBio.setText(usuario.getBio());
                                        imgPerfil.setImageResource(usuario.getFotoPerfil());
                                    }
                                }
                        )
                                .addOnFailureListener(
                                        new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast
                                                        .makeText(
                                                                EdicaoDePerfilActivity.this,
                                                                e.getMessage(),
                                                                Toast.LENGTH_SHORT)
                                                        .show();
                                            }
                                        }
                                );



        buttonEditarImagem.setOnClickListener(new View.OnClickListener() {
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

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgPerfil.setImageBitmap(imageBitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}