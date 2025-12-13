<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<section class="welcome">
    <h2>Tus pinturas compradas</h2>
</section>

<section class="series-container">

    <c:forEach var="pintura" items="${pinturas}">
        <div class="serie-card">
            <a href="/detail/${pintura.id}"><img  src="${pintura.url}" alt="${pintura.titulo}"/></a>
            

            <div class="serie-info">
                <h3>${pintura.titulo}</h3>

                <p><strong>Autor:</strong> ${pintura.creador.nombre} ${pintura.creador.apellido}</p>
                <p><strong>Año:</strong> ${pintura.anio}</p>
                <p><strong>Precio:</strong> $ ${pintura.precio}</p>
            </div>

            <c:if test="${pintura.creador.id == idUsuario}">
                <div class="serie-actions">
                    <a href="/form/edit/${pintura.id}">&#9998</a>
                </div>
            </c:if>

        </div>
    </c:forEach>

</section>


</body>
</html>
