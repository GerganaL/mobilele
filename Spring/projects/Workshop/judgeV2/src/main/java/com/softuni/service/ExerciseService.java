package com.softuni.service;

import com.softuni.models.entity.ExerciseEntity;
import com.softuni.models.service.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {

    void addExercise(ExerciseServiceModel exerciseServiceModel);

    List<String> findAllNames();

    boolean checkIsLate(String exercise);

    ExerciseEntity findByName(String name);
}
