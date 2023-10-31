package br.com.tiagors09.eletroshop.dao;

import java.util.List;
import java.util.UUID;

import br.com.tiagors09.eletroshop.modelos.Transacao;

public interface TransacaoDAO {
    boolean salvar(Transacao u);
    Transacao ler(UUID id);
    List<Transacao> lerTodasTransacoes();
}
