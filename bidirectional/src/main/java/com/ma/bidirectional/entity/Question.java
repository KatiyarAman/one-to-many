package com.ma.bidirectional.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "question")
public class Question {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    private @Column(name = "question_name") String questionName;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Answer> answerList;

}
