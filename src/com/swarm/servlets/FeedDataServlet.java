package com.swarm.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.swarm.dao.HostelDao;
import com.swarm.model.GoogleResponse;
import com.swarm.model.HostelDetails;
import com.swarm.model.Result;

/**
 * Servlet implementation class FeedDataServlet
 */
@WebServlet("/FeedDataServlet")
public class FeedDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int status = 0;
		HttpURLConnection connection = null;
		String latitude = null;
		String longitude = null;
		InputStream inputStream = null;
		String geoCodeURL = "https://maps.googleapis.com/maps/api/geocode/json?address=";

		String areaName = request.getParameter("area");
		String hostelName = request.getParameter("hostelname");
		String phoneNumber = request.getParameter("phoneno");
		String ownerName = request.getParameter("ownername");
		String hostelFee = request.getParameter("hostelfee");
		String address = request.getParameter("address");

		HostelDao objHostelDao = new HostelDao();
		HostelDetails objHostelDetails = new HostelDetails();
		response.setContentType("text/html");

		objHostelDetails.setAreaName(areaName);
		objHostelDetails.setContactNumber(phoneNumber);
		objHostelDetails.setHostelAddress(address);
		objHostelDetails.setHostelFee(Double.parseDouble(hostelFee));
		objHostelDetails.setHostelName(hostelName);
		objHostelDetails.setOwnerName(ownerName);

		try {
			URL urlObj = new URL(geoCodeURL
					+ URLEncoder.encode(address, "UTF-8"));
			connection = (HttpURLConnection) urlObj.openConnection();
			inputStream = connection.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			GoogleResponse googleResponse = (GoogleResponse) mapper.readValue(
					inputStream, GoogleResponse.class);
			if (googleResponse.getStatus().equals("OK")) {
				Result result = googleResponse.getResults()[0];
				latitude = result.getGeometry().getLocation().getLat();
				longitude = result.getGeometry().getLocation().getLng();
			}
			objHostelDetails.setHostelLat(Double.parseDouble(latitude));
			objHostelDetails.setHostelLong(Double.parseDouble(longitude));

			status = objHostelDao.insertHosteldetails(objHostelDetails);
			if (status == 1) {
				request.setAttribute("msg", "Successfully inserted the hostel details");
				request.getRequestDispatcher("/feeddata.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Unable to insert the hostel details");
				request.getRequestDispatcher("/feeddata.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			inputStream.close();
		}
	}

}
