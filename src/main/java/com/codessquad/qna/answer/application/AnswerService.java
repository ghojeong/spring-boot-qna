package com.codessquad.qna.answer.application;

import com.codessquad.qna.answer.domain.Answer;
import com.codessquad.qna.answer.domain.AnswerRepository;
import com.codessquad.qna.answer.dto.AnswerRequest;
import com.codessquad.qna.answer.dto.AnswerResponse;
import com.codessquad.qna.answer.exception.AnswerDeletedException;
import com.codessquad.qna.answer.exception.AnswerNotFoundException;
import com.codessquad.qna.question.domain.Question;
import com.codessquad.qna.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public AnswerResponse save(AnswerRequest answerRequest, Question question, User writer) {
        Answer answer = answerRepository.save(answerRequest.toAnswer(question, writer));
        return AnswerResponse.of(answer);
    }

    public void deleteAnswer(Long id) {
        Answer answer = getAnswerFromRepository(id);
        answer.delete();
        answerRepository.save(answer);
    }

    public Long getWriterId(Long id) {
        return getAnswerFromRepository(id)
                .getWriter()
                .getId();
    }

    public Answer getAnswerFromRepository(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new AnswerNotFoundException(String.format("존재하지 않는 답변입니다. id: %d", id)));
        if (answer.isDeleted()) {
            throw new AnswerDeletedException(String.format("이미 삭제된 답변입니다. id: %d", id));
        }
        return answer;
    }
}
