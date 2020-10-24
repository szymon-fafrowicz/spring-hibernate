<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book edit-form</title>
</head>
<body>
<div>Edit book form:</div>
<form:form method="post" modelAttribute="book">
    <p>
        <label for="title"> Title</label>
        <form:input maxlength="100" path="title"/>
        <form:errors path="title"/>
    </p>
    <p>
        <label for="rating"> Rating</label>
        <form:input path="rating" type="number" min="0" max="10" step="1"/>
        <form:errors path="rating"/>
    </p>
    <p>
        <label for="description"> Description</label>
        <form:textarea path="description"/>
        <form:errors path="description"/>
    </p>
    <p>
        <label for="publisher"> Publisher</label>
        <form:select path="publisher" id="publisher">
            <form:options items="${publishers}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="publisher"/>
    </p>
    <p>
        <label for="authors"> Authors: </label>
        <form:checkboxes path="authors" items="${authors}" itemLabel="lastName" itemValue="id"/>
        <form:errors path="author"/>
    </p>
    <p>
        <label for="pages"> Pages</label>
        <form:input path="pages" type="number" min="0" step="1"/>
        <form:errors path="pages"/>
    </p>
    <div>
        <input type="submit">
    </div>
</form:form>
</body>
</html>
