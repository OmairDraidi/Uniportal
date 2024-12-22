<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="servlets.Course" %>

<html>
<head>
 	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Courses</title>
    
    <link rel="stylesheet" type="text/css" href="style.css"> 
    <link rel="stylesheet" type="text/css" href="header.css"> 
    <link rel="stylesheet" type="text/css" href="footer.css">
    <link rel="stylesheet" type="text/css" href="showCourse.css"> 
</head>
<body>

<jsp:include page="header.jsp" />
    <h2>Show Courses</h2>

    <table>
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Department</th>
        <th>Credit Hours</th>
    </tr>
    <% 
                List<Course> courses = (List<Course>) request.getAttribute("courses");
                if (courses != null && !courses.isEmpty()) {
                    for (Course course : courses) {
            %>
                <tr>
                    <td><%= course.getCourseId() %></td>
                    <td><%= course.getCourseName() %></td>
                    <td><%= course.getDepartment() %></td>
                    <td><%= course.getCreditHours() %></td>
                </tr>
            <% 
                    }
                } else {
            %>
                <tr>
                    <td colspan="4">No results found</td>
                </tr>
            <% } %>
</table>


<div class="center">	
 <button onclick="goToPage('searchCourses.jsp')">Back</button>
</div>
<jsp:include page="footer.jsp" />

    <script>
        function goToPage(page) {
            window.location.href = page;
        }
    </script>
</body>
</html>
