package br.com.tiagors09.eletroshop.modelos;

import java.util.UUID;

import br.com.tiagors09.eletroshop.enums.ProdutoCategoria;
import br.com.tiagors09.eletroshop.enums.StatusProduto;

public class Produto {
    private UUID ID;
    private String titulo;
    private double preco;
    private Usuario detentor;
    private String descricao;
    private StatusProduto statusProduto;
    private ProdutoCategoria produtoCategoria;
    public Produto(String titulo, double preco, Usuario detentor, String descricao, ProdutoCategoria produtoCategoria) {
        this.ID = UUID.randomUUID();
        this.titulo = titulo;
        this.preco = preco;
        this.detentor = detentor;
        this.descricao = descricao;
        this.statusProduto = StatusProduto.A_VENDA;
        this.produtoCategoria = produtoCategoria;
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

    public StatusProduto getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(StatusProduto statusProduto) {
        this.statusProduto = statusProduto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "ID=" + ID +
                ", titulo='" + titulo + '\'' +
                ", preco=" + preco +
                ", detentor=" + detentor +
                ", descricao='" + descricao + '\'' +
                ", statusProduto=" + statusProduto.getStatus() + '\n' +
                ", produtoCategoria=" + produtoCategoria.getCategoria() +
                '}';
    }
}
