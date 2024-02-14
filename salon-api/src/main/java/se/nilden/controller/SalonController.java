package se.nilden.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/salon")
public class SalonController {

    /**
     * Get the salon
     * @return a welcome message
     */
    @GetMapping
    public String getSalon() {
        return "Welcome to the Salon!";
    }
}
