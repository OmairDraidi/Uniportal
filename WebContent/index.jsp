<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>University Portal</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="index.css">
    
</head>
<body>
    <!-- Include Header -->
    <jsp:include page="header.jsp" />

    <div class="container">
        <h1>Welcome to the University Portal</h1>
        <p>Select one of the options below:</p>
        
        <!-- Search Button -->
        <button onclick="goToPage('searchCourses.jsp')">Search for Courses</button>
        
        <!-- Add Course Button -->
        <button onclick="goToPage('addCourse.jsp')">Add New Course</button>
    </div>

    <!-- Include Footer -->
    <jsp:include page="footer.jsp" />

    <script>
        function goToPage(page) {
            window.location.href = page;
        }
    </script>
</body>
</html>
