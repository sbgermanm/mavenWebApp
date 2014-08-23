<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/taglibs.jsp" %>

<!-- Button trigger modal -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Añadir Blog
</button>

<!-- Modal -->
<form:form commandName="blogBindObject" cssClass="form-horizontal blogForm">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">Añadir Blog</h4>
                </div>
                <div class="modal-body">

                    <div class="form-group"> 
                        <label for="name" class="col-sm-2 control-label">Name:</label> 
                        <div class="col-sm-10"> 
                            <form:input path="name" cssClass="form-control" /> 
                        </div> 
                    </div> 
                    <div class="form-group"> 
                        <label for="name" class="col-sm-2 control-label">URL:</label> 
                        <div class="col-sm-10"> 
                            <form:input path="url" cssClass="form-control" /> 
                        </div> 
                    </div> 

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary" value="Save" />
                </div>
            </div>
        </div>
    </div>
</form:form>