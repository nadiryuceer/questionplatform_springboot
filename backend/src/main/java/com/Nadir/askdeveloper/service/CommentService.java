package com.Nadir.cs393project.service;

import com.Nadir.cs393project.dto.AnswerCommentSaveDTO;
import com.Nadir.cs393project.dto.QuestionCommentSaveDTO;

import java.util.Map;

public interface CommentService {
    public Map<String,Integer> save(QuestionCommentSaveDTO comment, int qid);
    public Map<String,Integer> save(AnswerCommentSaveDTO comment, int answerid);
    public Map<String,Integer> vote(int id, boolean isupvote);
    public Map<String,Boolean> delete(int id);
    public Map<String,Boolean> update(int id, String txt);
}
