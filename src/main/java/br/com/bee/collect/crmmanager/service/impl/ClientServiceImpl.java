package br.com.bee.collect.crmmanager.service.impl;

import br.com.bee.collect.crmmanager.model.Client;
import br.com.bee.collect.crmmanager.model.repository.ClientRepository;
import br.com.bee.collect.crmmanager.service.ClientService;
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
public class ClientServiceImpl implements ClientService {
    private static final Comparator<Client> EMPTY_COMPARATOR = (e1, e2) -> 0;
    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Client client) {
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdatedAt(LocalDateTime.now());

        repository.save(client);
    }

    @Override
    public Page<Client> all(PagingRequest pagingRequest) {
        return getPage(repository.findAll(), pagingRequest);
    }

    private Page<Client> getPage(List<Client> products, PagingRequest pagingRequest) {
        List<Client> filtered = products.stream()
                .sorted(sortEmployees(pagingRequest))
                .filter(filterEmployees(pagingRequest))
                .skip(pagingRequest.getStart())
                .limit(pagingRequest.getLength())
                .collect(Collectors.toList());

        long count = products.stream()
                .filter(filterEmployees(pagingRequest))
                .count();

        Page<Client> page = new Page<>(filtered);
        page.setRecordsFiltered((int) count);
        page.setRecordsTotal((int) count);
        page.setDraw(pagingRequest.getDraw());

        return page;
    }

    private Predicate<Client> filterEmployees(PagingRequest pagingRequest) {
        if (pagingRequest.getSearch() == null || StringUtils.isEmpty(pagingRequest.getSearch()
                .getValue())) {
            return Client -> true;
        }

        String value = pagingRequest.getSearch()
                .getValue();

        return Client -> Client.getName()
                .toLowerCase()
                .contains(value)
                || Client.getDocument()
                .toLowerCase()
                .contains(value)
                || Client.getPhone()
                .toLowerCase()
                .contains(value)
                || Client.getAddress()
                .toLowerCase()
                .contains(value);
    }

    private Comparator<Client> sortEmployees(PagingRequest pagingRequest) {
        if (pagingRequest.getOrder() == null) {
            return EMPTY_COMPARATOR;
        }

        try {
            Order order = pagingRequest.getOrder().get(0);

            int columnIndex = order.getColumn();
            Column column = pagingRequest.getColumns().get(columnIndex);

            Comparator<Client> comparator = ClientComparator.getComparator(column.getData(), order.getDir());

            return Objects.requireNonNullElse(comparator, EMPTY_COMPARATOR);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return EMPTY_COMPARATOR;
    }
}
