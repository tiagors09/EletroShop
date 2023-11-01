package br.com.tiagors09.eletroshop.service;

import java.util.ArrayList;
import java.util.List;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.enums.ProdutoCategoria;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Produto;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class Carrinho implements ICarrinho{
    private List<Produto> produtos;
    private static Carrinho instance;

    private Carrinho() {
        produtos = new ArrayList<>();

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

        produtos.add(new Produto(
                "Geladeira frost free",
                300.00,
                detentor,
                "Geladeira novinha, sem problema, branca, 2015",
                ProdutoCategoria.COZINHA,
                R.drawable.geladeira
        ));

        produtos.add(new Produto(
                "Máquina de lavar",
                250.00,
                detentor,
                "Máquina de lavar em ótimo estado, 10kg, branca",
                ProdutoCategoria.PEQUENOS_ELETRODOMESTICOS,
                R.drawable.maquina_de_lavar
        ));

        produtos.add(new Produto(
                "Notebook",
                800.00,
                detentor,
                "Notebook novo, processador i7, 16GB de RAM, SSD de 512GB",
                ProdutoCategoria.OUTROS_ELETRODOMESTICOS_MENORES,
                R.drawable.notebook
        ));

        produtos.add(new Produto(
                "Geladeira frost free",
                300.00,
                detentor,
                "Geladeira novinha, sem problema, branca, 2015",
                ProdutoCategoria.COZINHA,
                R.drawable.geladeira
        ));

        produtos.add(new Produto(
                "Máquina de lavar",
                250.00,
                detentor,
                "Máquina de lavar em ótimo estado, 10kg, branca",
                ProdutoCategoria.PEQUENOS_ELETRODOMESTICOS,
                R.drawable.maquina_de_lavar
        ));

        produtos.add(new Produto(
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

    @Override
    public boolean adicionar(Produto p) {
        return produtos.add(p);
    }

    @Override
    public void remover(int pos) {
        produtos.remove(pos);
    }

    @Override
    public List<Produto> getProdutos() {
        return this.produtos;
    }

    @Override
    public double valorTotal() {
        double total = 0.0;

        for (Produto p : produtos) {
            total += p.getPreco();
        }

        return total;
    }
}
