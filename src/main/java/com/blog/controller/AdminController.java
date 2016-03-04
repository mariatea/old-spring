package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.entity.Note;
import com.blog.service.NoteService;

@Controller
public class AdminController {
	@Autowired
	private NoteService noteService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPanel(Model model){
		Note newNote = new Note();
		model.addAttribute("newNote", newNote);
		return "admin";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String postPanel(@ModelAttribute("newNote") Note newNote){
		noteService.addNote(newNote);
		return "redirect:/index";
		
	}
}
