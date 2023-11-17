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

import java.time.format.DateTimeFormatter;

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
                .ler()
                        .addOnSuccessListener(
                                usuario -> {
                                    textViewNome.setText(usuario.getNome());
                                    textViewDataNasc.setText(usuario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
                                    textViewBio.setText(usuario.getBio());
                                    imageViewPerfil.setImageResource(usuario.getFotoPerfil());
                                }
                        )
                                .addOnFailureListener(
                                        e -> Toast
                                                .makeText(
                                                        getContext(),
                                                        e.getMessage(),
                                                        Toast.LENGTH_SHORT
                                                )
                                                .show()
                                );



        buttonEditarPerfil.setOnClickListener(view1 -> {
            Intent intent = new Intent(view1.getContext(), EdicaoDePerfilActivity.class);
            startActivity(intent);
        });

        buttonLogout.setOnClickListener(view12 -> {
            Intent intent = new Intent(view12.getContext(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        return view;
    }
}