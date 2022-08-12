package br.com.bee.collect.crmmanager.service;

import br.com.bee.collect.crmmanager.model.Product;
import br.com.bee.collect.crmmanager.utils.paging.Page;
import br.com.bee.collect.crmmanager.utils.paging.PageArray;
import br.com.bee.collect.crmmanager.utils.paging.PagingRequest;

public interface ProductService {
    void save(Product product);
    Page<Product> all(PagingRequest pagingRequest);
    PageArray toArray(PagingRequest pagingRequest);
}
