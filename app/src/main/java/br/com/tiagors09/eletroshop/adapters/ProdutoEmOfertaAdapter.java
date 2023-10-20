package br.com.tiagors09.eletroshop.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.modelos.Produto;

public class ProdutoEmOfertaAdapter extends RecyclerView.Adapter<ProdutoEmOfertaAdapter.ProdutoEmOfertaHolder>{
    private List<Produto> produtos;

    public ProdutoEmOfertaAdapter(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public ProdutoEmOfertaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.produto_em_oferta, parent, false);

        return new ProdutoEmOfertaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoEmOfertaHolder holder, int position) {
        Produto produto = produtos.get(position);

        holder.textViewTitulo.setText(produto.getTitulo());
        holder.textViewPreco.setText(String.valueOf(produto.getPreco()));
        holder.imageViewFoto.setImageResource(produto.getFoto());
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    class ProdutoEmOfertaHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitulo, textViewPreco;
        private ImageView imageViewFoto;

        public ProdutoEmOfertaHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
            this.textViewPreco = itemView.findViewById(R.id.textViewPreco);
            this.imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
        }
    }
}