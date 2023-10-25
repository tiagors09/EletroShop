package br.com.tiagors09.eletroshop.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.enums.ProdutoCategoria;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Produto;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class ProdutoDAOImpl implements ProdutoDAO{
    private List<Produto> produtos;
    private static ProdutoDAO instance;

    private ProdutoDAOImpl() {
        this.produtos = new ArrayList<Produto>();

        Usuario detentor = new Usuario(
                "01234567891",
                "Tiago Rodrigues Sousa",
                "28/01/2001",
                new Localizacao(3.1000, 4.000),
                "Vendedor de produtos usados de Quixadá",
                "tiagorodriguessousa9@gmail.com",
                "SenhaTeste123",
                R.drawable.icon
        );

        salvar(new Produto(
                "Geladeira frost free",
                300.00,
                detentor,
                "Geladeira novinha, sem problema, branca, 2015",
                ProdutoCategoria.COZINHA,
                R.drawable.geladeira
        ));

        salvar(new Produto(
                "Máquina de lavar",
                250.00,
                detentor,
                "Máquina de lavar em ótimo estado, 10kg, branca",
                ProdutoCategoria.PEQUENOS_ELETRODOMESTICOS,
                R.drawable.maquina_de_lavar
        ));

        salvar(new Produto(
                "Notebook",
                800.00,
                detentor,
                "Notebook novo, processador i7, 16GB de RAM, SSD de 512GB",
                ProdutoCategoria.OUTROS_ELETRODOMESTICOS_MENORES,
                R.drawable.notebook
        ));

        salvar(new Produto(
                "Geladeira frost free",
                300.00,
                detentor,
                "Geladeira novinha, sem problema, branca, 2015",
                ProdutoCategoria.COZINHA,
                R.drawable.geladeira
        ));

        salvar(new Produto(
                "Máquina de lavar",
                250.00,
                detentor,
                "Máquina de lavar em ótimo estado, 10kg, branca",
                ProdutoCategoria.PEQUENOS_ELETRODOMESTICOS,
                R.drawable.maquina_de_lavar
        ));

        salvar(new Produto(
                "Notebook",
                800.00,
                detentor,
                "Notebook novo, processador i7, 16GB de RAM, SSD de 512GB",
                ProdutoCategoria.OUTROS_ELETRODOMESTICOS_MENORES,
                R.drawable.notebook
        ));
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

    public Produto ler(UUID uuid) {
        return produtos
                .stream()
                .filter((produto) -> produto.getUuid().equals(uuid))
                .findFirst()
                .get();
    }

    @Override
    public List<Produto> lerTodos() {
        return this.produtos;
    }
}
