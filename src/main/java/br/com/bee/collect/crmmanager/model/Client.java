package br.com.bee.collect.crmmanager.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Client extends BaseModel implements Serializable {
    private static final long serialVersionUID = -13163085111216856L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome do cliente é obrigatório")
    private String name;

    @NotEmpty(message = "O CPF do cliente é obrigatório")
    private String document;

    private String address;
    private String phone;
}
