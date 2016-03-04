package com.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.domain.repository.NotesRepo;
import com.blog.entity.Note;
import com.blog.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {
	@Autowired
	private NotesRepo notesRepo;

	public List<Note> getAllNotes() {
		return notesRepo.getListOfNotes() ;
	}
	
	public Note getNotesById(int noteId) {
		return notesRepo.getNotesById(noteId);
	}
	
	public List<Note> getNotesByTag(String tag){
		return notesRepo.getNotesByTag(tag);
	}

	public Object getNotesByDate(String noteDate) {
		return notesRepo.getNotesByDate(noteDate);
	}

	public void addNote(Note note) {
		notesRepo.addNote(note);
	}

	@Override
	public List<Note> getPage(int i) {
		// TODO Auto-generated method stub
		return notesRepo.paginationResult(i);
	}
	
}
