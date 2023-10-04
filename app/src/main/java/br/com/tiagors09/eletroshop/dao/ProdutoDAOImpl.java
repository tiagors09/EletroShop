package br.com.tiagors09.eletroshop.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Produto;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class ProdutoDAOImpl implements ProdutoDAO{
    private Map<UUID,Produto> produtos;
    private static ProdutoDAO instance;

    private ProdutoDAOImpl() {
        this.produtos = new HashMap<>();

        Usuario detentor = new Usuario(
                "01234567891",
                "Tiago Rodrigues Sousa",
                "28/01/2001",
                new Localizacao(3.1000, 4.000),
                "Vendedor de produtos usados de Quixadá",
                "tiagorodriguessousa9@gmail.com",
                "SenhaTeste123"
        );

        Produto produto = new Produto(
                "Geladeira frost free",
                300.00,
                detentor,
                "Geladeira novinha, sem problema, branca, 2015"
        );

        this.salvar(produto);
    }

    public static ProdutoDAO getInstance() {
        if (instance == null) {
            instance = new ProdutoDAOImpl();
        }

        return instance;
    }

    @Override
    public Produto salvar(Produto p) {
        return produtos.put(p.getID(),p);
    }

    @Override
    public Produto apagar(UUID ID) {
        if (produtos.containsKey(ID)) {
            return produtos.remove(ID);
        }

        return null;
    }

    @Override
    public Produto ler(UUID ID) {
        return produtos.get(ID);
    }

    @Override
    public Collection<Produto> lerTodos() {
        return this.produtos.values();
    }
}
