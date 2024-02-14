package se.nilden.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.nilden.domain.SalonDetails;

@Getter
@RequiredArgsConstructor
@Service
public class GetSalonDetails {
    private final SalonDetails salonDetails;
}
