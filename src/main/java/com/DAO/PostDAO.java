package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.Post;

public class PostDAO {


	private Connection conn;

	public PostDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean AddNotes(String ti,String co,int ui) {
		boolean f=false;

		try {
			String qu="insert into post(title, content, uid) values (?,?,?)";
			PreparedStatement ps=conn.prepareStatement(qu);
			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, ui);

			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return f;
	}


	public Post getDatabyId(int noteId) {
		Post p=null;
		try {
			String qu="select * from post where id=?";
			PreparedStatement ps=conn.prepareStatement(qu);
			ps.setInt(1, noteId);

			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				p=new Post();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	public boolean PostUpdate(int nid, String ti, String co) {
		boolean f=false;
		try {
			String query="update post set title=?, content=? where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, nid);
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	return f;
	}

	public boolean DeleteNotes(int nid) {


		boolean f= false;
		try {
			String query="delete from post where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, nid);
			int x=ps.executeUpdate();
			if(x==1) {
				f=true;
			}



		} catch (Exception e) {
			e.printStackTrace();

		}

		return f;
	}


}













