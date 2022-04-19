package com.ma.bidirectional.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
@Data //for the getter setter
@Entity
@Table(name = "answer")
public class Answer {
    private @Id@GeneratedValue(strategy = GenerationType.AUTO) Long id;
    private @Column(name = "answer_name")String answerName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Question question;

    ///question object tryting to fetch the anwer and behave like circle lets igore and see the result recursive call lets handle it

    //still we are not the the question
}
