package br.com.bee.collect.crmmanager.repository;

import br.com.bee.collect.crmmanager.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByIsDeletedIsFalse();
}
