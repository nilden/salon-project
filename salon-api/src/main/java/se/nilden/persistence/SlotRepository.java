package se.nilden.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.nilden.persistence.entity.SalonServiceDetail;
import se.nilden.persistence.entity.Slot;
import se.nilden.persistence.entity.SlotStatus;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findAllBySlotForGreaterThanEqualAndSlotForLessThanEqualAndAvailableServicesContainingAndStatus(LocalDateTime startTime, LocalDateTime endTime, SalonServiceDetail serviceDetail, SlotStatus status);
}
