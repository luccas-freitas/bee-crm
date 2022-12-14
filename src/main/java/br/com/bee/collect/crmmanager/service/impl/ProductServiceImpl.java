package br.com.bee.collect.crmmanager.service.impl;

import br.com.bee.collect.crmmanager.model.Product;
import br.com.bee.collect.crmmanager.model.repository.ProductRepository;
import br.com.bee.collect.crmmanager.service.ProductService;
import br.com.bee.collect.crmmanager.utils.paging.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private static final Comparator<Product> EMPTY_COMPARATOR = (e1, e2) -> 0;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        repository.save(product);
    }

    @Override
    public Page<Product> all(PagingRequest pagingRequest) {
        return getPage(repository.findAll(), pagingRequest);
    }

    private Page<Product> getPage(List<Product> products, PagingRequest pagingRequest) {
        List<Product> filtered = products.stream()
                .sorted(sortEmployees(pagingRequest))
                .filter(filterEmployees(pagingRequest))
                .skip(pagingRequest.getStart())
                .limit(pagingRequest.getLength())
                .collect(Collectors.toList());

        long count = products.stream()
                .filter(filterEmployees(pagingRequest))
                .count();

        Page<Product> page = new Page<>(filtered);
        page.setRecordsFiltered((int) count);
        page.setRecordsTotal((int) count);
        page.setDraw(pagingRequest.getDraw());

        return page;
    }

    private Predicate<Product> filterEmployees(PagingRequest pagingRequest) {
        if (pagingRequest.getSearch() == null || StringUtils.isEmpty(pagingRequest.getSearch()
                .getValue())) {
            return Product -> true;
        }

        String value = pagingRequest.getSearch()
                .getValue();

        return Product -> Product.getName()
                .toLowerCase()
                .contains(value)
                || Product.getDescription()
                .toLowerCase()
                .contains(value)
                || Product.getUnity().getDescricao()
                .toLowerCase()
                .contains(value);
    }

    private Comparator<Product> sortEmployees(PagingRequest pagingRequest) {
        if (pagingRequest.getOrder() == null) {
            return EMPTY_COMPARATOR;
        }

        try {
            Order order = pagingRequest.getOrder().get(0);

            int columnIndex = order.getColumn();
            Column column = pagingRequest.getColumns().get(columnIndex);

            Comparator<Product> comparator = ProductComparator.getComparator(column.getData(), order.getDir());

            return Objects.requireNonNullElse(comparator, EMPTY_COMPARATOR);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return EMPTY_COMPARATOR;
    }
}
