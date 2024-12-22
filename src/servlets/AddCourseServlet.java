package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        String courseName = request.getParameter("courseName");
        String department = request.getParameter("department");
        int creditHours = Integer.parseInt(request.getParameter("creditHours"));

        String url = "jdbc:oracle:thin:@localhost:1521:FREE";
        String user = "sys as sysdba";  // اسم المستخدم
        String password = "root";  // كلمة المرور

        try {
            // تحميل Driver
            Class.forName("oracle.jdbc.OracleDriver");

            // الاتصال بقاعدة البيانات
            Connection connection = DriverManager.getConnection(url, user, password);

            // استعلام لإضافة الدورة
            String query = "INSERT INTO courses (course_id, course_name, department, credit_hours) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, courseId);
            statement.setString(2, courseName);
            statement.setString(3, department);
            statement.setInt(4, creditHours);

            // تنفيذ الاستعلام
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("searchCourses.jsp"); // إعادة التوجيه إلى صفحة البحث بعد الإضافة
            } else {
                response.getWriter().println("فشل في إضافة الدورة!"); // طباعة رسالة إذا فشل الإدخال
            }

            // إغلاق الاتصال
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // طباعة تفاصيل الخطأ في وحدة التحكم
            response.getWriter().println("حدث خطأ أثناء إضافة الدورة: " + e.getMessage());
        }
    }
}
