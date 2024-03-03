package se.nilden.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.nilden.controller.dto.SalonDetailsDto;
import se.nilden.controller.dto.SalonServiceDetailsDto;
import se.nilden.controller.dto.SlotDto;
import se.nilden.domain.SalonDetails;
import se.nilden.domain.SalonServiceDetails;
import se.nilden.service.GetAvailableSlots;
import se.nilden.service.GetSalonDetails;
import se.nilden.service.GetSalonServiceDetails;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class SalonController {

    private final GetSalonServiceDetails getSalonServiceDetails;
    private final GetSalonDetails getSalonDetails;
    private final GetAvailableSlots getAvailabilitySlots;


    @GetMapping("/retrieveSalonDetails")
    public SalonDetailsDto getSalonDetails() {
        SalonDetails salonDetails = getSalonDetails.getSalonDetails();
        return new SalonDetailsDto(salonDetails.name(), salonDetails.address(), salonDetails.zipcode(), salonDetails.state(), salonDetails.city(), salonDetails.phone());
    }

    @GetMapping("/retrieveAvailableSalonServices")
    public List<SalonServiceDetailsDto> getAvailableSalonServices() {
        List<SalonServiceDetails> salonServiceDetails = getSalonServiceDetails.getSalonServiceDetails();
        return salonServiceDetails.stream()
                .map(salonServiceDetail -> new SalonServiceDetailsDto(salonServiceDetail.id(), salonServiceDetail.description(), salonServiceDetail.name(), salonServiceDetail.price(), salonServiceDetail.timeInMinutes()))
                .toList();
    }

    @GetMapping("/retrieveAvailableSlots/{slotServiceId}/{formattedDate}")
    public List<SlotDto> retrieveAvailableSlots(@PathVariable("slotServiceId") Long slotServiceId,
                                             @PathVariable("formattedDate") String formattedDate) {
        return getAvailabilitySlots.retrieveAvailableSlots(slotServiceId, formattedDate).stream()
                .map(slot -> new SlotDto(slot.id(), slot.stylistName(), slot.slotFor(), slot.availableServices(), slot.status(), slot.lockedAt(), slot.confirmedAt()))
                .toList();
    }
}
