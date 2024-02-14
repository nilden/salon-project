package se.nilden.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Slot {
    @Id
    private Long id;
}
