package br.com.tiagors09.eletroshop.dao;

import java.util.Collection;
import java.util.UUID;

import br.com.tiagors09.eletroshop.modelos.Produto;

public interface ProdutoDAO {
    Produto salvar(Produto p);
    Produto apagar(UUID ID);
    Produto ler(UUID ID);
    Collection<Produto> lerTodos();
}
