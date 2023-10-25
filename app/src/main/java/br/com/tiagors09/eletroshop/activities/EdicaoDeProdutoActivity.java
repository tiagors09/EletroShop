package br.com.tiagors09.eletroshop.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.UUID;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.dao.ProdutoDAO;
import br.com.tiagors09.eletroshop.dao.ProdutoDAOImpl;
import br.com.tiagors09.eletroshop.enums.ProdutoCategoria;
import br.com.tiagors09.eletroshop.modelos.Produto;

public class EdicaoDeProdutoActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Bundle extras;
    private ImageView imageViewFotoProduto;
    private Button buttonEditarFotoProduto, buttonSalvar, buttonCancelar;
    private TextInputEditText textInputEditTextTitulo, textInputEditTextPreco, textInputEditTextDescricao;
    private Spinner spinnerCategoria;
    private ProdutoDAO produtoDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_de_produto);

        imageViewFotoProduto = findViewById(R.id.imageViewFotoProduto);
        buttonEditarFotoProduto = findViewById(R.id.buttonEditarFotoProduto);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonCancelar = findViewById(R.id.buttonCancelar);
        spinnerCategoria = findViewById(R.id.spinnerCategoria);
        textInputEditTextTitulo = findViewById(R.id.textInputEditTextTitulo);
        textInputEditTextPreco = findViewById(R.id.textInputEditTextPreco);
        textInputEditTextDescricao = findViewById(R.id.textInputEditTextDescricao);

        produtoDAO = ProdutoDAOImpl.getInstance();

        extras = getIntent().getExtras();
        UUID produtoUuid = (UUID) extras.getSerializable("UUID_PRODUTO");

        Produto produto = produtoDAO.ler(produtoUuid);

        imageViewFotoProduto.setImageResource(produto.getFoto());
        textInputEditTextTitulo.setText(produto.getTitulo());
        textInputEditTextPreco.setText(String.valueOf(produto.getPreco()));
        textInputEditTextDescricao.setText(produto.getDescricao());

        ArrayAdapter<ProdutoCategoria> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ProdutoCategoria.values());

        spinnerCategoria.setAdapter(arrayAdapter);
        spinnerCategoria.setSelection(arrayAdapter.getPosition(produto.getProdutoCategoria()));

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                produto.setFoto(imageViewFotoProduto.);
                produto.setTitulo(textInputEditTextTitulo.getText().toString());
                produto.setProdutoCategoria((ProdutoCategoria) spinnerCategoria.getSelectedItem());
                produto.setPreco(Double.parseDouble(textInputEditTextPreco.getText().toString()));
                produto.setDescricao(textInputEditTextDescricao.getText().toString());
                finish();
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonEditarFotoProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try {
                    startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(v.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageViewFotoProduto.setImageBitmap(imageBitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}