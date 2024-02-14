package se.nilden.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;


@Entity
@Data
public class SalonDetails {
    @Id
    private Long id;
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

}
