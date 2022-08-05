package br.com.bee.collect.crmmanager.controller;

import br.com.bee.collect.crmmanager.model.Product;
import br.com.bee.collect.crmmanager.model.types.Unit;
import br.com.bee.collect.crmmanager.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping({ "/product" })
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("units", Unit.values());
        return "product/new";
    }

    @PostMapping
    public String save(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "product/new";
        }

        model.addAttribute("product", product);
        service.save(product);
        return "product/saved";
    }
}
