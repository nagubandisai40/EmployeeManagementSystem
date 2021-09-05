package com.simplilearn.services;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/user"})
public class UserService extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			showUserdashBoard(req,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void showUserdashBoard(HttpServletRequest req, HttpServletResponse resp) throws  Exception {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/employee_home.jsp");
		requestDispatcher.forward(req,resp);
	}
}
