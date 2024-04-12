package se.nilden.controller.dto;

import se.nilden.domain.SlotStatus;
import se.nilden.persistence.entity.SalonServiceDetail;

import java.time.LocalDateTime;
import java.util.Set;

public record SlotDto(Long id,
                      String stylistName,
                      LocalDateTime lockedAt,
                      Set<SalonServiceDetail> salonServiceDetails,
                      SlotStatus status,
                      LocalDateTime slotFor,
                      LocalDateTime time) {
}
