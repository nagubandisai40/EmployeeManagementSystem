package com.simplilearn.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.DepartmentDao;
import com.simplilearn.dao.EmployeeDao;
import com.simplilearn.model.Employee;

@WebServlet("/admin")
public class AdminService extends HttpServlet {
	private EmployeeDao employeeDao;

	@Override
	public void init() throws ServletException {
		employeeDao = new EmployeeDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		try{
			listEmployees(req,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void listEmployees(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<Employee> listUser = employeeDao.showAllEmployees();
		req.setAttribute("listUser",listUser);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/adminHome.jsp");
		requestDispatcher.forward(req,resp);
	}

}
