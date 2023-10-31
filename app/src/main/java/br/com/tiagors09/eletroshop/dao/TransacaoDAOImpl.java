package br.com.tiagors09.eletroshop.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.tiagors09.eletroshop.modelos.Transacao;

public class TransacaoDAOImpl implements TransacaoDAO{
    private List<Transacao> transacoes;
    private static TransacaoDAOImpl instance;

    private TransacaoDAOImpl() {
        transacoes = new ArrayList<>();
    }

    public static TransacaoDAO getInstance() {
        if (instance == null)
            instance = new TransacaoDAOImpl();
        return instance;
    }

    @Override
    public boolean salvar(Transacao u) {
        return transacoes.add(u);
    }

    @Override
    public Transacao ler(UUID id) {
        return transacoes
                .stream()
                .filter((transacao -> transacao.getId().equals(id)))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Transacao> lerTodasTransacoes() {
        return transacoes;
    }
}
