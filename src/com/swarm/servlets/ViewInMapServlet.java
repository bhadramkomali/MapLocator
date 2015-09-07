package com.swarm.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swarm.dao.HostelDao;

/**
 * Servlet implementation class ViewInMapServlet
 */
@WebServlet("/ViewInMapServlet")
public class ViewInMapServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			String areaName = request.getParameter("area");
			HostelDao objHostelDao = new HostelDao();
			objHostelDao.getHostelsDetails(areaName);
	}

}
