package br.com.tiagors09.eletroshop.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.modelos.Produto;

public class ProdutoEmOfertaAdapter extends RecyclerView.Adapter<ProdutoEmOfertaAdapter.ProdutoHolder>{
    private List<Produto> produtos;
    public ProdutoEmOfertaAdapter(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public ProdutoEmOfertaAdapter.ProdutoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.produto_em_oferta, parent, false);

        return new ProdutoEmOfertaAdapter.ProdutoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoHolder holder, int position) {
        Produto produto = produtos.get(position);

        holder.textViewTitulo.setText(produto.getTitulo());
        holder.textViewPreco.setText("R$ " + String.valueOf(produto.getPreco()));
        holder.imageViewFoto.setImageResource(produto.getFoto());
        holder.buttonRemoverCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar
                        .make(
                                v.getContext(),
                                v,
                                "Deseja remover produto?",
                                Snackbar.LENGTH_SHORT
                        )
                        .setAction("SIM", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                produtos.remove(holder.getAdapterPosition());
                                notifyDataSetChanged();
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    class ProdutoHolder extends RecyclerView.ViewHolder {

        public TextView textViewTitulo, textViewPreco;
        public ImageView imageViewFoto;
        public Button buttonRemoverCarrinho;

        public ProdutoHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
            this.textViewPreco = itemView.findViewById(R.id.textViewPreco);
            this.imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
            this.buttonRemoverCarrinho = itemView.findViewById(R.id.buttonRemoverCarrinho);
        }
    }
}
