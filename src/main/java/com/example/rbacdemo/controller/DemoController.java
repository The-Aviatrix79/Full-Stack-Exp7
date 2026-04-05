package com.example.rbacdemo.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/public/hello")
    public String publicEndpoint() {
        return "Public endpoint: no authentication required";
    }

    @GetMapping("/user/profile")
    public String userEndpoint(Principal principal) {
        return "Hello " + principal.getName() + ", you can access USER resources";
    }

    @GetMapping("/admin/dashboard")
    public String adminEndpoint(Principal principal) {
        return "Hello " + principal.getName() + ", welcome to ADMIN dashboard";
    }
}
