package br.com.tiagors09.eletroshop.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.enums.ProdutoCategoria;

public class EdicaoDeProduto extends AppCompatActivity {
    private Spinner spinnerCategorias;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_de_produto);

        this.spinnerCategorias = findViewById(R.id.spinnerCategorias);

        ArrayAdapter<ProdutoCategoria> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ProdutoCategoria.values());

        spinnerCategorias.setAdapter(adapter);
    }
}