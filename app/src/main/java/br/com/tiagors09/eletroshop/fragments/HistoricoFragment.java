package br.com.tiagors09.eletroshop.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.adapters.TransacaoAdapter;
import br.com.tiagors09.eletroshop.dao.TransacaoDAO;
import br.com.tiagors09.eletroshop.dao.TransacaoDAOImpl;

public class HistoricoFragment extends Fragment {
    private RecyclerView recyclerViewHistorico;
    private TransacaoDAO transacaoDAO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        transacaoDAO = TransacaoDAOImpl.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_historico, container, false);

        recyclerViewHistorico = v.findViewById(R.id.recyclerViewHistorico);

        recyclerViewHistorico.setLayoutManager(
                new LinearLayoutManager(v.getContext())
        );

        recyclerViewHistorico.setAdapter(
                new TransacaoAdapter(transacaoDAO.lerTodasTransacoes())
        );

        return v;
    }
}