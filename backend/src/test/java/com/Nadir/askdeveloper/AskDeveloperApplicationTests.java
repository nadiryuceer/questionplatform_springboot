package com.Nadir.askdeveloper;

import com.Nadir.askdeveloper.dto.QuestionSaveDTO;
import com.Nadir.askdeveloper.model.*;
import com.Nadir.askdeveloper.repo.UserRepo;
import com.Nadir.askdeveloper.service.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.*;

@EnableAutoConfiguration
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AskDeveloperApplicationTests {
    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerService answerService;
    @Autowired
    CommentService commentService;
    @Autowired
    TagService tagService;
    @Autowired
    UserService userService;
    @Autowired
    UserRepo userRepo;


    User createUser(String name, String email){
        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setFirstName("test");
        user.setLastName("user");
        return user;
    }
    QuestionSaveDTO createQuestion(String username, String title, String desc){
        QuestionSaveDTO question = new QuestionSaveDTO();
        question.setTitle(title);
        question.setDescription(desc);
        question.setUsername(username);
        return question;
    }
    Comment createCommentforQuestion(User user, String text){
        Comment comment = new CommentforQuestion();
        comment.setUser(user);
        comment.setText(text);
        return comment;
    }

    Comment createCommentforAnswer(User user, String text){
        Comment comment = new CommentforAnswer();
        comment.setUser(user);
        comment.setText(text);
        return comment;
    }
    Tag createTag(String name){
        Tag tag = new Tag();
        tag.setName(name);
        return tag;
    }
    Answer createAnswer(User user, Question question,String text){
        Answer answer = new Answer();
        answer.setUser(user);
        answer.setQuestion(question);
        answer.setText(text);
        return answer;
    }

    @Test
    void UserSaveTest(){
        User user1 = createUser("testuser", "testuser@gmail.com");
        userService.save(user1);
        userService.get("testuser");
        assertEquals("user added", user1.getUsername(), userService.get(user1.getUsername()).getUsername());
    }

}
