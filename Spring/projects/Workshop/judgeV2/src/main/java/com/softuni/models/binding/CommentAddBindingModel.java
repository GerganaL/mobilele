package com.softuni.models.binding;

import javax.validation.constraints.*;

public class CommentAddBindingModel {
    @Min(value = 2, message = "Score must be more than 2")
    @Max(value = 6, message = "Score must be less than 6")
    private Integer score;
    @Size(min = 3, message = "description must be more than 3 characters")
//    @NotBlank(message = "description cannot be empty")
    private String textContent;
    private Long homeworkId;

    public CommentAddBindingModel() {
    }

    public Integer getScore() {
        return score;
    }

    public CommentAddBindingModel setScore(Integer score) {
        this.score = score;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public CommentAddBindingModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    public CommentAddBindingModel setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
        return this;
    }
}
