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
        <h1>Ejemplo</h1>

        <a href="${pageContext.request.contextPath}/ServletController">
            Web Application Context Path = ${pageContext.request.contextPath}
        </a>


    </body>
</html>
