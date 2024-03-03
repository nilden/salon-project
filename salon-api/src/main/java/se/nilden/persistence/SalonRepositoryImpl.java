package se.nilden.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import se.nilden.domain.SlotStatus;
import se.nilden.persistence.entity.SalonServiceDetail;
import se.nilden.persistence.entity.Slot;
import se.nilden.service.SalonRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SalonRepositoryImpl implements SalonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final SlotRepository slotRepository;

    @Override
    public List<se.nilden.domain.SalonServiceDetails> getSalonServiceDetails() {
        List<SalonServiceDetail> entities = entityManager.createQuery("SELECT s FROM SalonServiceDetail s", SalonServiceDetail.class).getResultList();
        return entities.stream()
                .map(this::toDomain)
                .toList();
    }

    private se.nilden.domain.SalonServiceDetails toDomain(SalonServiceDetail entity) {
        return new se.nilden.domain.SalonServiceDetails(
                entity.getId(),
                entity.getDescription(),
                entity.getName(),
                entity.getPrice(),
                entity.getTimeInMinutes()
        );
    }
    @Override
    public Optional<SalonServiceDetail> findById(Long slotServiceId) {
        SalonServiceDetail entity = entityManager.find(SalonServiceDetail.class, slotServiceId);
        return Optional.ofNullable(entity);
    }

    @Override
    public List<se.nilden.domain.Slot> findAvailableSlotsByServiceIdAndDate(LocalDateTime startTime, LocalDateTime endTime, SalonServiceDetail serviceDetail, se.nilden.persistence.entity.SlotStatus status) {
        List<Slot> results = slotRepository.
                findAllBySlotForGreaterThanEqualAndSlotForLessThanEqualAndAvailableServicesContainingAndStatus(startTime, endTime, serviceDetail, status);

        return results.stream()
                .map(this::toDomainSlot)
                .toList();
    }


    private se.nilden.domain.Slot toDomainSlot(Slot entity) {
        SlotStatus status = entity.getStatus() != null ? SlotStatus.valueOf(entity.getStatus().name()) : null;
        return new se.nilden.domain.Slot(
                entity.getId(),
                entity.getStylistName(),
                entity.getAvailableServices(),
                entity.getSlotFor(),
                status,
                entity.getLockedAt(),
                entity.getConfirmedAt()
        );
    }
}
