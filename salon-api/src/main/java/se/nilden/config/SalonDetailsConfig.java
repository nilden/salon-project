package se.nilden.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.nilden.domain.SalonDetails;

@Configuration
public class SalonDetailsConfig {

    @Value("${salon.name}")
    private String name;

    @Value("${salon.address}")
    private String address;

    @Value("${salon.zipcode}")
    private String zipcode;

    @Value("${salon.state}")
    private String state;

    @Value("${salon.city}")
    private String city;

    @Value("${salon.phone}")
    private String phone;

    @Bean
    public SalonDetails salonDetails() {
        return new SalonDetails(name, address, zipcode, state, city, phone);
    }
}