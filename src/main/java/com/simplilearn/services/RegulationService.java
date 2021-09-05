package com.simplilearn.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.RegulationDao;
import com.simplilearn.model.Complience;

@WebServlet(urlPatterns = {"/admin/viewRegulations"})
public class RegulationService extends HttpServlet {

	private RegulationDao regulationDao;

	@Override
	public void init() throws ServletException {
		regulationDao = new RegulationDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			showRegulationsPage(req,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void showRegulationsPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<Complience> complienceList = regulationDao.viewAllCompliences();
		req.setAttribute("complienceList",complienceList);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/viewRegulations.jsp");
		requestDispatcher.forward(req,resp);
	}
}
