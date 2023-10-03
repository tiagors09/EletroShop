package br.com.tiagors09.eletroshop;

import org.junit.Test;

import static org.junit.Assert.*;

import br.com.tiagors09.eletroshop.dao.ProdutoDAO;
import br.com.tiagors09.eletroshop.dao.ProdutoDAOImpl;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Produto;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class ProdutoDAOTestCase {
    @Test
    public void inserirProduto() {
        Usuario usuario = new Usuario(
                "01234567891",
                "Tiago Rodrigues Sousa",
                "28/01/2001",
                new Localizacao(3.12, 4.12),
                "Teste teste teste",
                "tiagors09@gmail.com",
                "Teste1234!");

        Produto produto = new Produto(
                "Geladeira branca",
                340.00,
                usuario,
                "geladeira boa"
        );

        assertNotNull(usuario);
        assertNotNull(produto);

        ProdutoDAO produtoDAO = ProdutoDAOImpl.getInstance();
        assertNotNull(produtoDAO.salvar(produto));
    }
}
