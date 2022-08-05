package br.com.bee.collect.crmmanager.model.types;

import lombok.Getter;

public enum Unit {
    KILO("kg (Quilogramas)"),
    GRAMA("g (Gramas)"),
    UNIDADE("und. (Unidades)"),
    SACA("saca (Sacas)");

    @Getter
    private final String descricao;
    Unit(String descricao) {
        this.descricao = descricao;
    }
}
