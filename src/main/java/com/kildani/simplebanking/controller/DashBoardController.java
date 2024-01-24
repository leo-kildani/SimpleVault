package com.kildani.simplebanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kildani.simplebanking.entity.security.ClientLogin;
import com.kildani.simplebanking.security.AuthenticationFacade;
import com.kildani.simplebanking.service.AccountService;
import com.kildani.simplebanking.service.ClientService;
import com.kildani.simplebanking.service.security.ClientLoginService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/dashboard")
public class DashBoardController {

    @Autowired
    ClientService clientService;

    @Autowired
    AccountService accountService;

    @Autowired
    ClientLoginService clientLoginService;

    @Autowired
    AuthenticationFacade auth;

    private ClientLogin clientLogin;

    @GetMapping("/home")
    public String showDashBoardHome(Model model) {
        model.addAttribute("currentClient", getClientLogin().getClient());
        return "dashboard/home";
    }

    private ClientLogin getClientLogin() {
        if (clientLogin == null) {
            clientLogin = clientLoginService.findByUsername(auth.getAuthentication().getName());
        }
        return clientLogin;
    }

}
