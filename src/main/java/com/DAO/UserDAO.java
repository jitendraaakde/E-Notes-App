package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDetails;

public class UserDAO {

    private Connection conn;

    public UserDAO(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean addUser(UserDetails userDetails) {
        boolean success = false;
        try {
            String query = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userDetails.getName());
            ps.setString(2, userDetails.getEmail());
            ps.setString(3, userDetails.getPassword());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 1) {
                success = true;
            }
        } catch (Exception e) {
            System.out.println("Error in UserDAO");
            e.printStackTrace();
        }
        return success;
    }

    public UserDetails loginUser(UserDetails us) {
    	boolean f=false;


    	try {
			String query="select * from user where email=? and password=?";
			PreparedStatement ps=conn.prepareStatement(query);
			System.out.println("Hiiiii");
			ps.setString(1, us.getEmail());
			ps.setString(2, us.getPassword());
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {

				us.setId(rs.getInt(1));
				f=true;
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

    	return us;

    }
}














