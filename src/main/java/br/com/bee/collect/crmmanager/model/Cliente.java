package br.com.bee.collect.crmmanager.model;

import br.com.bee.collect.crmmanager.model.dto.ClienteDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Cliente extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    @ManyToOne
    private Endereco endereco;
    private Boolean isDeleted;

    public static Cliente from(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.nome = dto.getNome();
        cliente.cpf = dto.getCpf();
        cliente.endereco = Endereco.from(dto.getEndereco());
        cliente.isDeleted = false;

        return cliente;
    }
}
