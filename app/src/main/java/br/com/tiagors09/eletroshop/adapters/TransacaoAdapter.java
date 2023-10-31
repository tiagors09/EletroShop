package br.com.tiagors09.eletroshop.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.modelos.Transacao;

public class TransacaoAdapter extends RecyclerView.Adapter<TransacaoAdapter.TransacaoHolder> {
    private List<Transacao> transacoes;

    public TransacaoAdapter(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    @NonNull
    @Override
    public TransacaoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.transacao, parent, false);

        return new TransacaoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransacaoHolder holder, int position) {
        Transacao t = transacoes.get(position);

        holder.textViewTransacaoId.setText(String.valueOf(t.getId()));
        holder.textViewTransacaoValor.setText(String.valueOf(t.getValor()));
        holder.textViewTransacaoData.setText(String.valueOf(t.getData()));
    }

    @Override
    public int getItemCount() {
        return transacoes.size();
    }

    class TransacaoHolder extends RecyclerView.ViewHolder {
        public TextView textViewTransacaoId, textViewTransacaoData, textViewTransacaoValor;
        public TransacaoHolder(@NonNull View itemView) {
            super(itemView);

            textViewTransacaoId = itemView.findViewById(R.id.textViewTransacaoId);
            textViewTransacaoData = itemView.findViewById(R.id.textViewTransacaoData);
            textViewTransacaoValor = itemView.findViewById(R.id.textViewTransacaoValor);
        }
    }
}
