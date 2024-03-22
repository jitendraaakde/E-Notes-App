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

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer noteid=Integer.parseInt(req.getParameter("note_id"));
		PostDAO dao=new PostDAO(DBConnect.getConn());
		boolean f=dao.DeleteNotes(noteid);

		HttpSession session =null;
		if(f) {
			session=req.getSession();
			session.setAttribute("deleteMsg", "notes delete Sucvess");
			resp.sendRedirect("showNotes.jsp");
		}else {
			session=req.getSession();
			session.setAttribute("wrongMsg", "something went wrong with server");
		}

	}
}
