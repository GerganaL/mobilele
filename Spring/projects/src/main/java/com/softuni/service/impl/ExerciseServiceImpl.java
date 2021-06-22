package com.softuni.service.impl;

import com.softuni.models.entity.ExerciseEntity;
import com.softuni.models.service.ExerciseServiceModel;
import com.softuni.repository.ExercisesRepository;
import com.softuni.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExercisesRepository exercisesRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExercisesRepository exercisesRepository, ModelMapper modelMapper) {
        this.exercisesRepository = exercisesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise(ExerciseServiceModel exerciseServiceModel) {
        exercisesRepository.save(modelMapper.map(exerciseServiceModel, ExerciseEntity.class));
    }

    @Override
    public List<String> findAllNames() {
        return exercisesRepository.findAllExNames();
    }

    @Override
    public boolean checkIsLate(String exercise) {
        ExerciseEntity exerciseEntity = exercisesRepository.findByName(exercise).orElse(null);
        return exerciseEntity.getDueDate().isBefore(LocalDateTime.now());
    }



    public ExerciseEntity findByName(String name) {
        return exercisesRepository.findByName(name).orElse(null);
    }
}
