package se.nilden.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.nilden.domain.SalonDetails;
import se.nilden.domain.SalonServiceDetails;
import se.nilden.service.GetSalonDetails;
import se.nilden.service.GetSalonServiceDetails;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class SalonController {

    private final GetSalonServiceDetails getSalonServiceDetails;
    private final GetSalonDetails getSalonDetails;


    @GetMapping("/retrieveSalonDetails")
    public SalonDetails getSalonDetails() {
        return getSalonDetails.getSalonDetails();
    }

    @GetMapping("/retrieveAvailableSalonServices")
    public List<SalonServiceDetails> getSalon() {
        return getSalonServiceDetails.getSalonServiceDetails();
    }
}
