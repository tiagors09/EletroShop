package br.com.tiagors09.eletroshop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.adapters.MeusProdutosAdapter;
import br.com.tiagors09.eletroshop.dao.ProdutoDAO;
import br.com.tiagors09.eletroshop.dao.ProdutoDAOImpl;
import br.com.tiagors09.eletroshop.enums.ProdutoCategoria;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Produto;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class MeusProdutosFragment extends Fragment {
    private RecyclerView recyclerViewMeusProdutos;
    private MeusProdutosAdapter meusProdutosAdapter;
    private ProdutoDAO produtoDAO;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        produtoDAO = ProdutoDAOImpl.getInstance();
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meus_produtos, container, false);

        recyclerViewMeusProdutos = view.findViewById(R.id.recyclerViewMeusProdutos);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(view.getContext(), 2);
        recyclerViewMeusProdutos.setLayoutManager(layoutManager);

        meusProdutosAdapter = new MeusProdutosAdapter(produtoDAO.lerTodos());

        recyclerViewMeusProdutos.setAdapter(meusProdutosAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        meusProdutosAdapter.notifyDataSetChanged();
    }
}
