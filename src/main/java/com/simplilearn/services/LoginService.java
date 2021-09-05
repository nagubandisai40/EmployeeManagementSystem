package com.simplilearn.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.dao.LoginDao;

@WebServlet(urlPatterns = {"/login"})
public class LoginService extends HttpServlet {

	private LoginDao loginDao;

	@Override
	public void init() throws ServletException {
		loginDao = new LoginDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			authenticate(req,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void authenticate(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int username = Integer.parseInt(request.getParameter("userId"));
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		if (loginDao.validate(username, password,role)) {
			HttpSession session = request.getSession();
			session.setAttribute("userName",username);
			if(role.equalsIgnoreCase(LoginRole.USER.toString()))
			{
				session.setAttribute("role",LoginRole.USER.toString());
				response.sendRedirect("user");;
			}else{
				session.setAttribute("role",LoginRole.ADMIN.toString());
				response.sendRedirect("admin");
			}
		} else {
			System.out.println("Login Unsussesful");
			request.setAttribute("errorMessage", "Invalid Details, Try Again!.");
			request.getRequestDispatcher("/index.jsp").forward(request,response);
		}
	}

}
