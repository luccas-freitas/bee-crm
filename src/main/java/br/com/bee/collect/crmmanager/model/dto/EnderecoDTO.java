package br.com.bee.collect.crmmanager.model.dto;

import lombok.Data;

@Data
public class EnderecoDTO {
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String complemento;
}
