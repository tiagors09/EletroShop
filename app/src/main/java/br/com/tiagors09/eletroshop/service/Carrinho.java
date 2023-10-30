package br.com.tiagors09.eletroshop.service;

import java.util.ArrayList;
import java.util.List;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.enums.ProdutoCategoria;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Produto;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class Carrinho {
    private List<Produto> carrinho;
    private static Carrinho instance;

    private Carrinho() {
        carrinho = new ArrayList<>();

        Usuario detentor = new Usuario(
                "01234567891",
                "Tiago Rodrigues Sousa",
                "28/01/2001",
                new Localizacao(3.1000, 4.000),
                "Vendedor de produtos usados de Quixadá",
                "tiagorodriguessousa9@gmail.com",
                "SenhaTeste123",
                R.drawable.icon
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

    public static Carrinho getInstance() {
        if (instance == null)
            instance = new Carrinho();

        return instance;
    }

    public List<Produto> produtos() {
        return this.carrinho;
    }
}
