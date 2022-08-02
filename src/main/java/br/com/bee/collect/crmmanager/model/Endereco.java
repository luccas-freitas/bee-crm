package br.com.bee.collect.crmmanager.model;

import br.com.bee.collect.crmmanager.model.dto.EnderecoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Endereco extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String complemento;

    public static Endereco from(EnderecoDTO dto) {
        Endereco endereco = new Endereco();
        endereco.logradouro = dto.getLogradouro();
        endereco.numero = dto.getNumero();
        endereco.bairro = dto.getBairro();
        endereco.cep = dto.getCep();
        endereco.cidade = dto.getCidade();
        endereco.complemento = dto.getComplemento();

        return endereco;
    }
}
