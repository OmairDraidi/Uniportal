<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" type="text/css" href="header.css"> 
    <link rel="stylesheet" type="text/css" href="footer.css">
    <link rel="stylesheet" type="text/css" href="about.css"> 

</head>
<body>

 <!-- Include Header -->
    <jsp:include page="header.jsp" />


<main>
    <h2>Welcome to Our Educational Platform</h2>
    <p>This platform is dedicated to helping students manage and explore courses effectively.</p>
    <p>Our mission is to provide seamless access to educational tools and resources.</p>

    <!-- Team Members Section -->
    <div class="team">
        <h3>Project Team</h3>
        <ul>
            <li>Omair Draidi </li>
            <li>Shahd Mohammad Orr </li>
        </ul>
    </div>

    <!-- Instructor Section -->
    <div class="instructor">
        <h3>Course Instructor</h3>
        <p>Dr. Osama Hamed</p>
        <p><em>Professor of Computer Engineering</em></p>
    </div>
    
    
</main>
<!-- Include Footer -->
<jsp:include page="footer.jsp" />

</body>
</html>
