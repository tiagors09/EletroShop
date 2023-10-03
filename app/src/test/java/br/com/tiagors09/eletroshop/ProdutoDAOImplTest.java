package br.com.tiagors09.eletroshop;

import org.junit.Test;

import static org.junit.Assert.*;

import android.util.Log;

import br.com.tiagors09.eletroshop.dao.ProdutoDAO;
import br.com.tiagors09.eletroshop.dao.ProdutoDAOImpl;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Produto;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class ProdutoDAOImplTest {
    private ProdutoDAO produtoDAO = ProdutoDAOImpl.getInstance();

    @Test
    public void instanciarProdutoDAO() {
        assertNotNull(produtoDAO);
    }

    @Test
    public void inserirProduto() {
        Produto p;
        Usuario detentor;

        detentor = new Usuario(
                "01234567891",
                "Tiago Rodrigues Sousa",
                "28/01/2001",
                new Localizacao(3.1000, 4.000),
                "Vendedor de produtos usados de Quixadá",
                "tiagorodriguessousa9@gmail.com",
                "SenhaTeste123"
        );

        p = new Produto(
                "Geladeira frost free",
                300.00,
                detentor,
                "Geladeira novinha, sem problema, branca, 2015"
        );


        assertNotNull(p);
        assertNotNull(produtoDAO);

        assertNotNull(produtoDAO.salvar(p));
    }
}