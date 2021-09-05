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
import com.simplilearn.dao.EmployeeDao;
import com.simplilearn.model.Department;
import com.simplilearn.model.Employee;

@WebServlet(urlPatterns = {"/admin/updateEmployee"})
public class UpdateEmployeeService extends HttpServlet {

	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;

	@Override
	public void init() throws ServletException {
		employeeDao = new EmployeeDao();
		departmentDao = new DepartmentDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			showUpdateEmployeeForm(req,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void showUpdateEmployeeForm(HttpServletRequest req, HttpServletResponse resp) throws  Exception{
		List<Department> departmentList = new ArrayList<>();
		departmentList = departmentDao.viewAllDepartments();
		int id = Integer.parseInt(req.getParameter("id"));
		Employee employee = employeeDao.getEmployee(id);
		req.setAttribute("employee",employee);
		req.setAttribute("departmentList",departmentList);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/updateEmployee.jsp");
		requestDispatcher.forward(req,resp);
	}
}
