<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <p>
        <label for="firstName"> First name: </label>
        <form:input maxlength="20" path="firstName"/>
        <form:errors path="firstName"/>
    </p>
    <p>
        <label for="lastName"> Last name: </label>
        <form:input maxlength="20" path="lastName"/>
        <form:errors path="lastName"/>
    </p>
    <p>
        <label for="books"> Books: </label>
        <form:checkboxes path="books" items="${books}" itemLabel="title" itemValue="id"/>
        <form:errors path="books"/>
    </p>
    <p>
        <label for="pesel">Pesel: </label>
        <form:input path="pesel"/>
        <form:errors path="pesel"/>
    </p>
    <p>
        <label for="email">Email: </label>
        <form:input path="email"/>
        <form:errors path="email"/>
    </p>
    <div><form:errors path="*"/>
    </div>
    <p>
        <input type="submit">
    </p>
</form:form>

</body>
</html>
