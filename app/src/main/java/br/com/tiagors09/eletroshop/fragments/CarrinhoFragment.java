package br.com.tiagors09.eletroshop.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.UUID;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.adapters.ProdutoEmOfertaAdapter;
import br.com.tiagors09.eletroshop.dao.TransacaoDAO;
import br.com.tiagors09.eletroshop.dao.TransacaoDAOImpl;
import br.com.tiagors09.eletroshop.enums.TipoTransacao;
import br.com.tiagors09.eletroshop.modelos.Transacao;
import br.com.tiagors09.eletroshop.service.Carrinho;

public class CarrinhoFragment extends Fragment {
    private RecyclerView recyclerViewCarrinho;
    private Carrinho carrinho;
    private Button buttonFecharPedido;
    private TextView textViewValorTotal;
    private TransacaoDAO transacaoDAO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carrinho = Carrinho.getInstance();
        transacaoDAO = TransacaoDAOImpl.getInstance();
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
        buttonFecharPedido = view.findViewById(R.id.buttonFecharPedido);
        textViewValorTotal = view.findViewById(R.id.textViewValorTotal);

        textViewValorTotal.setText(String.format("R$ %.2f", carrinho.valorTotal()));

        recyclerViewCarrinho.setLayoutManager(
                new GridLayoutManager(view.getContext(),2)
        );

        ProdutoEmOfertaAdapter produtoEmOfertaAdapter = new ProdutoEmOfertaAdapter(carrinho.getProdutos());
        produtoEmOfertaAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                textViewValorTotal.setText(String.format("R$ %.2f", carrinho.valorTotal()));
            }
        });

        recyclerViewCarrinho.setAdapter(
            produtoEmOfertaAdapter
        );

        buttonFecharPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transacaoDAO.salvar(new Transacao(
                        TipoTransacao.COMPRA,
                        carrinho.valorTotal(),
                        UUID.randomUUID()
                        )
                );

                carrinho.getProdutos().clear();
                produtoEmOfertaAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}