package se.nilden.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se.nilden.domain.SalonDetails;

public interface SalonServiceDetailRepository extends JpaRepository<SalonDetails, Long> {
}
