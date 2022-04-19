package com.ma.bidirectional.controller;

import com.ma.bidirectional.DTO.AnswerDTO;
import com.ma.bidirectional.DTO.QuestionDTO;
import com.ma.bidirectional.entity.Answer;
import com.ma.bidirectional.entity.Question;
import com.ma.bidirectional.repo.AnswerRepository;
import com.ma.bidirectional.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/answer/*")
public class AnswerController {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;
    @GetMapping("list")
    public List<AnswerDTO> lits(){

        List<AnswerDTO>answerDTOS= new ArrayList<>();

        for (Answer answer:answerRepository.findAll()){
            Question question=answer.getQuestion();
            //lets convert into Dto
            QuestionDTO questionDTO= new QuestionDTO();
            questionDTO.setId(question.getId());
            questionDTO.setQuestionName(question.getQuestionName());

            //lest convet answer to answerDto
            AnswerDTO answerDTO= new AnswerDTO();
            answerDTO.setId(answer.getId());
            answerDTO.setAnswerName(answer.getAnswerName());
            answerDTO.setQuestionDTO(questionDTO);
            answerDTOS.add(answerDTO);
        }
        return answerDTOS;
    }

    @PostMapping("create")
    public Answer save(@RequestBody Answer answer){
        return answerRepository.save(answer);
    }

    //not able to fecth the question
    //lets crete dto
    //done

    //lets try to save answer an
}
