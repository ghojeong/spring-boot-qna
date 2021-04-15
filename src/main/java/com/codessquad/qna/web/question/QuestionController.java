package com.codessquad.qna.web.question;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    QuestionRepository questionRepository = new QuestionRepository();

    @PostMapping
    public ResponseEntity<Question>  addQuestion(@RequestBody Question question) {
        System.out.println(">>>>>>>>>>>>>" + question.getContent());
        Question addedQuestion = questionRepository.add(question);
        return  ResponseEntity.created(
                URI.create("/questions" + addedQuestion.getId())
        ).body(addedQuestion);
    }

    @GetMapping
    public ResponseEntity<List<Question>>  getQuestions() {
        return  ResponseEntity.ok().body(questionRepository.getQuestions());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(questionRepository.getQuestion(id));
    }
}
