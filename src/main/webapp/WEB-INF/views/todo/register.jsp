<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2024-10-11
  Time: 오후 4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Test</h2>
    <form action="/todo/register" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>

        <label for="dueDate">Due Date:</label>
        <input type="date" id="dueDate" name="dueDate" required>

        <label for="writer">Writer:</label>
        <input type="text" id="writer" name="writer" required>

        <button type="submit">Submit</button>
    </form>
</body>
</html>
