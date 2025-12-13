<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pinturas</title>
    <link rel="stylesheet" href="/css/styles.css"/>
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

<section class="series-container1">
    <h2>${pintura.titulo}</h2>


        <div class="serie-card1">
            <img  src="${pintura.url}" alt="${pintura.titulo}"/>
            
            <div>
                <p>Autor <br><strong>${pintura.creador.nombre} ${pintura.creador.apellido}</strong> </p>
                <p>Descripción <br><strong>${pintura.descripcion}</strong> </p>
                <p>Precio <br><strong>$ ${pintura.precio}</strong> </p>
                <p>Cantidad en inventario <br><strong> ${pintura.cantidad}</strong> </p>
            </div>
        </div>
            <c:if test="${pintura.cantidad != 0}">       
                <a class="precio" href="/buy/${pintura.id}">Comprar</a>    
            </c:if> 
            <c:if test="${pintura.cantidad == 0}">
                <p>¡Agotado!</p>
            </c:if>
        
        <c:if test="${fn:length(pintura.compradores) > 0}">
            <h4>Usuarios que han comprado esta pintura:</h4>
            <ul>
                <c:forEach var="usuario" items="${pintura.compradores}">
                    <li>${usuario.nombre} ${usuario.apellido}</li>
                </c:forEach>
            </ul>
        </c:if>

</section>



</body>
</html>