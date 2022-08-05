package br.com.bee.collect.crmmanager.model.types;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UnitItem {
    private Unit id;
    private String nome;
}
