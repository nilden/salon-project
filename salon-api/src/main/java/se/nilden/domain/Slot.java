package se.nilden.domain;

import java.time.LocalDateTime;

public record Slot(
        Long id,
        String stylistName,
        java.util.Set<se.nilden.persistence.entity.SalonServiceDetail> availableServices, LocalDateTime slotFor,
        SlotStatus status,
        LocalDateTime lockedAt,
        LocalDateTime confirmedAt
) {
}
