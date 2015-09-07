package com.swarm.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	private DBUtil() {
	}

	public static Connection getConnection(String dbName) {
		Connection dbConnection = null;
		try {
			Class.forName("org.postgresql.Driver");
			dbConnection = DriverManager.getConnection("jdbc:postgresql://192.168.1.19:5432/" + dbName, "openerp", "openerp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbConnection;
	}

}
