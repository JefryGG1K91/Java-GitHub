<%-- 
    Document   : desplegarVariables
    Created on : Apr 17, 2018, 7:54:08 PM
    Author     : Jefry Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Desplegar variables</h1>
        Variable en alcance request:
        ${mensaje}
        <br>
        <br>
        Variable en alcance session:
        <br>
        Rectangulo:
        Base:${rectangulo.base}
        Altura:${rectangulo.altura}
        Area:${rectangulo.area}
    </body>
</html>
