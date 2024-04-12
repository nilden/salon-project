package se.nilden.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.nilden.persistence.entity.SalonServiceDetail;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalonService {

    private final SalonRepository salonRepository;

    public Optional<SalonServiceDetail> findById(Long salonServiceId) {

        return salonRepository.findById(salonServiceId);
    }
}
