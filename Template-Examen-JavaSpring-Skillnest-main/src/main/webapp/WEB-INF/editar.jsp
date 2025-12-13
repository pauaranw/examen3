<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="True"%> 


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Editar pintura</title>
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


        <h2 class="titulo-form">Editar pintura</h2>

        <div class="form-container1">
            <form:form action="/edit" method="POST" modelAttribute="pintura">
                <input type="hidden" name="_method" value="PUT"/>

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
                <input type="hidden" name="id" value="${pintura.id}" />

                <input type="submit" value="Editar" />

            </form:form>
            <c:if test="${pintura.creador.id == idUsuario}">
                <form:form action="/delete/${pintura.id}" method="POST">
                    <input type="hidden" name="_method" value="DELETE"/>
                    <button>Eliminar</button>
                </form:form>             
            </c:if>
        </div>
    </body>
</html>