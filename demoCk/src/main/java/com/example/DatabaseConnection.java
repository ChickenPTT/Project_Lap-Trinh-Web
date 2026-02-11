package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	// Lấy thông tin từ Environment Variables
//	private static final String URL = System.getenv("JDBC_CONNECTION_STRING");
//	private static final String USER = System.getenv("JDBC_USERNAME");
//	private static final String PASSWORD = System.getenv("JDBC_PASSWORD");

	 private static final String URL =
	 "jdbc:mysql://127.0.0.1:3306/user_management?useSSL=false&autoReconnect=true&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	 private static final String USER = "root";
	 private static final String PASSWORD = "Thinhtien2005!";

	// Phương thức getConnection
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // Nạp driver
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}	

	// Hàm main để kiểm tra kết nối
	public static void main(String[] args) {
		try (Connection conn = getConnection()) {
			System.out.println("Kết nối thành công!");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver không tìm thấy!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Kết nối thất bại!");
			e.printStackTrace();
		}
	}
}
