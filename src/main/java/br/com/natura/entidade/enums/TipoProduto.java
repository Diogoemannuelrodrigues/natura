package br.com.natura.entidade.enums;

public enum TipoProduto {

    PERFUMARIA(1, "Perfumaria"),
    BATON(2, "Baton"),
    INFANTIL(3, "Infantil"),
    ROSTO(4, "Rosto"),
    MAQUIAGEM(5, "Maquiagem");

    private int cod;
    private String descricao;

    private TipoProduto(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoProduto toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (TipoProduto x : TipoProduto.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}
