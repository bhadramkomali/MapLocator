package com.swarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.swarm.db.DBUtil;
import com.swarm.model.HostelDetails;

public class HostelDao {

	public int insertHosteldetails(HostelDetails objHostelDetails) {
		Connection connection = null;
		PreparedStatement insertHostelPreparedStatement = null;
		String insertHostelQuery = "INSERT INTO hostel_details(hostel_name, hostel_area_name, hostel_address, hostel_owner_name, phone_number, hostel_fee, hostel_long, hostel_lat) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		String dbName = "hostel";
		try {
			connection = DBUtil.getConnection(dbName);
			if (connection != null) {
				insertHostelPreparedStatement = connection.prepareStatement(insertHostelQuery);
				insertHostelPreparedStatement.setString(1, objHostelDetails.getHostelName());
				insertHostelPreparedStatement.setString(2, objHostelDetails.getAreaName());
				insertHostelPreparedStatement.setString(3, objHostelDetails.getHostelAddress());
				insertHostelPreparedStatement.setString(4, objHostelDetails.getOwnerName());
				insertHostelPreparedStatement.setString(5, objHostelDetails.getContactNumber());
				insertHostelPreparedStatement.setDouble(6, objHostelDetails.getHostelFee());
				insertHostelPreparedStatement.setDouble(7, objHostelDetails.getHostelLong());
				insertHostelPreparedStatement.setDouble(8, objHostelDetails.getHostelLat());
				int status = insertHostelPreparedStatement.executeUpdate();
				if (status == 1) {
					connection.close();
					return 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		return 0;
	}

	public ArrayList<HostelDetails> getHostelsDetails(String area) {
		ArrayList<HostelDetails> objHostelDetailsArrayList = new ArrayList<HostelDetails>();
		Connection connection = null;
		ResultSet hostelsResultSet = null;
		PreparedStatement getHostelsPreparedStatement = null;
		String getHostelsQuery = "SELECT * FROM hostel_details WHERE hostel_area_name=?";
		String dbName = "hostel";
		try {
			connection = DBUtil.getConnection(dbName);
			if (connection != null) {
				getHostelsPreparedStatement = connection.prepareStatement(getHostelsQuery);
				getHostelsPreparedStatement.setString(1, area);
				hostelsResultSet = getHostelsPreparedStatement.executeQuery();
				while (hostelsResultSet.next()) {
					HostelDetails objHostelDetails = new HostelDetails();
					objHostelDetails.setAreaName(hostelsResultSet.getString("hostel_area_name"));
					objHostelDetails.setContactNumber(hostelsResultSet.getString("phone_number"));
					objHostelDetails.setHostelAddress(hostelsResultSet.getString("hostel_address"));
					objHostelDetails.setHostelFee(hostelsResultSet.getDouble("hostel_fee"));
					objHostelDetails.setHostelLat(hostelsResultSet.getDouble("hostel_lat"));
					objHostelDetails.setHostelLong(hostelsResultSet.getDouble("hostel_long"));
					objHostelDetails.setHostelName(hostelsResultSet.getString("hostel_name"));
					objHostelDetails.setOwnerName(hostelsResultSet.getString("hostel_owner_name"));
					objHostelDetailsArrayList.add(objHostelDetails);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		return objHostelDetailsArrayList;
	}
}
