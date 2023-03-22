<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>Link</title>
        </head>

        <body>
            <div>
                <a href="login.jsp">Login</a>
                <a href="LogoutServlet">Logout</a>
                <a href="ProfileServlet">Profile</a>
            </div>
            <br>
            ${invalid}
            ${profile}
            ${logout}

        </body>

        </html>