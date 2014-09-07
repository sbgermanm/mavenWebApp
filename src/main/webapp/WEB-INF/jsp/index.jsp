<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../layout/taglibs.jsp" %>

<h1>Lastest new from the world of java....</h1>
<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <th>Fecha</th>
            <th>Articulos</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="articulo">
        <tr>
            <td>
                <c:out value="${articulo.publishDate}" />
                <br/>
                <strong><em><c:out value="${articulo.blog.name}" /></em></strong>
            </td>
        <td>
            <strong><a href="<c:out value="${articulo.link}" />" target="_blank"><c:out value="${articulo.title}" /></a></strong>
            <br/>
            ${articulo.descripcion}
        </td>
        </tr>
    </c:forEach>
</tbody>
</table>


