package servlets;


import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class SearchCoursesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseName = request.getParameter("courseName");
        String department = request.getParameter("department");

        // إعدادات الاتصال بقاعدة البيانات
        String url = "jdbc:oracle:thin:@localhost:1521:FREE";
        String user = "sys as sysdba";  // اسم المستخدم
        String password = "root";  // كلمة المرور

        List<Course> courses = new ArrayList<>();
        
        try {
            // تحميل Driver
            Class.forName("oracle.jdbc.OracleDriver");

            // الاتصال بقاعدة البيانات
            Connection connection = DriverManager.getConnection(url, user, password);

            // استعلام البحث
            String query = "SELECT * FROM courses WHERE course_name LIKE ? AND department LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + courseName + "%");
            statement.setString(2, "%" + department + "%");

            ResultSet resultSet = statement.executeQuery();

            // إضافة الدورات إلى القائمة
            while (resultSet.next()) {
                Course course = new Course(resultSet.getString("course_id"),
                                           resultSet.getString("course_name"),
                                           resultSet.getString("department"),
                                           resultSet.getInt("credit_hours"));
                courses.add(course);
            }

            // إرسال البيانات إلى صفحة JSP لعرض النتائج
            request.setAttribute("courses", courses);
            request.getRequestDispatcher("/showCourses.jsp").forward(request, response);

            // إغلاق الاتصال
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
