/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Rectangulo;
/**
 *
 * @author Jefry Gutierrez
 */
@WebServlet(name = "ServletController", urlPatterns ={"/ServletController"} )
public class ServletController extends HttpServlet{
    
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
       //2-se crea javaBean
      Rectangulo rec= new Rectangulo(3,6);
      //3-Agregamos las variables para el alcance 
      request.setAttribute("mensaje","saludos desde el servlet");
      
      HttpSession session=request.getSession();
      session.setAttribute("rectangulo",rec);
      //4-redireccionamos
      //se envia el objeto request y response para ser utilizados en el jsp
      RequestDispatcher rd=request.getRequestDispatcher("vista/desplegarVariables.jsp");
      rd.forward(request, response);
   }
}
