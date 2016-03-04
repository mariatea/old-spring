package com.blog.domain.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.domain.repository.CommentsRepo;
import com.blog.entity.Comments;



@Repository
public class InMemoryCommentsRepo implements CommentsRepo {
	
	@Autowired
	private DataSource dataSource;
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	
	public InMemoryCommentsRepo(){
		
	}
	
	public List<Comments> getCommentList() {
		return null;
	}

	public List<Comments> getCommentsByNoteId(int noteId) {
		String sql = "SELECT * FROM COMMENTS WHERE noteId = ? ORDER BY TIME DESC";
		
		List<Comments> commentList = new ArrayList<Comments>();
		Comments comment = new Comments();
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, noteId);;
			rs = ps.executeQuery();
			while(true){
				if(rs.next()){
				comment.setUsername(rs.getString("user"));
				comment.setMailAdress(rs.getString("mail"));
				comment.setCommentId(rs.getInt("commentid"));
				comment.setNoteId(noteId);
				comment.setContent(rs.getString("content"));
				comment.setTime(rs.getTimestamp("time"));
				commentList.add(comment); 
				}
				else{
					break;
				}
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
				rs.close();
				ps.close();
				conn.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
		
		return commentList;
	}

	@Override
	public void addComment(Comments comment) {
		String sql = "INSERT INTO bdb.comments (user, mail, content, time, noteid) VALUES(?,?,?,?,?)";
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, comment.getUsername());
			ps.setString(2, comment.getMailAdress());
			ps.setString(3, comment.getContent());
			ps.setTimestamp(4, comment.getTime());
			ps.setInt(5, comment.getNoteId());
			ps.executeUpdate();
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
