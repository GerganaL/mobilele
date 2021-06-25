package com.softuni.service;

import com.softuni.models.service.CommentServiceModel;

import java.util.Map;

public interface CommentService {
    void add(CommentServiceModel serviceModel, Long homeworkId);

    Double findAvgScore();

    Map<Integer, Integer> findScoreMap();
}
