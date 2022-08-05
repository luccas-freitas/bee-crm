package br.com.bee.collect.crmmanager.service;

import br.com.bee.collect.crmmanager.model.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    void delete(Product product);
    List<Product> all();
    Product one(Long id);
}
