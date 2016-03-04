package com.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.domain.repository.NotesRepo;
import com.blog.entity.Note;
import com.blog.service.DetailService;

@Service
public class DetailServiceImpl implements DetailService
{
	@Autowired
	private NotesRepo noteRepo;

	public Note processRequest(int noteId) {
		// TODO Auto-generated method stub
		return noteRepo.getNotesById(noteId);
		
	}

}
