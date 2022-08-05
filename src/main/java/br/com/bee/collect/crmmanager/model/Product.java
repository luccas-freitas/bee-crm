package br.com.bee.collect.crmmanager.model;

import br.com.bee.collect.crmmanager.model.types.Unit;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Product extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome do produto é obrigatório")
    private String name;
    private String description;

    @NotNull(message = "Escolha uma unidade de medida")
    @Enumerated(EnumType.STRING)
    private Unit unity;

    @Min(value = 0, message = "A quantidade deve ser maior que zero")
    private Double quantity;
}
