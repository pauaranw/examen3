<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Login</title>
        <link rel="stylesheet" href="/css/styles.css" />
    </head>

    <body>
        <header>
            <h1>Pinturas</h1>
            <nav>
                <ul>
                    <li><a href="/">Login</a></li>
                    <li><a href="/form/registro">Registro</a></li>
                </ul>
            </nav>
        </header>
        
        <div class="form-container1">
            <h2>Login</h2>
            <form:form action="/login" method="POST" modelAttribute="loginUsuario">

                <form:label path="correo">Correo Electrónico:</form:label><br>
                <form:input path="correo" type="text" />
                <form:errors path="correo" class="error" /><br>

                <form:label path="password">Contraseña:</form:label><br>
                <form:input path="password" type="password" />
                <form:errors path="password" class="error" /><br>

                <input type="submit" value="Login" />
        </form:form>
        </div>
        
    </body>
</html>