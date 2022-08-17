package br.com.bee.collect.crmmanager.service;

import br.com.bee.collect.crmmanager.model.Client;
import br.com.bee.collect.crmmanager.utils.paging.Page;
import br.com.bee.collect.crmmanager.utils.paging.PagingRequest;

public interface ClientService {
    void save(Client client);
    Page<Client> all(PagingRequest pagingRequest);
}
