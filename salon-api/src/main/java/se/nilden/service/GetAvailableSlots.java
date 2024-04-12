package se.nilden.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import se.nilden.domain.Slot;
import se.nilden.persistence.entity.SalonServiceDetail;
import se.nilden.persistence.entity.SlotStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Service
@Slf4j
public class GetAvailableSlots {

    private final SalonRepository salonRepository;
    private final SalonService salonService;

    public List<Slot> retrieveAvailableSlots(Long salonServiceId, String formattedDate) {
        SalonServiceDetail salonServiceDetail = salonService.findById(salonServiceId).orElseThrow(() -> new RuntimeException("Invalid Service"));
        LocalDate localDate = getAsDate(formattedDate);

        LocalDateTime startDate = localDate.atTime(0, 1);
        LocalDateTime endDate = localDate.atTime(23, 59);
        log.info("Querying for {} from {} to {}", salonServiceDetail.getName(), startDate, endDate);

        return salonRepository.findAvailableSlotsByServiceIdAndDate(startDate, endDate, salonServiceDetail, SlotStatus.AVAILABLE);
    }

    public LocalDate getAsDate(String formattedDate) {
       return LocalDate.parse(formattedDate);
    }
}