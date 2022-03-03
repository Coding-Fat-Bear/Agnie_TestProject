<%-- 
    Document   : EmailPO
    Created on : Feb 25, 2022, 12:02:15 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase Order Page</title>
    </head>
    <body>
        <h2> Send E-mail</h2>

<form action="mailto:mahesh.k@agnieindia.com" method="post" enctype="text/plain">
Name:<br>
<input type="text" name="name"><br>
Comment:<br>
<input type="text" name="comment" size="50"><br><br>
<input type="submit" value="Send">
<input type="reset" value="Reset">
</form>
    </body>
</html>
