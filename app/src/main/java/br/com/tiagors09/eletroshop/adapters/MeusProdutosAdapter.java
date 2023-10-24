package br.com.tiagors09.eletroshop.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.UUID;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.activities.DetalheProdutoActivity;
import br.com.tiagors09.eletroshop.modelos.Produto;

public class MeusProdutosAdapter extends RecyclerView.Adapter<MeusProdutosAdapter.ProdutoHolder>{
    private List<Produto> produtos;

    public MeusProdutosAdapter(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public ProdutoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.produto,parent,false);

        return new ProdutoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoHolder holder, int position) {
        Produto produto = produtos.get(position);

        holder.textViewTitulo.setText(produto.getTitulo());
        holder.textViewPreco.setText(String.valueOf(produto.getPreco()));
        holder.imageViewFoto.setImageResource(produto.getFoto());
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

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
}
