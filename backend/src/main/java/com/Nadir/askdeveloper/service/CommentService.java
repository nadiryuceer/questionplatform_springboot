package com.Nadir.askdeveloper.service;

import com.Nadir.askdeveloper.dto.AnswerCommentSaveDTO;
import com.Nadir.askdeveloper.dto.QuestionCommentSaveDTO;

import java.util.Map;

public interface CommentService {
    public Map<String,Integer> save(QuestionCommentSaveDTO comment);
    public Map<String,Integer> save(AnswerCommentSaveDTO comment);
    public Map<String,Integer> vote(int id, boolean isupvote);
    public Map<String,Boolean> delete(int id);
    public Map<String,Boolean> update(int id, String text);
}
