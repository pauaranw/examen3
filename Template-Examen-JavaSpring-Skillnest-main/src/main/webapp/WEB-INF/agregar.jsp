<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Agregar nueva pintura</title>
        <link rel="stylesheet" href="/css/styles.css" />
    </head>
    <body>

<header>
    <h1>Pinturas</h1>
    <nav>
        <ul>
            <li><a href="/compras">Mis compras</a></li>
            <li><a href="/pinturas">Pinturas</a></li>
            <li><a href="/form/add">Agregar pintura</a></li>
            <li><a href="/logout" class="logout">Logout</a></li>
        </ul>
    </nav>
</header>


<h2 class="titulo-form">Agregar nueva pintura</h2>

<div class="form-container1">
    <form:form action="/add" method="POST" modelAttribute="pintura">

        <div class="campo">
            <form:label path="titulo">Título</form:label>
            <form:input path="titulo" />
            <form:errors path="titulo" class="error" />
        </div>

        <div class="campo">
            <form:label path="anio">Año</form:label>
            <form:input path="anio" />
            <form:errors path="anio" class="error" />
        </div>

        <div class="campo">
            <form:label path="descripcion">Descripción</form:label>
            <form:input path="descripcion" />
            <form:errors path="descripcion" class="error" />
        </div>

        <div class="campo">
            <form:label path="url">URL imagen</form:label>
            <form:input path="url" />
            <form:errors path="url" class="error" />
        </div>

        <div class="campo">
            <form:label path="cantidad">Cantidad</form:label>
            <form:input path="cantidad" type= "number" min="1"/>
            <form:errors path="cantidad" class="error" />
        </div>

        <div class="campo">
            <form:label path="precio">Precio</form:label>
            <form:input path="precio" />
            <form:errors path="precio" class="error" />
        </div>

        <input type="hidden" name="creador" value="${idUsuario}" />

        <button type="submit" class="btn-agregar">Agregar</button>

    </form:form>
</div>
    </body>
</html>