package se.nilden.service;


import se.nilden.domain.SalonServiceDetails;
import se.nilden.domain.Slot;
import se.nilden.persistence.entity.SalonServiceDetail;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SalonRepository {

    List<SalonServiceDetails> getSalonServiceDetails();

    List<Slot> findAvailableSlotsByServiceIdAndDate(LocalDateTime startTime, LocalDateTime endTime, SalonServiceDetail serviceDetail, se.nilden.persistence.entity.SlotStatus status);

    Optional<SalonServiceDetail> findById(Long slotServiceId);
}
