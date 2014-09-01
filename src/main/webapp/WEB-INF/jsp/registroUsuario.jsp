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
            <form:password path="password" cssClass="form-control" />
            <form:errors path="password" />
        </div>
    </div>
    <div class="form-group">
        <label for="Repetir Contraseña" class="col-sm-2 control-label">Repetir Contraseña:</label>
        <div class="col-sm-10">
            <input type="password" name="password_again" class="form-control"/> 
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" value="Save" class="btn btn-lg btn-primary" />
        </div>
    </div>
</form:form>

<script type="text/javascript">
    $(document).ready(function(){
        $(".registrationForm").validate(
                {
                    rules:{
                        name:{
                            required : true,
                            minlength : 3,
                            remote : {
                                    url: "<spring:url value='/register/available.html' />",
                                    type: "get",
                                    data: {
                                            nombreUsuario: function() {
                                                    return $("#name").val();
                                            }
                                    }
                            }
			},
                        email:{
                            required : true,
                            email : true
                        },
                        password:{
                            required : true,
                            minlength : 5
                        },
                        password_again:{
                            required : true,
                            minlength : 5,
                            equalTo: "#password"
                        }
                    },
                    highlight: function (element){
                        $(element).closest(".form-group").removeClass("has-success").addClass("has-error");
                    },
                    unhighlight: function (element){
                        $(element).closest(".form-group").removeClass("has-error").addClass("has-success");
                    }
                }
                );
    });
</script>
