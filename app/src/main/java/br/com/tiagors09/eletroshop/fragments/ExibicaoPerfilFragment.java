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

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.activities.EdicaoDePerfilActivity;
import br.com.tiagors09.eletroshop.activities.LoginActivity;

public class ExibicaoPerfilFragment extends Fragment {
    private Button buttonLogout, buttonEditarPerfil;

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

        buttonEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EdicaoDePerfilActivity.class);
                startActivity(intent);
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}