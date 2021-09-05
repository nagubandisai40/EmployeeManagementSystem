package com.simplilearn.services;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
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

@WebServlet(urlPatterns = {"/admin/addEmployee"})
public class AddEmployeeService extends HttpServlet {

	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;
	private List<Department> departmentList;

	@Override
	public void init() throws ServletException {
		employeeDao = new EmployeeDao();
		departmentDao = new DepartmentDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			showAddEmployeeForm(req,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void showAddEmployeeForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
			departmentList = departmentDao.viewAllDepartments();
			req.setAttribute("deptList",departmentList);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/addEmployeeForm.jsp");
			requestDispatcher.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			addEmployee(req,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void addEmployee(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Employee employee = new Employee();
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date_str = req.getParameter("dob");
		Date date = dateFormat.parse(date_str);

		int deptId = Integer.parseInt(req.getParameter("department"));
		Department department = getDepartment(deptId);
		employee.setFirstName(firstName);
		employee.setEmail(email);
		employee.setLastName(lastName);
		employee.setDob(date);
		if(department!=null)
			employee.setDepartment(department);

		employeeDao.saveEmployee(employee);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/adminHome.jsp");
		requestDispatcher.forward(req,resp);
	}

	private Department getDepartment(int deptId) {
		for(Department d:departmentList)
		{
			if(d.getDeptId() == deptId)
				return  d;
		}
		return  null;
	}
}
