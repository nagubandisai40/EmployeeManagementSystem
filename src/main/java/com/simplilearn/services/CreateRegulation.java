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
import com.simplilearn.dao.RegulationDao;
import com.simplilearn.model.Department;

@WebServlet("/admin/addRegulation")
public class CreateRegulation extends HttpServlet {

	private RegulationDao regulationDao;
	private DepartmentDao departmentDao;
	@Override
	public void init() throws ServletException {
		regulationDao = new RegulationDao();
		departmentDao = new DepartmentDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			showCreateRegulationForm(req,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// to be implemented
		System.out.println("Post method of add regulation called");

	}

	private void showCreateRegulationForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<Department> deptList = departmentDao.viewAllDepartments();
		req.setAttribute("deptList",deptList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/createRegulation.jsp");
		dispatcher.forward(req,resp);
	}
}
