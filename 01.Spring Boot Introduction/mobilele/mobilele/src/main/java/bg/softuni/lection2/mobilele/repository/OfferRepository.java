package bg.softuni.lection2.mobilele.repository;

import bg.softuni.lection2.mobilele.model.entites.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity,Long> {
}
