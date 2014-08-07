<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="redist/bootstrap-3.2.0-dist/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="redist/bootstrap-3.2.0-dist/css/bootstrap-theme.min.css">

        <script src="redist/jquery/2.1.1/jquery-2.1.1.js"></script>

        <!-- Latest compiled and minified JavaScript -->
        <script src="redist/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>

        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title" /></title>
    </head>
    <body>
        <div class="container">

            <!-- Static navbar -->
            <div class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href='<spring:url value="/" />'>Sebas JBA mavenWebApp</a>
                    </div>
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href='<spring:url value="/" />'>Home</a></li>
                            <li><a href='<spring:url value="/users.html" />'>Usuarios</a></li>
                            <li><a href="#">Link</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </div>

            <tiles:insertAttribute name="body" />

            <br><br>

            <center>
                <tiles:insertAttribute name="footer" />
            </center>
        </div>
    </body>
</html>