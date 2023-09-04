package com.Nadir.askdeveloper;

import com.Nadir.askdeveloper.Exception.UserExistsException;
import com.Nadir.askdeveloper.dto.AnswerCommentSaveDTO;
import com.Nadir.askdeveloper.dto.AnswerSaveDTO;
import com.Nadir.askdeveloper.dto.QuestionCommentSaveDTO;
import com.Nadir.askdeveloper.dto.QuestionGetByIdWithDetails.QuestionDTO;
import com.Nadir.askdeveloper.dto.QuestionSaveDTO;
import com.Nadir.askdeveloper.model.*;
import com.Nadir.askdeveloper.repo.QuestionRepo;
import com.Nadir.askdeveloper.repo.UserRepo;
import com.Nadir.askdeveloper.service.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import static org.springframework.test.util.AssertionErrors.*;

@EnableAutoConfiguration
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AskDeveloperApplicationUserTests {
    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionRepo questionRepo;
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
    QuestionCommentSaveDTO createCommentforQuestion(String username, int questionid, String text){
        QuestionCommentSaveDTO comment = new QuestionCommentSaveDTO();
        comment.setUsername(username);
        comment.setQuestionid(questionid);
        comment.setText(text);
        return comment;
    }

    AnswerCommentSaveDTO createCommentforAnswer(String username, int answerid, String text){
        AnswerCommentSaveDTO comment = new AnswerCommentSaveDTO();
        comment.setUsername(username);
        comment.setAnswerid(answerid);
        comment.setText(text);
        return comment;
    }
    Tag createTag(String name){
        Tag tag = new Tag();
        tag.setName(name);
        return tag;
    }
    AnswerSaveDTO createAnswer(String username, int questionid, String text){
        AnswerSaveDTO answer = new AnswerSaveDTO();
        answer.setUsername(username);
        answer.setQuestionid(questionid);
        answer.setText(text);
        return answer;
    }


    @Test
    void UserServiceTests(){
        // Initial user creation
        User user1 = createUser("testuser", "testuser@gmail.com");
        userService.save(user1);
        userService.get("testuser");
        assertEquals("user added", user1.getUsername(), userService.get(user1.getUsername()).getUsername());

        // Cannot add user with same name
        User user2 = createUser("testuser", "testuser2@gmail.com");
        try{
            userService.save(user2);
            assertTrue("duplicate user add success", false);
        } catch (UserExistsException e){
            assertTrue("duplicate user add failure",true);
        }

        // Cannot add user with same email
        User user3 = createUser("testuser2", "testuser@gmail.com");
        try{
            userService.save(user3);
            assertTrue("duplicate user add success", false);
        } catch (DataIntegrityViolationException e){
            assertTrue("duplicate user add failure",true);
        }

    }

    @Test
    void TagServiceTests(){
        // Initial tag creation
        Tag tag = createTag("java");
        tagService.save(tag);
    }
    @Test
    void QuestionServiceTests(){
        // Initial question creation
        QuestionSaveDTO question1 = createQuestion("Terminator", "Testquestion", "Having an issue. Need help.");
        question1.setTags(new String[]{"springboot", "java"});
        int id = questionService.save(question1);
        QuestionDTO question = questionService.getByIdWithDetails(id);
        assertEquals("object saved", question1.getTitle(), question.getTitle());
    }

    @Test
    void CommentServiceTests(){
        // Initial comment creation for question
        QuestionCommentSaveDTO comment1 = createCommentforQuestion("Terminator", 1, "comment1");
        commentService.save(comment1);
        assertEquals("check if comment added to question", questionService.getByIdWithDetails(1).getComments().get(0).getText(), "comment1");

        // Initial comment creation for answer
        AnswerCommentSaveDTO comment2 = createCommentforAnswer("Terminator",1, "comment2");
        commentService.save(comment2);
        assertEquals("check if comment added to answer", questionService.getByIdWithDetails(1).getAnswers().get(0).getComments().get(0).getText(), "comment2");
    }

}
