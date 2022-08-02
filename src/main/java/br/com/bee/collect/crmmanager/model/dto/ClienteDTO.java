package br.com.bee.collect.crmmanager.model.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private String nome;
    private String cpf;
    private EnderecoDTO endereco;
}
