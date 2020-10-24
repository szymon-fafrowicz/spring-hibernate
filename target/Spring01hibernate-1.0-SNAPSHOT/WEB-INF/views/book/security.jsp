<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warning</title>
</head>
<body>
Are you sure you  want to delete book "${book.title}"?
<form method="post">
    <input type="submit" name="decision" value="yes"/>
    <input type="submit" name="decision" value="no"/>
</form>
</body>
</html>
