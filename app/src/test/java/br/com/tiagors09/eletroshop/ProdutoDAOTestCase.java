package br.com.tiagors09.eletroshop;

import org.junit.Test;

import static org.junit.Assert.*;

import br.com.tiagors09.eletroshop.dao.ProdutoDAO;
import br.com.tiagors09.eletroshop.dao.ProdutoDAOImpl;
import br.com.tiagors09.eletroshop.enums.ProdutoCategoria;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Produto;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class ProdutoDAOTestCase {
    @Test
    public void inserirProduto() {
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
                "Geladeira novinha, sem problema, branca, 2015",
                ProdutoCategoria.COZINHA
        );

        assertNotNull(detentor);
        assertNotNull(produto);

        ProdutoDAO produtoDAO = ProdutoDAOImpl.getInstance();
        produtoDAO.salvar(produto);
        assertNotNull(produtoDAO.ler(produto.getID()));
        assertNotNull(produtoDAO.apagar(produto.getID()));
    }
}
