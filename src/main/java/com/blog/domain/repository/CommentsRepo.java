package com.blog.domain.repository;

import java.util.List;

import com.blog.entity.Comments;

public interface CommentsRepo {
	
	public void addComment(Comments comment);
	public List<Comments> getCommentsByNoteId(int noteId);
	
}
