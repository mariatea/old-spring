package com.blog.service;

import java.util.List;

import com.blog.entity.Comments;

public interface CommentsService {
	
	public void addComment(Comments Comment);
	List<Comments> getCommentsByNoteId(int noteId);
	
}
