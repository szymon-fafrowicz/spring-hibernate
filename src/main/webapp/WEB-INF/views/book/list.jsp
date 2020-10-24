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
        <th>Title</th>
        <th>Description</th>
        <th>Rating</th>
        <th>Publisher</th>
        <th>Authors</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${books}" var="author" varStatus="stat">
        <tr>
            <td>${stat.count}</td>
            <td>${author.title}</td>
            <td>${author.description}</td>
            <td>${author.rating}</td>
            <td>${author.publisher.name}</td>
            <td><c:forEach items="${author.authors}" var="author">
                ${author.firstName} ${author.lastName},
            </c:forEach>
            </td>
            <td><a href="http://localhost:8080/bookform/delete/${author.id}">Delete</a>
                <a href="http://localhost:8080/bookform/edit/${author.id}">Edit</a></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
