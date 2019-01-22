<%-- 
    Document   : alcanceVariables
    Created on : Apr 21, 2018, 6:13:23 PM
    Author     : Jefry Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance de Variables</title>
    </head>
    <body>
        <h1>Alcance de variables</h1>
        <br>
        Variable request:
        base: ${rectanguloRequest.base}
        Altura:${rectanguloRequest.altura}
        Area:${rectanguloRequest.area}
        <br><br>
        Variable session:
        base: ${rectanguloSession.base}
        Altura:${rectanguloSession.altura}
        Area:${rectanguloSession.area}
        <br><br>
        Variable Aplicacion
        base: ${rectanguloAplication.base}
        Altura:${rectanguloAplication.altura}
        Area:${rectanguloAplication.area}
         <br><br>
        <a href="${pageContext.request.contextPath}">
            Regresar al inicio
        </a>
    </body>
</html>
