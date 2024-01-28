package com.kildani.simplebanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kildani.simplebanking.entity.Client;
import com.kildani.simplebanking.service.ClientService;
import com.kildani.simplebanking.service.exceptions.InvalidDataException;
import com.kildani.simplebanking.service.security.ClientLoginService;

@Controller
public class LoginController {

    @Autowired
    ClientLoginService clientLoginService;

    @Autowired
    ClientService clientService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login_page";
    }

    @GetMapping("/create_account")
    public String showCreateAccountPage(Model model) {
        model.addAttribute("client", new Client());
        return "create_account_page";
    }

    @PostMapping("/create_account")
    public String createClientAccount(@RequestParam String username, @RequestParam String password,
            @ModelAttribute Client client, Model model) throws InvalidDataException {
        clientService.saveClient(client);
        clientLoginService.createClientLogin(username, password, client, "client");
        return "login_page";
    }
}
