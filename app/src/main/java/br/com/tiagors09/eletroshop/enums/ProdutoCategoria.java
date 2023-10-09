package br.com.tiagors09.eletroshop.enums;

public enum ProdutoCategoria {
    COZINHA("Cozinha"),
    LIMPEZA_E_CUIDADOS_COM_O_LAR("Limpeza e cuidados com o lar"),
    CUIDADOS_PESSOAIS("Cuidados pessoais"),
    ENTRETENIMENTO_E_COMUNICACAO("Entretenimento e comunicação"),
    PEQUENOS_ELETRODOMESTICOS("Pequenos eletrodomésticos"),
    AQUECIMENTO_E_RESFRIAMENTO("Aquecimento e resfriamento"),
    CUIDADOS_COM_O_BEBE("Cuidados com o bebê"),
    CASA_INTELIGENTE("Casa inteligente"),
    OUTROS_ELETRODOMESTICOS_MENORES("Outros eletrodomésticos menores");

    private String categoria;

    ProdutoCategoria(String cozinha) {
    }

    public String getCategoria() {
        return this.categoria;
    }
}
