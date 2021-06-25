package com.softuni.service.impl;

import com.softuni.models.entity.CommentEntity;
import com.softuni.models.service.CommentServiceModel;
import com.softuni.repository.CommentRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.CommentService;
import com.softuni.service.HomeworkService;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final HomeworkService homeworkService;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, HomeworkService homeworkService, UserService userService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.homeworkService = homeworkService;
        this.userService = userService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(CommentServiceModel serviceModel, Long homeworkId) {
        CommentEntity comment = modelMapper.map(serviceModel, CommentEntity.class);
        comment.setAuthor(userService.findById(currentUser.getId()));
        comment.setHomework(homeworkService.findById(homeworkId));

        commentRepository.save(comment);
    }

    @Override
    public Double findAvgScore() {
        return commentRepository.findAvgScore();
    }

    @Override
    public Map<Integer, Integer> findScoreMap() {
        Map<Integer, Integer> scoreMap = initScoreMap();

        commentRepository.findAll()
                .forEach(comment -> {
                    Integer score = comment.getScore();
                    scoreMap.put(score,scoreMap.get(score) + 1);
                });

        return scoreMap;
    }

    private Map<Integer, Integer> initScoreMap() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i <= 6; i++) {
            map.put(i,0);
        }
        return map;
    }
}
