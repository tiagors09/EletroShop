package br.com.tiagors09.eletroshop.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.adapters.ProdutoEmOfertaAdapter;
import br.com.tiagors09.eletroshop.enums.ProdutoCategoria;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Produto;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class Carrinho extends Fragment {
    private RecyclerView recyclerViewCarrinho;
    private List<Produto> carrinho;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.carrinho = new ArrayList<>();
        popular();
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
                new ProdutoEmOfertaAdapter(carrinho)
        );

        return view;
    }

    private void popular() {
        Usuario detentor = new Usuario(
                "01234567891",
                "Tiago Rodrigues Sousa",
                "28/01/2001",
                new Localizacao(3.1000, 4.000),
                "Vendedor de produtos usados de Quixadá",
                "tiagorodriguessousa9@gmail.com",
                "SenhaTeste123"
        );

        carrinho.add(new Produto(
                "Geladeira frost free",
                300.00,
                detentor,
                "Geladeira novinha, sem problema, branca, 2015",
                ProdutoCategoria.COZINHA,
                R.drawable.geladeira
        ));

        carrinho.add(new Produto(
                "Máquina de lavar",
                250.00,
                detentor,
                "Máquina de lavar em ótimo estado, 10kg, branca",
                ProdutoCategoria.PEQUENOS_ELETRODOMESTICOS,
                R.drawable.maquina_de_lavar
        ));

        carrinho.add(new Produto(
                "Notebook",
                800.00,
                detentor,
                "Notebook novo, processador i7, 16GB de RAM, SSD de 512GB",
                ProdutoCategoria.OUTROS_ELETRODOMESTICOS_MENORES,
                R.drawable.notebook
        ));

        carrinho.add(new Produto(
                "Geladeira frost free",
                300.00,
                detentor,
                "Geladeira novinha, sem problema, branca, 2015",
                ProdutoCategoria.COZINHA,
                R.drawable.geladeira
        ));

        carrinho.add(new Produto(
                "Máquina de lavar",
                250.00,
                detentor,
                "Máquina de lavar em ótimo estado, 10kg, branca",
                ProdutoCategoria.PEQUENOS_ELETRODOMESTICOS,
                R.drawable.maquina_de_lavar
        ));

        carrinho.add(new Produto(
                "Notebook",
                800.00,
                detentor,
                "Notebook novo, processador i7, 16GB de RAM, SSD de 512GB",
                ProdutoCategoria.OUTROS_ELETRODOMESTICOS_MENORES,
                R.drawable.notebook
        ));
    }
}