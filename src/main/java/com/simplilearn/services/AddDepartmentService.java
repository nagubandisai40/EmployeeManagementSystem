package com.simplilearn.services;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.DepartmentDao;
import com.simplilearn.model.Department;

@WebServlet(urlPatterns = {"/admin/addDepartment"})
public class AddDepartmentService extends HttpServlet {

	DepartmentDao departmentDao;

	@Override
	public void init() throws ServletException {
		departmentDao = new DepartmentDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			showAddDeptForm(req,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void showAddDeptForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/addDepartment.jsp");
		requestDispatcher.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			addDepartment(req,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void addDepartment(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Department department = new Department();
		String deptName = req.getParameter("deptName");
		department.setDeptName(deptName);
		departmentDao.addDepartment(department);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/viewDepartments.jsp");
		requestDispatcher.forward(req,resp);
	}
}
