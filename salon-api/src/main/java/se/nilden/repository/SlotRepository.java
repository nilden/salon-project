package se.nilden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.nilden.domain.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long> {
}
