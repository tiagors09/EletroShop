package br.com.tiagors09.eletroshop.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.tiagors09.eletroshop.R;

public class HistoricoFragment extends Fragment {
    private RecyclerView recyclerViewHistorico;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_historico, container, false);

        recyclerViewHistorico = v.findViewById(R.id.recyclerViewHistorico);

        return v;
    }
}