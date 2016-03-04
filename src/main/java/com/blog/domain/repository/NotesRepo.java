package com.blog.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blog.entity.Note;

@Repository
public interface NotesRepo {

	public void addNote(Note note);
	public List<Note> getListOfNotes();
	public Note getNotesById(int noteId);
	public List<Note> getNotesByTag(String tag);
	public Object getNotesByDate(String noteDate);
	public List<Note> paginationResult(int pageNo);
	
}
