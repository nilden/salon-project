package se.nilden.persistence.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    //@JsonIgnore
    Set<SalonServiceDetail> availableServices;

    @ManyToOne
    @JoinColumn(name = "selected_service_id") // Adjust the name according to your database column
    private SalonServiceDetail salonServiceDetail;


    @ManyToOne
    private SalonServiceDetail selectedServicesEntity;
    private String stylistName;
    private LocalDateTime slotFor;
    private SlotStatus status;
    private LocalDateTime lockedAt;
    private LocalDateTime confirmedAt;

}

