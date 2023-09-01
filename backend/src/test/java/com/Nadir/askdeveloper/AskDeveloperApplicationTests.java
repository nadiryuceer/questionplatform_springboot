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


    User createUser(String name){
        User user = new User();
        user.setNickname(name);
        user.setFirstName("test");
        user.setLastName("user");
        return user;
    }
    QuestionSaveDTO createQuestion(int uid, String title, String desc){
        QuestionSaveDTO question = new QuestionSaveDTO();
        question.setTitle(title);
        question.setDescript(desc);
        question.setUid(uid);
        return question;
    }
    Comment createCommentforQuestion(User user, String text){
        Comment comment = new CommentforQuestion();
        comment.setUser(user);
        comment.setTxt(text);
        return comment;
    }

    Comment createCommentforAnswer(User user, String text){
        Comment comment = new CommentforAnswer();
        comment.setUser(user);
        comment.setTxt(text);
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
        answer.setTxt(text);
        return answer;
    }

    @Test
    void UserSaveTest(){
        User user1 = createUser("testuser");
        userService.save(user1);
        userService.get("testuser");
        assertEquals("user added", user1.getNickname(), userService.get(user1.getNickname()).getNickname());
    }

}
