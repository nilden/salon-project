package se.nilden.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import se.nilden.domain.SalonServiceDetails;
import se.nilden.persistence.entity.SalonServiceDetailsEntity;
import se.nilden.service.SalonRepository;

import java.util.List;

@Repository
@NoArgsConstructor
public class SalonRepositoryImpl implements SalonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<se.nilden.domain.SalonServiceDetails> getSalonServiceDetails() {
        List<SalonServiceDetailsEntity> entities = entityManager.createQuery("SELECT s FROM SalonServiceDetailsEntity s", SalonServiceDetailsEntity.class).getResultList();
        return entities.stream()
                .map(this::toDomain)
                .toList();
    }

    private SalonServiceDetails toDomain(SalonServiceDetailsEntity entity) {
        return SalonServiceDetails.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .name(entity.getName())
                .price(entity.getPrice())
                .timeInMinutes(entity.getTimeInMinutes())
                .build();
    }
}
