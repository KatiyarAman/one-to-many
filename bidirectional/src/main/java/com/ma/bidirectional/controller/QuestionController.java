package com.ma.bidirectional.controller;

import com.ma.bidirectional.entity.Answer;
import com.ma.bidirectional.entity.Question;
import com.ma.bidirectional.repo.QuestionRepository;
import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/question/*")
public class QuestionController
{
    @Autowired
    QuestionRepository questionRepository;

    @PostMapping("create")
    public Question create(@RequestBody Question question){
        List<Answer>answers= new ArrayList<>();
        List<Answer> answerList= question.getAnswerList();
        for (Answer answer:answerList){
            answer.setQuestion(question);
            answers.add(answer);
        }
        question.setAnswerList(answers);
        return questionRepository.save(question);
    }

    @GetMapping("list")
    public List<Question> list(){
        return questionRepository.findAll();
    }
    //lets provide db configuration

    //lest run

    //lets fetch the record from the anwer side
}
