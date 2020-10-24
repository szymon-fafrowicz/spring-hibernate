<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Violations</title>
</head>
<body>
<c:forEach items="${violations}" var="v">
    ${v.propertyPath} : ${v.message}<br>
</c:forEach>
</body>
</html>
