package com.blog.controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.entity.Comments;
import com.blog.entity.Note;
import com.blog.service.CommentsService;
import com.blog.service.DetailService;
import com.blog.service.NoteService;


@Controller
@RequestMapping(value={"/", "/index"})
public class NoteController {
	@Autowired
	private NoteService notesServ;
	@Autowired
	private DetailService detailService;
	@Autowired
	private CommentsService commentService;
	
	
	@RequestMapping()
	public String list(Model model){
		model.addAttribute("notes", notesServ.getAllNotes());
		model.addAttribute("count", "yay");
		return "notes";
	}
	
	@RequestMapping("/tagged")
	public String tagList(Model model,  @RequestParam("tag") String noteTag){
		model.addAttribute("notes", notesServ.getNotesByTag(noteTag));
		model.addAttribute("count","tagpage");
		return "notes";	
	}
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String showDetail(Model model, @RequestParam("id") int noteId){
		Comments newComment = new Comments();
		newComment.setNoteId(noteId);
		model.addAttribute("newComment", newComment);
		model.addAttribute("note", detailService.processRequest(noteId));
		model.addAttribute("comments", commentService.getCommentsByNoteId(noteId));
		return "details";
	}
	
	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public String processComment(@ModelAttribute("newComment") Comments newComment){
		commentService.addComment(newComment);
		return "redirect:/index";
	}
	
	@RequestMapping("/date")
	public String dateSearch(Model model, @RequestParam("date") String noteDate){
		model.addAttribute("note", notesServ.getNotesByDate(noteDate));
		return "notes";
	}
	
}
