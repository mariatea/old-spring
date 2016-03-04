package com.blog.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;

public class Note {
	private int noteId;
	private String title;
	private String content;
	private Timestamp time;
	private List<String> tags = new ArrayList<String>();
	
	public Note(){
		super();
	}
	
	

	public Note(String title, String content, Timestamp time, List<String> tags) {
		this.title = title;
		this.content = content;
		this.time = time;
		this.tags = tags;
	}

	public int getNoteId() {
		return noteId;
	}


	public void setNoteId(int i) {
		this.noteId = i;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp timestamp) {
		this.time = timestamp;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> test1) {
		this.tags.addAll(test1);
	}
	
	public void setTags(String unparsedTags){
		this.tags = parseTags(unparsedTags);
	}


	private List<String> parseTags(String string){
		String[] split = string.split(",");
		List<String> splitList = Arrays.asList(split);
		return splitList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (noteId == 0) {
			if (other.noteId != 0)
				return false;
		} else if (noteId != other.noteId)
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", title=" + title + ", content=" + content + ", time=" + time + ", tags="
				+ tags + "]";
	}
	
	

}
