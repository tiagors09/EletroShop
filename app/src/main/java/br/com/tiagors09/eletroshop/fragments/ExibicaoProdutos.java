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
import br.com.tiagors09.eletroshop.dao.ProdutoDAOImpl;
import br.com.tiagors09.eletroshop.enums.ProdutoCategoria;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Produto;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class ExibicaoProdutos extends Fragment {
    private RecyclerView recyclerViewProdutos;
    private ProdutoDAO produtoDAO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        produtoDAO = ProdutoDAOImpl.getInstance();

        popular();
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

        produtoDAO.salvar(new Produto(
                "Geladeira frost free",
                300.00,
                detentor,
                "Geladeira novinha, sem problema, branca, 2015",
                ProdutoCategoria.COZINHA,
                R.drawable.geladeira
        ));

        produtoDAO.salvar(new Produto(
                "Máquina de lavar",
                250.00,
                detentor,
                "Máquina de lavar em ótimo estado, 10kg, branca",
                ProdutoCategoria.PEQUENOS_ELETRODOMESTICOS,
                R.drawable.maquina_de_lavar
        ));

        produtoDAO.salvar(new Produto(
                "Notebook",
                800.00,
                detentor,
                "Notebook novo, processador i7, 16GB de RAM, SSD de 512GB",
                ProdutoCategoria.OUTROS_ELETRODOMESTICOS_MENORES,
                R.drawable.notebook
        ));

        produtoDAO.salvar(new Produto(
                "Geladeira frost free",
                300.00,
                detentor,
                "Geladeira novinha, sem problema, branca, 2015",
                ProdutoCategoria.COZINHA,
                R.drawable.geladeira
        ));

        produtoDAO.salvar(new Produto(
                "Máquina de lavar",
                250.00,
                detentor,
                "Máquina de lavar em ótimo estado, 10kg, branca",
                ProdutoCategoria.PEQUENOS_ELETRODOMESTICOS,
                R.drawable.maquina_de_lavar
        ));

        produtoDAO.salvar(new Produto(
                "Notebook",
                800.00,
                detentor,
                "Notebook novo, processador i7, 16GB de RAM, SSD de 512GB",
                ProdutoCategoria.OUTROS_ELETRODOMESTICOS_MENORES,
                R.drawable.notebook
        ));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exibicao_produtos, container, false);

        recyclerViewProdutos = view.findViewById(R.id.recyclerViewProdutos);

        ProdutoAdapter produtoAdapter = new ProdutoAdapter(produtoDAO.lerTodos());
        recyclerViewProdutos.setAdapter(produtoAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerViewProdutos.setLayoutManager(layoutManager);

        return view;
    }
}