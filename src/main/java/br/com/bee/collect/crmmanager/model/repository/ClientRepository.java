package br.com.bee.collect.crmmanager.model.repository;

import br.com.bee.collect.crmmanager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
