package br.com.tiagors09.eletroshop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.dao.ProdutoDAO;
import br.com.tiagors09.eletroshop.dao.ProdutoDAOImpl;
import br.com.tiagors09.eletroshop.modelos.Produto;
import br.com.tiagors09.eletroshop.service.Carrinho;
import br.com.tiagors09.eletroshop.service.ICarrinho;

public class DetalheProdutoActivity extends AppCompatActivity {
    private Bundle extras;
    private TextView textViewTitulo, textViewPreco, textViewDescricao;
    private ImageView imageViewFoto;
    private Button buttonVoltar, buttonAdicionarAoCarrinho;
    private ProdutoDAO produtoDAO;
    private ICarrinho iCarrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_produto);

        textViewTitulo = findViewById(R.id.textViewTitulo);
        textViewPreco = findViewById(R.id.textViewPreco);
        textViewDescricao = findViewById(R.id.textViewDescricao);
        imageViewFoto = findViewById(R.id.imageViewFoto);
        buttonVoltar = findViewById(R.id.buttonVoltar);
        buttonAdicionarAoCarrinho = findViewById(R.id.buttonAdicionarAoCarrinho);

        extras = getIntent().getExtras();
        UUID idProduto = (UUID) extras.getSerializable("ID_PRODUTO");

        produtoDAO = ProdutoDAOImpl.getInstance();
        Produto produto = produtoDAO.ler(idProduto);

        textViewTitulo.setText(produto.getTitulo());
        textViewPreco.setText(String.format("R$ %.2f", produto.getPreco()));
        textViewDescricao.setText(produto.getDescricao());
        imageViewFoto.setImageResource(produto.getFoto());

        iCarrinho = Carrinho.getInstance();

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonAdicionarAoCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iCarrinho.adicionar(produto);
                finish();
            }
        });
    }
}