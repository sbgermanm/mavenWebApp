<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/taglibs.jsp" %>

<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <th>Nombre de Usuario</th>
            <th>Operaciones</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach  items="${listaDeUsuarios}" var="usuario">
            <tr>
                <td>
                    <a href=" <spring:url value="/users/${usuario.id}.html" />"> ${usuario.name}</a>
                </td>
                <td>
                    <a href=" <spring:url value="/users/borrar/${usuario.id}.html" />" class="btn btn-danger">Borrar usuario   </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>