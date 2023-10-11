package br.com.tiagors09.eletroshop.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.tiagors09.eletroshop.modelos.Produto;

public class ProdutoDAOImpl implements ProdutoDAO{
    private List<Produto> produtos;
    private static ProdutoDAO instance;

    private ProdutoDAOImpl() {
        this.produtos = new ArrayList<Produto>();
    }

    public static ProdutoDAO getInstance() {
        if (instance == null) {
            instance = new ProdutoDAOImpl();
        }

        return instance;
    }

    @Override
    public boolean salvar(Produto p) {
        return produtos.add(p);
    }

    @Override
    public Produto apagar(int ID) {
        return produtos.remove(ID);
    }

    @Override
    public Produto ler(int ID) {
        return produtos.get(ID);
    }

    @Override
    public List<Produto> lerTodos() {
        return this.produtos;
    }
}
