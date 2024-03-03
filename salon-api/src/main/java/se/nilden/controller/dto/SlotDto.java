package se.nilden.controller.dto;

public record SlotDto(Long id, String s, java.time.LocalDateTime localDateTime,
                      java.util.Set<se.nilden.persistence.entity.SalonServiceDetail> salonServiceDetails,
                      se.nilden.domain.SlotStatus status, java.time.LocalDateTime dateTime,
                      java.time.LocalDateTime time) {
}
