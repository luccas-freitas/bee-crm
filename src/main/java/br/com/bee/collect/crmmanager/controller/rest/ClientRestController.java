package br.com.bee.collect.crmmanager.controller.rest;

import br.com.bee.collect.crmmanager.model.Client;
import br.com.bee.collect.crmmanager.service.ClientService;
import br.com.bee.collect.crmmanager.utils.paging.Page;
import br.com.bee.collect.crmmanager.utils.paging.PagingRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {
    private final ClientService service;

    public ClientRestController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public Page<Client> list(@RequestBody PagingRequest pagingRequest) {
        return service.all(pagingRequest);
    }
}
