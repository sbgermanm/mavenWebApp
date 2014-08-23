<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../layout/taglibs.jsp" %>

<h1>${usuario.name}</h1>
<%@include file="detalleUsuario-addBlog.jsp" %>
<c:forEach items="${usuario.blogs}" var="blog">
    <h2>${blog.name}</h2>
    <p>${blog.url}</p>
    <table class="table table-bordered table-hover table-striped">
        <thead>
            <tr>
                <th>Title</th>
                <th>Link</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${blog.items}" var="articulo">
                <tr>
                    <td>${articulo.title}</td>
                    <td>${articulo.link}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:forEach>