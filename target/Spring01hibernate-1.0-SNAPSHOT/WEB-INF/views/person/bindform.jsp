<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person form with binding</title>
</head>
<body>
<form:form method="post" modelAttribute="person">
    <p>
        <label for="login">Login: </label>
        <form:input path="login"/>
    </p>
    <p>
    <label for="password">Password: </label>
    <form:password path="password"/>
    </p>
       <p>
           <label for="email">Email: </label>
           <form:input path="email"  type="email"/>
       </p>
        <input type="submit"/>
</form:form>
</body>
</html>
