package com.owis.PL.web;

import com.owis.PL.Data.entity.Question;
import com.owis.PL.Data.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/question")
public class QuestionController {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @PostMapping
    public Question addQuestion(@RequestParam(name = "questionText", required = true) String questionText){
        Question question = new Question();
        question.setQuestionText(questionText);
        return this.questionRepository.save(question);
    }

    @GetMapping
    public List<Question>getQuestions(){
    List<Question>questions = new ArrayList<>();
    this.questionRepository.findAll().forEach(questions::add);
    return questions;
    }
}
