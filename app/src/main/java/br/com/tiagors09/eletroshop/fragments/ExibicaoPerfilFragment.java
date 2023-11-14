package br.com.tiagors09.eletroshop.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.activities.EdicaoDePerfilActivity;
import br.com.tiagors09.eletroshop.activities.LoginActivity;
import br.com.tiagors09.eletroshop.dao.UsuarioDAO;
import br.com.tiagors09.eletroshop.dao.UsuarioDAOImpl;
import br.com.tiagors09.eletroshop.global.AppState;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class ExibicaoPerfilFragment extends Fragment {
    private Button buttonLogout, buttonEditarPerfil;
    private TextView textViewNome, textViewLocalizacao, textViewDataNasc, textViewBio;
    private ImageView imageViewPerfil;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exibicao_perfil,container,false);

        buttonLogout = view.findViewById(R.id.buttonLogout);
        buttonEditarPerfil = view.findViewById(R.id.buttonEditarPerfil);
        textViewNome = view.findViewById(R.id.textViewNome);
        textViewLocalizacao = view.findViewById(R.id.textViewLocalizacao);
        textViewDataNasc = view.findViewById(R.id.textViewDataNasc);
        textViewBio = view.findViewById(R.id.textViewBio);
        imageViewPerfil = view.findViewById(R.id.imageViewPerfil);

        usuarioDAO = UsuarioDAOImpl.getInstance();

        usuarioDAO
                .ler("01234567891")
                        .addOnSuccessListener(
                                new OnSuccessListener<Usuario>() {
                                    @Override
                                    public void onSuccess(Usuario usuario) {
                                        textViewNome.setText(usuario.getNome());
                                        textViewLocalizacao.setText(usuario.getLocal().toString());
                                        textViewDataNasc.setText(usuario.getDataNascimento().toString());
                                        textViewBio.setText(usuario.getBio());
                                        imageViewPerfil.setImageResource(usuario.getFotoPerfil());
                                    }
                                }
                        )
                                .addOnFailureListener(
                                        new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast
                                                        .makeText(
                                                                getContext(),
                                                                e.getMessage(),
                                                                Toast.LENGTH_SHORT
                                                        )
                                                        .show();
                                            }
                                        }
                                );



        buttonEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EdicaoDePerfilActivity.class);
                intent.putExtra("USUARIO_CHAVE", "01234567891");
                startActivity(intent);
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        return view;
    }
}