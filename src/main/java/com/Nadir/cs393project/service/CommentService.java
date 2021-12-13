package com.Nadir.cs393project.service;

import com.Nadir.cs393project.dto.AnswerCommentSaveDTO;
import com.Nadir.cs393project.dto.QuestionCommentSaveDTO;
import com.Nadir.cs393project.model.Comment;

import java.util.Map;

public interface CommentService {
    public Map<String,Integer> save(QuestionCommentSaveDTO comment);
    public Map<String,Integer> save(AnswerCommentSaveDTO comment);
    public Map<String,Integer> vote(int id);
    public Map<String,Boolean> delete(int id);
}
