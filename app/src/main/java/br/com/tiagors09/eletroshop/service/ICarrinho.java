package br.com.tiagors09.eletroshop.service;

import java.util.List;

import br.com.tiagors09.eletroshop.modelos.Produto;

public interface ICarrinho {
    boolean adicionar(Produto p);
    void remover(int pos);
    double valorTotal();
    List<Produto> getProdutos();
}
