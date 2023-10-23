package br.com.tiagors09.eletroshop.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.com.tiagors09.eletroshop.R;

class ProdutoHolder extends RecyclerView.ViewHolder {
    public TextView textViewTitulo, textViewPreco;
    public ImageView imageViewFoto;

    public ProdutoHolder(@NonNull View itemView) {
        super(itemView);

        this.textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
        this.textViewPreco = itemView.findViewById(R.id.textViewPreco);
        this.imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
    }
}