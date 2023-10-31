package br.com.tiagors09.eletroshop.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import br.com.tiagors09.eletroshop.enums.TipoTransacao;

public class Transacao {
    private UUID id;
    private LocalDate data;
    private TipoTransacao tipo;
    private Double valor;
    private UUID usuarioId;

    public Transacao(TipoTransacao tipo, Double valor, UUID usuarioId) {
        this.id = UUID.randomUUID();

        this.data = LocalDate.now();

        this.tipo = tipo;
        this.valor = valor;
        this.usuarioId = usuarioId;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "HistoricoDeTransacao{" +
                "id=" + id +
                ", data=" + data +
                ", tipo=" + tipo +
                ", valor=" + valor +
                '}';
    }
}
