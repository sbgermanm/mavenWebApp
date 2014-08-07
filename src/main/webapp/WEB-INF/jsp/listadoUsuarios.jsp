<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <th>Nombre de Usuario</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach  items="${listaDeUsuarios}" var="usuario">
            <tr>
                <td>
                    ${usuario.name}
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>