package com.owis.PL.web;

import com.owis.PL.Data.entity.Answer;
import com.owis.PL.Data.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/answer")
public class AnswerController {

    private final AnswerRepository answerRepository;

    @Autowired

    public AnswerController(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @PostMapping
    public Answer addAnswer(@RequestParam(name = "questionId", required = true) Long questionId,
                            @RequestParam(name = "questionAnswer", required = true) String questionAnswer,
                            @RequestParam(name = "nationalNumber", required = true) Long nationalNumber) {
        Answer answer = new Answer();
        answer.setQuestionId(questionId);
        answer.setAnswer(questionAnswer);
        answer.setNationalNumber(nationalNumber);
        return this.answerRepository.save(answer);
    }




}
