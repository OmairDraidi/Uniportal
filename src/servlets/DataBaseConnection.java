package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseConnection {
    public static void main(String[] args) {
        // بيانات الاتصال بقاعدة البيانات
        String url = "jdbc:oracle:thin:@localhost:1521:FREE";  // تأكد من استخدام SID الصحيح (مثل xe)
        String user = "sys as sysdba";  // اسم المستخدم الذي أنشأته
        String password = "root";  // كلمة المرور

        Connection connection = null;

        try {
            // تحميل الـ JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");

            // إنشاء الاتصال بقاعدة البيانات
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("تم الاتصال بقاعدة البيانات بنجاح!");

            // استعلام SQL لاستعراض البيانات
            String query = "SELECT * FROM courses";  // استعلام لعرض جميع الدورات
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // عرض النتائج
            System.out.println("بيانات الجدول Courses:");
            while (resultSet.next()) {
                System.out.println("Course ID: " + resultSet.getString("course_id") +
                                   ", Course Name: " + resultSet.getString("course_name") +
                                   ", Department: " + resultSet.getString("department") +
                                   ", Credit Hours: " + resultSet.getInt("credit_hours"));
            }

            // إغلاق الموارد
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("تم إغلاق الاتصال بقاعدة البيانات.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
