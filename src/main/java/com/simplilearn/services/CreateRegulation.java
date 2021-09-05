package com.simplilearn.services;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.DepartmentDao;
import com.simplilearn.dao.RegulationDao;
import com.simplilearn.model.Complience;
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
		// to be implemented

		try{
			addComplience(req,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void addComplience(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Complience complience = new Complience();
		String regulationType = req.getParameter("regulationType");
		String details = req.getParameter("regulationDetails");
		String date_str = req.getParameter("date");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(date_str);
		int deptId = Integer.parseInt(req.getParameter("department"));
		Department department = departmentDao.getDepartment(deptId);

		complience.setDate(date);
		complience.setRegulationType(regulationType);
		complience.setDepartment(department);
		complience.setDetails(details);

		regulationDao.addRegulation(complience);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/viewRegulations");
		requestDispatcher.forward(req,resp);
	}


	private void showCreateRegulationForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<Department> deptList = departmentDao.viewAllDepartments();
		req.setAttribute("deptList",deptList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/createRegulation.jsp");
		dispatcher.forward(req,resp);
	}
}
