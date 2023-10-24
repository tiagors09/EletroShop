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
import br.com.tiagors09.eletroshop.enums.ProdutoCategoria;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Produto;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class MeusProdutosFragment extends Fragment {
    private RecyclerView recyclerViewMeusProdutos;
    private List<Produto> meusProdutos;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.meusProdutos = new ArrayList<>();
        popular();
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meus_produtos, container, false);

        recyclerViewMeusProdutos = view.findViewById(R.id.recyclerViewMeusProdutos);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(view.getContext(), 2);
        recyclerViewMeusProdutos.setLayoutManager(layoutManager);

        recyclerViewMeusProdutos.setAdapter(new MeusProdutosAdapter(this.meusProdutos));

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

        meusProdutos.add(new Produto(
                "Geladeira frost free",
                300.00,
                detentor,
                "Geladeira novinha, sem problema, branca, 2015",
                ProdutoCategoria.COZINHA,
                R.drawable.geladeira
        ));

        meusProdutos.add(new Produto(
                "Máquina de lavar",
                250.00,
                detentor,
                "Máquina de lavar em ótimo estado, 10kg, branca",
                ProdutoCategoria.PEQUENOS_ELETRODOMESTICOS,
                R.drawable.maquina_de_lavar
        ));

        meusProdutos.add(new Produto(
                "Notebook",
                800.00,
                detentor,
                "Notebook novo, processador i7, 16GB de RAM, SSD de 512GB",
                ProdutoCategoria.OUTROS_ELETRODOMESTICOS_MENORES,
                R.drawable.notebook
        ));

        meusProdutos.add(new Produto(
                "Geladeira frost free",
                300.00,
                detentor,
                "Geladeira novinha, sem problema, branca, 2015",
                ProdutoCategoria.COZINHA,
                R.drawable.geladeira
        ));

        meusProdutos.add(new Produto(
                "Máquina de lavar",
                250.00,
                detentor,
                "Máquina de lavar em ótimo estado, 10kg, branca",
                ProdutoCategoria.PEQUENOS_ELETRODOMESTICOS,
                R.drawable.maquina_de_lavar
        ));

        meusProdutos.add(new Produto(
                "Notebook",
                800.00,
                detentor,
                "Notebook novo, processador i7, 16GB de RAM, SSD de 512GB",
                ProdutoCategoria.OUTROS_ELETRODOMESTICOS_MENORES,
                R.drawable.notebook
        ));
    }
}
