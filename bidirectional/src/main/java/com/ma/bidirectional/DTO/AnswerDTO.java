package com.ma.bidirectional.DTO;

import lombok.Data;

@Data
public class AnswerDTO {

    private Long id;
    private String answerName;

    private QuestionDTO questionDTO;
}
