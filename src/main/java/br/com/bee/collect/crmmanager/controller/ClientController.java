package br.com.bee.collect.crmmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/client" })
public class ClientController {

    @GetMapping
    public String main(Model model) {
        return "client";
    }
}
