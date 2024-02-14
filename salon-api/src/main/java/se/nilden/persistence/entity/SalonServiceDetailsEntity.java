package se.nilden.persistence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salon_service_detail")
@Data
@NoArgsConstructor
public class SalonServiceDetailsEntity {
       @Id
        private Long id;
        private String description;
        private String name;
        private Double price;
        private Integer timeInMinutes;
}