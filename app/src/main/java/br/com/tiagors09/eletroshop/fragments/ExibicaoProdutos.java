package br.com.tiagors09.eletroshop.fragments;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.adapters.ProdutoAdapter;
import br.com.tiagors09.eletroshop.dao.ProdutoDAO;

public class ExibicaoProdutos extends Fragment {
    private RecyclerView recyclerViewProdutos;
    private ProdutoDAO produtoDAO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exibicao_produtos, container, false);

        recyclerViewProdutos = view.findViewById(R.id.recyclerViewProdutos);

        ProdutoAdapter produtoAdapter = new ProdutoAdapter(produtoDAO.lerTodos());
        recyclerViewProdutos.setAdapter(produtoAdapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(view.getContext(), 2);
        recyclerViewProdutos.setLayoutManager(layoutManager);

        return view;
    }
}