package br.com.bee.collect.crmmanager.controller.rest;

import br.com.bee.collect.crmmanager.model.Product;
import br.com.bee.collect.crmmanager.service.ProductService;
import br.com.bee.collect.crmmanager.utils.paging.Page;
import br.com.bee.collect.crmmanager.utils.paging.PageArray;
import br.com.bee.collect.crmmanager.utils.paging.PagingRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    private final ProductService service;

    public ProductRestController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Page<Product> list(@RequestBody PagingRequest pagingRequest) {
        return service.all(pagingRequest);
    }

    @PostMapping("/array")
    public PageArray array(@RequestBody PagingRequest pagingRequest) {
        return service.toArray(pagingRequest);
    }
}
