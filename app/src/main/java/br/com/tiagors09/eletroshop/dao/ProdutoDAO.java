package br.com.tiagors09.eletroshop.dao;

import java.util.List;
import java.util.UUID;

import br.com.tiagors09.eletroshop.modelos.Produto;

public interface ProdutoDAO {
    boolean salvar(Produto p);
    Produto apagar(int ID);
    Produto ler(int ID);
    Produto ler(UUID uuid);
    List<Produto> lerTodos();
}
