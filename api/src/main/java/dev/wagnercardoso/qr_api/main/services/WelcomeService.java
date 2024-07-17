package dev.wagnercardoso.qr_api.main.services;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService {
    public String execute() {
        return "Welcome to QR API";
    }
}
