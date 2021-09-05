package com.simplilearn.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.DepartmentDao;
import com.simplilearn.model.Department;

@WebServlet(urlPatterns = {"/admin/viewDepartments"})
public class DepartmentService extends HttpServlet {

	private DepartmentDao departmentDao;

	@Override
	public void init() throws ServletException {
		departmentDao = new DepartmentDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			showViewDepartments(req,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void showViewDepartments(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<Department> deptList = new ArrayList<>();
		deptList = departmentDao.viewAllDepartments();
		req.setAttribute("deptList",deptList);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/viewDepartments.jsp");
		requestDispatcher.forward(req,resp);
	}
}
