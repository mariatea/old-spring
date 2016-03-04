package com.blog.domain.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.domain.repository.NotesRepo;
import com.blog.entity.Note;


@Repository
public class InMemoryNotesRepo implements NotesRepo {
	
	@Autowired
	private DataSource dataSource;
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	Boolean internal = false;
	
	public InMemoryNotesRepo(){
	}
	

	public List<Note> getListOfNotes() {
		String sql = "SELECT * FROM NOTES n RIGHT JOIN TAGS t  on n.noteId=t.noteId"
				+ " UNION SELECT * FROM NOTES n LEFT JOIN TAGS t on n.noteId=t.noteId "
				+ "ORDER BY time DESC";
		
		List<Note> listOfNotes = new ArrayList<Note>();
		Note note = new Note();
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			int prevId = -1;
			List<String> tags = new ArrayList<String>();
			while (rs.next()){
				if(prevId != -1 && prevId != rs.getInt("noteid")){
					note.getTags();
					listOfNotes.add(note);
					note = new Note();
					tags.clear();
				}
				note.setNoteId(prevId = rs.getInt("noteid"));
				note.setTitle(rs.getString("title"));
				note.setTime(rs.getTimestamp("time"));
				note.setContent(rs.getString("content"));
				if(rs.getString("tag") != null)
					tags.add(rs.getString("tag"));
			  }
				note.getTags();
				listOfNotes.add(note);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		      try {
		        rs.close();
		        ps.close();
		        conn.close();
		      }catch (SQLException e) {
		        e.printStackTrace();
		      }
		    }
		return listOfNotes;
	}
	
	public List<Note> paginationResult(int pageNo){
		String sql = "SELECT noteid FROM NOTES ORDER BY time DESC LIMIT 0, 10";
		List<Note> listOfNotes = new ArrayList<Note>();
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			internal = true;
			while(true){
				if(rs.next())
					listOfNotes.add(getNotesById(rs.getInt("noteId")));
				else
					break;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			internal = false;
		      try {
		        rs.close();
		        ps.close();
		        conn.close();
		      }catch (SQLException e) {
		        e.printStackTrace();
		      }
		    }
		return listOfNotes;
	}


	public Note getNotesById(int noteId) {
		String sql = "SELECT * FROM NOTES n RIGHT JOIN TAGS t  on n.noteId=t.noteId WHERE n.noteId = ?"
				+ " UNION SELECT * FROM NOTES n LEFT JOIN TAGS t on n.noteId=t.noteId "
				+ "WHERE n.noteId = ? ORDER BY time DESC" ;
		Note note = new Note();
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, noteId);
			ps.setInt(2, noteId);
			rs = ps.executeQuery();
			List<String> tags = new ArrayList<String>();
			if(rs.next()){
				note.setNoteId(rs.getInt("noteid"));
				note.setTitle(rs.getString("title"));
				note.setTime(rs.getTimestamp("time"));
				note.setContent(rs.getString("content"));
				if(rs.getString("tag") != null){
					tags.add(rs.getString("tag"));
				while(true){
					if(rs.next())
						tags.add(rs.getString("tag"));
					else
						break;
				}
				note.setTags(tags);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(!internal){
				rs.close();
			    ps.close();
			    conn.close();
				}
			    }catch (SQLException e) {
			    	e.printStackTrace();
			    } 
			}
		return note;	
	}

	
	public List<Note> getNotesByTag(String tag){
		String sql = "SELECT * FROM NOTES n JOIN TAGS t ON n.noteId = t.noteId WHERE t.tag = ? ORDER BY n.time";
		Note note = new Note();
		List<Note> listOfNotes = new ArrayList<Note>();
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tag);
			rs = ps.executeQuery();
			int prevId = 0;  
			while(true){
				if(rs.next()){
				List<String> tags = new ArrayList<String>();
				
				note.setNoteId(rs.getInt("noteid"));
				note.setTitle(rs.getString("title"));
				note.setTime(rs.getTimestamp("time"));
				note.setContent(rs.getString("content"));
				while(rs.getInt("noteid")== prevId){
					tags.add(rs.getString("tag"));
					}
				note.setTags(tags);
				listOfNotes.add(note);
				prevId = rs.getInt("noteid");
				}else
					break;
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		      try {
		        rs.close();
		        ps.close();
		        conn.close();
		      }catch (SQLException e) {
		        e.printStackTrace();
		      }
		    }
		return listOfNotes;
	}


	@Override
	public Object getNotesByDate(String noteDate) {
		List<Note> noteByDate = new ArrayList<Note>();
		
		return null;
	}


	@Override
	public void addNote(Note note) {
		String insertTableSQL = "INSERT INTO bdb.notes (title, content, time) VALUES(?,?,?)";
		String insertTags = "INSERT INTO bdb.tags(noteid,tag) VALUES(?,?)";
		int id = 0;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, note.getTitle());
			ps.setString(2, note.getContent());
			ps.setTimestamp(3, note.getTime());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
			    id = rs.getInt(1);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		      try {
		        rs.close();
		        ps.close();
		        conn.close();
		      }catch (SQLException e) {
		        e.printStackTrace();
		      }
		}
		try{
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(insertTags);
			for(String tag : note.getTags()){
				ps.setInt(1, id);
				ps.setString(2, tag);
				ps.addBatch();
			}
			ps.executeBatch();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		      try {
		        rs.close();
		        ps.close();
		        conn.close();
		      }catch (SQLException e) {
		        e.printStackTrace();
		      }
		}
	}
}
