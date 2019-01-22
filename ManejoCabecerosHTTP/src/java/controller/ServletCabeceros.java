/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jefry Gutierrez
 */
@WebServlet(name = "ServletCabeceros", urlPatterns = {"/ServletCabeceros"})
public class ServletCabeceros extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String metodoHttp = request.getMethod();
            String uri = request.getRequestURI();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Headers HTTP</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Metodo Http: " + metodoHttp);
            out.println("<br>");
            out.println("URI solicitado: " + uri);
            out.println("<br>");
            out.println("Navegador: " + request.getHeader("User-Agent")); 
            out.println("<br>");

            Enumeration cabeceros = request.getHeaderNames();
            while (cabeceros.hasMoreElements()) {
                String nextElement = (String) cabeceros.nextElement();
                out.println("<br>");
                out.println("Cabecero HTTP solicitado: " + request.getHeader(nextElement));
                out.println("<br>");
            }

            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            out.close();
        }

    }

}
