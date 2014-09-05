<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../layout/taglibs.jsp" %>

<h1><c:out value="${usuario.name}" /></h1>



<script type="text/javascript">
    $(document).ready(function() {
        $('.nav-tabs a:first').tab('show');
        $(".lanzarConfirmationDLG").click(function (e){
            e.preventDefault();
            $("#confirmationDLG .confirmationDLGOK").attr("href", $(this).attr("href"));
            $("#confirmationDLG #myModalLabel").html("Eliminar Blog");
            $("#confirmationDLG .modal-body").html("¿Desea eliminar Blog?");
            $("#confirmationDLG").modal();
        });
    });
</script>



<br /><br />
<!-- Nav tabs -->
<ul class="nav nav-tabs" role="tablist">
    <c:forEach items="${usuario.blogs}" var="blog">
        <li><a href="#blog_${blog.id}" role="tab" data-toggle="tab"><c:out value="${blog.name}"/></a></li>
        </c:forEach>
</ul>

<!-- Tab panes -->
<div class="tab-content">
    <c:forEach items="${usuario.blogs}" var="blog">
        <div class="tab-pane" id="blog_${blog.id}">
            <h1><c:out value="${blog.name}" /></h1>

            <a href="<spring:url value="/blog/remove/${blog.id}.html" />" class="btn btn-danger lanzarConfirmationDLG">Borrar blog</a>
            <br/><br/>
            <p><c:out value="${blog.url}" /></p>
            <table class="table table-bordered table-hover table-striped">
                <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Articulos</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${blog.items}" var="articulo">
                        <tr>
                            <td><c:out value="${articulo.publishDate}" /></td>
                            <td>
                                <strong><a href="<c:out value="${articulo.link}" />" target="_blank"><c:out value="${articulo.link}" /></a></strong>
                                ${articulo.descripcion}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>    
    </c:forEach>
</div>

<%@include file="confirmationDLG.jsp" %>