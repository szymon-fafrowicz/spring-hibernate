<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student form</title>
</head>
<body>
<form:form method="post" modelAttribute="student">
    <p>First name: <form:input path="firstName"/></p>
    <p>Last name: <form:input path="lastName"/></p>
    <p>
    <p>Gender:
        Male: <form:radiobutton path="gender" value="M"/>
        Female: <form:radiobutton path="gender" value="F"/></p>
    <p>Country: <form:select path="country">
        <form:option value="-" label="Select your country"/>
        <form:options items="${countries}"/>
    </form:select></p>
    <p>Notes: <form:textarea path="notes"/></p>
    <div>Mailing list: <form:checkbox path="mailingList"/></div>
    <div>Programming skills: <form:select path="programmingSkills" items="${skills}" multiple="true"/>
    <p>Hobbies: <form:checkboxes path="hobbies" items="${hobbies}"/></p>
    <input type="submit">
</form:form>
</body>
</html>
