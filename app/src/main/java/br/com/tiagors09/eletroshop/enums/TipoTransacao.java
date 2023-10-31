package br.com.tiagors09.eletroshop.enums;

import androidx.annotation.NonNull;

public enum TipoTransacao {
    COMPRA("Compra"),
    VENDA("Venda");

    private String transacao;

    TipoTransacao(String transacao) {
        this.transacao = transacao;
    }

    public String getTransacao() {
        return transacao;
    }

    @NonNull
    @Override
    public String toString() {
        return this.transacao;
    }
}
