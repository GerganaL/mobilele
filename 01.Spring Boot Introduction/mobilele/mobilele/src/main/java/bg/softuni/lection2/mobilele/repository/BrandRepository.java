package bg.softuni.lection2.mobilele.repository;

import bg.softuni.lection2.mobilele.model.entites.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Long> {

}
