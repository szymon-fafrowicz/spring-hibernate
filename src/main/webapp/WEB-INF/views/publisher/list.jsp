<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of books</title>
</head>
<body>
Books:
<table border="1px">
    <tr>
        <th> Lp.</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Books</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${authors}" var="author" varStatus="stat">
        <tr>
            <td>${stat.count}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>

            <td><c:forEach items="${author.books}" var="book">
                ${book.title},
            </c:forEach>
            </td>
            <td><a href="http://localhost:8080/author/delete/${author.id}">Delete</a>
                <a href="http://localhost:8080/author/edit/${author.id}">Edit</a></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
