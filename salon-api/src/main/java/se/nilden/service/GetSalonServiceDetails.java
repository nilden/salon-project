package se.nilden.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.nilden.domain.SalonServiceDetails;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetSalonServiceDetails {

    private final SalonRepository salonRepository;

    public List<SalonServiceDetails> getSalonServiceDetails() {
        return salonRepository.getSalonServiceDetails();
    }
}
