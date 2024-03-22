package com.Servlet;

import java.io.IOException;

import com.DAO.PostDAO;
import com.Db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Integer noteid=Integer.parseInt(req.getParameter("noteid"));
			String title=req.getParameter("title");
			String content=req.getParameter("content");

			PostDAO dao=new PostDAO(DBConnect.getConn());
			boolean f=dao.PostUpdate(noteid, title, content);

			if(f) {
				System.out.println("data update successfully");
				HttpSession session=req.getSession();
				session.setAttribute("updateMsg", "Notes Update Successfully");
				resp.sendRedirect("showNotes.jsp");

			}else {
				System.out.println("data not update");
			}


		} catch (Exception e) {
			// TODO: handle exception
		}


	}
}


