package com.softuni.repository;

import com.softuni.models.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercisesRepository extends JpaRepository<ExerciseEntity,Long> {
}
