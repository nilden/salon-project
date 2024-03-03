package se.nilden.persistence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SalonServiceDetail {
       @Id
        private Long id;
        private String description;
        private String name;
        private Double price;
        private Integer timeInMinutes;
}