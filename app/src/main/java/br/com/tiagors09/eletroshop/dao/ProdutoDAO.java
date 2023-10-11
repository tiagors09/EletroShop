package br.com.tiagors09.eletroshop.dao;

import java.util.List;

import br.com.tiagors09.eletroshop.modelos.Produto;

public interface ProdutoDAO {
    boolean salvar(Produto p);
    Produto apagar(int ID);
    Produto ler(int ID);
    List<Produto> lerTodos();
}
