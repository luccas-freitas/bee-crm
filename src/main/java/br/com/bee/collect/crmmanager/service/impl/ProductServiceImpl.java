package br.com.bee.collect.crmmanager.service.impl;

import br.com.bee.collect.crmmanager.model.Product;
import br.com.bee.collect.crmmanager.model.repository.ProductRepository;
import br.com.bee.collect.crmmanager.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

    @Override
    public List<Product> all() {
        return repository.findAll();
    }

    @Override
    public Product one(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }
}
