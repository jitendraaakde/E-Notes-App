package com.Servlet;

import java.io.IOException;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("fname");
        String email = request.getParameter("uemail");
        String password = request.getParameter("upassword");

        UserDetails userDetails = new UserDetails();
        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setPassword(password);

        UserDAO userDao = new UserDAO(DBConnect.getConn());
        boolean isSuccess = userDao.addUser(userDetails);

       HttpSession session;


        if (isSuccess) {
        	session=request.getSession();
        	session.setAttribute("reg-sucsess", "Registration Sucessfylly");
        	response.sendRedirect("register.jsp");
        } else {
        session=request.getSession();
        session.setAttribute("failed-hamsg", "something went wrong");
        response.sendRedirect("register.jsp");
        }
    }
}
