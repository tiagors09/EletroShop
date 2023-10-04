package br.com.tiagors09.eletroshop.enums;

public enum StatusProduto {
    A_VENDA("A VENDA"),EM_OFERTA("EM OFERTA"),VENDIDO("VENDIDO");
    private String status;

    StatusProduto(String s) {
        this.status = s;
    }

    public String getStatus() {
        return status;
    }
}
