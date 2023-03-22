<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Login</title>
        </head>

        <body>
            <h2><b><i>Hello! Greetings from Maheesha!!!</i></b></h2>
            <form action="LoginServlet" method="post">
                <fieldset>
                    <legend>Servlet Login</legend>
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name"><br><br>
                    <label for="password">Password:</label>
                    <input type="password" name="password" id="password"><br><br>
                    <input type="submit" value="Log In">
                </fieldset>
                
                <br>
                ${invalid}
                ${profile}
                ${logout}
            </form>
        </body>

        </html>