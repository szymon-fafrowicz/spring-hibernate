<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<form:form method="post" modelAttribute="publisher">
    <p>
        <label for="name"> Name: </label>
        <form:input path="name"/>
        <form:errors path="name"/>
    </p>
    <p>
        <label for="books"> Books: </label>
        <form:checkboxes path="books" items="${books}" itemLabel="title" itemValue="id"/>
        <form:errors path="books"/>
    </p>
    <p>
        <label for="nip">NIP: </label>
        <form:input path="nip"/>
        <form:errors path="nip"/>
    </p>
    <p>
        <label for="regon">REGON: </label>
        <form:input path="regon"/>
        <form:errors path="regon"/>
    </p>
    <div><form:errors path="*"/>
    </div>
    <p>
        <input type="submit">
    </p>
</form:form>

</body>
</html>
