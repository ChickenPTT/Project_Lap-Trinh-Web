package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try (Connection conn = DatabaseConnection.getConnection()) {
			String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				// Đăng nhập thành công -> Chuyển đến DogStore
				response.sendRedirect(".\\views\\index.html");
			} else {
				// Sai tài khoản hoặc mật khẩu
				request.setAttribute("loginError", "Đăng nhập thất bại. Sai tên đăng nhập hoặc mật khẩu.");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			response.getWriter().write("Có lỗi xảy ra: " + e.getMessage());
			e.printStackTrace();
		}
	}
}