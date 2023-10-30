package br.com.tiagors09.eletroshop.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.adapters.ProdutoEmOfertaAdapter;
import br.com.tiagors09.eletroshop.enums.ProdutoCategoria;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Produto;
import br.com.tiagors09.eletroshop.modelos.Usuario;
import br.com.tiagors09.eletroshop.service.Carrinho;

public class CarrinhoFragment extends Fragment {
    private RecyclerView recyclerViewCarrinho;
    private Carrinho carrinho;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carrinho = Carrinho.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(
                        R.layout.fragment_carrinho,
                        container,
                        false);

        recyclerViewCarrinho = view.findViewById(R.id.recyclerViewCarrinho);

        recyclerViewCarrinho.setLayoutManager(
                new GridLayoutManager(view.getContext(),2)
        );

        recyclerViewCarrinho.setAdapter(
                new ProdutoEmOfertaAdapter(carrinho.produtos())
        );

        return view;
    }
}