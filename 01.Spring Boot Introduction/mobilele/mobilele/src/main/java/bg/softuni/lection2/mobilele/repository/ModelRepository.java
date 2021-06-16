package bg.softuni.lection2.mobilele.repository;

import bg.softuni.lection2.mobilele.model.entites.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity,Long> {
}
