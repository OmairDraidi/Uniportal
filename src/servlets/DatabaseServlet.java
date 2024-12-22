package servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // بيانات الاتصال بقاعدة البيانات
        String url = "jdbc:oracle:thin:@localhost:1521:FREE"; // تعديل هذا حسب إعداداتك
        String user = "sys as sysdba"; // اسم المستخدم
        String password = "root"; // كلمة المرور

        try {
            // تحميل Driver
            Class.forName("oracle.jdbc.OracleDriver");

            // الاتصال بقاعدة البيانات
            Connection connection = DriverManager.getConnection(url, user, password);

            // تنفيذ استعلام SQL
            String query = "SELECT * FROM students"; // استعلام SQL
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // عرض النتائج في HTML
            out.println("<html><body>");
            while (resultSet.next()) {
                out.println("<p>Student ID: " + resultSet.getInt("student_id") + "</p>");
                out.println("<p>Student Name: " + resultSet.getString("student_name") + "</p>");
            }
            out.println("</body></html>");

            // إغلاق الاتصال
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
