package com.simplilearn.services;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.EmployeeDao;

@WebServlet(urlPatterns = {"/admin/deleteEmployee"})
public class DeleteEmployee extends HttpServlet {

	private EmployeeDao employeeDao;

	@Override
	public void init() throws ServletException {
		employeeDao = new EmployeeDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		employeeDao.deleteEmployee(id);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/adminHome.jsp");
		requestDispatcher.forward(req,resp);
	}
}
