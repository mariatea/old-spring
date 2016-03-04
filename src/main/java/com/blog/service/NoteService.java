package com.blog.service;

import java.util.List;

import com.blog.entity.Note;

public interface NoteService {
	
	public void addNote(Note note);
	public List<Note> getAllNotes();
	public Note getNotesById(int noteId);
	public List<Note> getNotesByTag(String tag);
	public Object getNotesByDate(String noteDate);
	public List<Note> getPage(int i);
	
}
