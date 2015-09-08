package com.swarm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.swarm.dao.HostelDao;
import com.swarm.model.HostelDetails;

/**
 * Servlet implementation class ViewInMapServlet
 */
@WebServlet("/ViewInMapServlet")
public class ViewInMapServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String areaName = request.getParameter("s");
			HostelDao objHostelDao = new HostelDao();
			PrintWriter printWriter = null;
			ArrayList<HostelDetails> objHostelDetailsarArrayList = new ArrayList<HostelDetails>();
			objHostelDetailsarArrayList = objHostelDao.getHostelsDetails(areaName);
			String hostelDetailsArraylistString = new Gson().toJson(objHostelDetailsarArrayList);
			printWriter = response.getWriter();
			printWriter.write(hostelDetailsArraylistString);
			printWriter.close();
	}

}
