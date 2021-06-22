package com.softuni.service.impl;

import com.softuni.models.entity.HomeworkEntity;
import com.softuni.repository.HomeworkRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.ExerciseService;
import com.softuni.service.HomeworkService;
import com.softuni.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkRepository homeworkRepository;
    private final ExerciseService exerciseService;
    private final CurrentUser currentUser;
    private final UserService userService;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, ExerciseService exerciseService, CurrentUser currentUser, UserService userService) {
        this.homeworkRepository = homeworkRepository;
        this.exerciseService = exerciseService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public void addHomework(String exercise, String gitAddress) {
        HomeworkEntity homeworkEntity = new HomeworkEntity();
        homeworkEntity.setGitAddress(gitAddress);
        homeworkEntity.setAddedOn(LocalDateTime.now());
        homeworkEntity.setExercise(exerciseService.findByName(exercise));
        homeworkEntity.setAuthor(userService.findById(currentUser.getId()));

        homeworkRepository.save(homeworkEntity);
    }
}
