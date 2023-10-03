package br.com.tiagors09.eletroshop.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import br.com.tiagors09.eletroshop.modelos.Produto;

public class ProdutoDAOImpl implements ProdutoDAO{
    private HashMap<UUID,Produto> produtos;
    private static ProdutoDAO instance;

    private ProdutoDAOImpl() {
        this.produtos = new HashMap<UUID,Produto>();
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
