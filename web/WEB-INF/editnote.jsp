<%-- 
    Document   : editnote
    Created on : Sep 29, 2020, 10:54:45 AM
    Author     : 831690
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="note">
        Title: <input name="editTitle" value="${editTitle}">
        <br>
        Contents: <textarea name="editContents" style="width: 200px; height: 150px;">${editContents}</textarea><br>
        <input type="submit" name="save" value="Save">
        </form>
    </body>
</html>
