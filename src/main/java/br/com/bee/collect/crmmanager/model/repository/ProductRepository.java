package br.com.bee.collect.crmmanager.model.repository;

import br.com.bee.collect.crmmanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
