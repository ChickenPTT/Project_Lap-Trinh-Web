package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // Lấy tham số từ form HTML
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Kiểm tra giá trị lấy từ form
//        System.out.println("Username: " + username);
//        System.out.println("Password: " + password);
//        System.out.println("Email: " + email);

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Câu lệnh SQL INSERT
            String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);

            // Thực thi lệnh SQL
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Đăng ký thành công!");

                // Chuyển hướng sang trang success.jsp nếu thành công
               
               response.sendRedirect("login.jsp");
            } else {
                System.out.println("Thêm người dùng thất bại!");
                response.getWriter().write("Đăng ký thất bại!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Có lỗi xảy ra: " + e.getMessage());
        }
    }
}
