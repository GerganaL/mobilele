package com.softuni.service;

import com.softuni.models.entity.HomeworkEntity;
import com.softuni.models.service.HomeworkServiceModel;

public interface HomeworkService {
    void addHomework(String exercise, String gitAddress);

    HomeworkServiceModel findHomeworkForScoring();

    HomeworkEntity findById(Long homeworkId);

}
