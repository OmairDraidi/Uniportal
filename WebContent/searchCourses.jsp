<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Courses</title>
    <link rel="stylesheet" type="text/css" href="style.css"> 
    <link rel="stylesheet" type="text/css" href="header.css"> 
    <link rel="stylesheet" type="text/css" href="footer.css">
    <link rel="stylesheet" type="text/css" href="searchCourse.css"> 
</head>
<body>
   <!-- Include Header -->
    <jsp:include page="header.jsp" />

    <div class="main-content">
        <h2>Search for Courses</h2>
        <form action="searchCourses" method="get">
            <label for="courseName">Course Name:</label>
            <input type="text" id="courseName" name="courseName" placeholder="Enter course name" required><br><br>

            <label for="department">Department:</label>
            <input type="text" id="department" name="department" placeholder="Enter department" required><br><br>

            <button type="submit">Search</button>
        </form>
    </div>

    <jsp:include page="footer.jsp" />


</body>
</html>
