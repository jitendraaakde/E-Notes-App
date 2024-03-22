package com.Servlet;

import java.io.IOException;

import com.DAO.PostDAO;
import com.Db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int uid = Integer.parseInt(request.getParameter("uid"));
	String title=request.getParameter("title");
	String content=request.getParameter("content");

	PostDAO dao=new PostDAO(DBConnect.getConn());
	boolean f=dao.AddNotes(title, content, uid);

	if(f) {
		System.out.println("Data insert");
	}else {
		System.out.println("data not insert");
	}

	}

}