package com.korea.one;

import com.korea.one.answer.Answer;
import com.korea.one.answer.AnswerRepository;
import com.korea.one.question.Question;
import com.korea.one.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class OneApplicationTests {

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	AnswerRepository answerRepository;

	@Test
	void contextLoads() {
 		Optional<Question> q1 = this.questionRepository.findById(2);
		 assertTrue(q1.isPresent());
		 Question o = q1.get();

		 List<Answer> answerList = o.getAnswerList();
		 assertEquals(1,answerList.size());
		 assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}
}
