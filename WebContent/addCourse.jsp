<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Course</title>
    <link rel="stylesheet" type="text/css" href="style.css"> 
    <link rel="stylesheet" type="text/css" href="header.css"> 
    <link rel="stylesheet" type="text/css" href="footer.css">
    <link rel="stylesheet" type="text/css" href="addCourse.css"> 
</head>
<body>
    <header>
        <div class="container">
            
            <jsp:include page="header.jsp" />

    <div class="main-content">
        <h2>Add New Course</h2>
        <form action="addCourse" method="post">
            <label for="courseId">Course ID:</label>
            <input type="text" id="courseId" name="courseId" required><br><br>

            <label for="courseName">Course Name:</label>
            <input type="text" id="courseName" name="courseName" required><br><br>

            <label for="department">Department:</label>
            <input type="text" id="department" name="department" required><br><br>

            <label for="creditHours">Credit Hours:</label>
            <input type="number" id="creditHours" name="creditHours" required><br><br>

            <button type="submit">Add</button>
        </form>
    </div>

    <jsp:include page="footer.jsp" />

    
</body>
</html>
