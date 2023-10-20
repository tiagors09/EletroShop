package br.com.tiagors09.eletroshop.fragments;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.tiagors09.eletroshop.R;

public class EdicaoDeProduto extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super
                .onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater
                .inflate(
                        R.layout
                                .fragment_edicao_de_produto,
                        container,
                        false);
        return v;
    }
}