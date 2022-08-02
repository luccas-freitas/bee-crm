package br.com.bee.collect.crmmanager.controller;

import br.com.bee.collect.crmmanager.model.Birthplace;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    @GetMapping
    public String main(Model model) {
        model.addAttribute("birthplace", new Birthplace());
        return "index";
    }

    @PostMapping
    public String save(Birthplace birthplace, Model model) {
        model.addAttribute("birthplace", birthplace);
        return "saved";
    }
}
