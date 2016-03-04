package com.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.domain.repository.CommentsRepo;
import com.blog.entity.Comments;
import com.blog.service.CommentsService;


@Service
public class CommentsServiceImpl implements CommentsService {
	
	@Autowired
	private CommentsRepo commentsRepo;
	
	public List<Comments> getCommentsByNoteId(int noteId) {
		return commentsRepo.getCommentsByNoteId(noteId);
	}

	@Override
	public void addComment(Comments comment) {
		commentsRepo.addComment(comment);
	}

}
