package dev.wagnercardoso.qr_api.main.controllers;

import dev.wagnercardoso.qr_api.main.services.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {
    @Autowired
    WelcomeService welcomeService;

    @GetMapping("/")
    public String welcome() {
        return welcomeService.execute();
    }
}
