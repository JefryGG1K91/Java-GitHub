<%-- 
    Document   : index
    Created on : Apr 17, 2018, 7:53:09 PM
    Author     : Jefry Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:p="http://primefaces.org/ui">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
    </head>
    <body>
        <h1>Ejemplo MVC1</h1>
        
        <div style="color:red"> ${mensaje} </div>

        <a href="${pageContext.request.contextPath}/ServletControlador">
            Link al servlet controlador sin parametros
        </a>
        <br><br>
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregarVariables">
                    Link al servlet controlador para agregar variables
                </a>
                <br><br>
                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
                            Link al servlet controlador para agregar variables
                        </a>
                        <br><br>
                                </body>
                                </html>
