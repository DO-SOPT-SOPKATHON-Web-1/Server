package org.sopt.sopkathon.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HealthCheckApiController {
    @GetMapping
    public String healthCheck() {
        return "Sopkathon Web 1조 Server OK";
    }
}
