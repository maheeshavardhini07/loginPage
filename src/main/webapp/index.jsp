<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Index</title>
        </head>

        <body>
            <h1>Servlet Login</h1>
            <a href="login.jsp">Login</a>
            <a href="LogoutServlet">Logout</a>
            <a href="ProfileServlet">Profile</a>
            ${invalid}
            ${profile}
            ${logout}
        </body>

        </html>