package br.com.tiagors09.eletroshop.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.UUID;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.activities.EdicaoDeProdutoActivity;
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
                .inflate(R.layout.meu_produto,parent,false);

        return new ProdutoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoHolder holder, int position) {
        Produto produto = produtos.get(position);

        holder.setUuid(produto.getUuid());
        holder.textViewTitulo.setText(produto.getTitulo());
        holder.textViewPreco.setText(String.format("R$ %.2f", produto.getPreco()));
        holder.imageViewFoto.setImageResource(produto.getFoto());
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    class ProdutoHolder extends RecyclerView.ViewHolder {
        private UUID uuid;
        public TextView textViewTitulo, textViewPreco;
        public ImageView imageViewFoto;
        private ImageButton imageButtonEditar, imageButtonDeletar;

        public ProdutoHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
            this.textViewPreco = itemView.findViewById(R.id.textViewPreco);
            this.imageViewFoto = itemView.findViewById(R.id.imageViewFoto);

            imageButtonEditar = itemView.findViewById(R.id.imageButtonEditar);

            imageButtonEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), EdicaoDeProdutoActivity.class);
                    intent.putExtra("UUID_PRODUTO", uuid);

                    itemView.getContext().startActivity(intent);
                }
            });
        }

        public void setUuid(UUID uuid) {
            this.uuid = uuid;
        }
    }
}
