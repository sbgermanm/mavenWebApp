<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../layout/taglibs.jsp" %>

<form:form commandName="bindUserObject" cssClass="form-horizontal registrationForm" >
    
    <c:if test="${param.success eq true}">
        <div class="alert alert-success" >Usuario registrado correctamente</div>
    </c:if>
          
    
    
    <div class="form-group">
        <label for="nombre" class="col-sm-2 control-label">Nombre:</label>
        <div class="col-sm-10">
            <form:input path="name" cssClass="form-control" />
            <form:errors path="name" />
        </div>
    </div>
    <div class="form-group">
        <label for="Email" class="col-sm-2 control-label">Email:</label>
        <div class="col-sm-10">
            <form:input path="email" cssClass="form-control" />
            <form:errors path="email" />
        </div>
    </div>
    <div class="form-group">
        <label for="Contraseña" class="col-sm-2 control-label">Contraseña:</label>
        <div class="col-sm-10">
            <form:input path="password" cssClass="form-control" />
            <form:errors path="password" />
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" value="Save" class="btn btn-lg btn-primary" />
        </div>
    </div>
</form:form>