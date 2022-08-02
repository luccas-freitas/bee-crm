package br.com.bee.collect.crmmanager.service;

import br.com.bee.collect.crmmanager.model.dto.ClienteDTO;
import br.com.bee.collect.crmmanager.model.Cliente;
import br.com.bee.collect.crmmanager.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente create(ClienteDTO dto) {
        return repository.save(Cliente.from(dto));
    }

    public Cliente update(Long id, ClienteDTO dto) throws Exception {
        return repository.findById(id)
                .map(cliente -> create(dto))
                .orElseThrow(() -> new Exception("Cliente não encontrado"));
    }

    public void delete(Long id) {
        repository.findById(id)
                .ifPresent(cliente -> {
                    cliente.setIsDeleted(true);
                    repository.save(cliente);
                });
    }

    public List<Cliente> all() {
        return repository.findByIsDeletedIsFalse();
    }
}
