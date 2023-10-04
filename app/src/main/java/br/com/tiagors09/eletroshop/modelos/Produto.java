package br.com.tiagors09.eletroshop.modelos;

import java.util.UUID;

public class Produto {
    private UUID ID;
    private String titulo;
    private double preco;
    private Usuario detentor;
    private String descricao;

    public Produto(String titulo, double preco, Usuario detentor, String descricao) {
        this.ID = UUID.randomUUID();
        this.titulo = titulo;
        this.preco = preco;
        this.detentor = detentor;
        this.descricao = descricao;
    }

    public UUID getID() {
        return ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Usuario getDetentor() {
        return detentor;
    }

    public void setDetentor(Usuario detentor) {
        this.detentor = detentor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
