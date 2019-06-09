

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManejadorForm
 */
@WebServlet("/ManejoDeFormulariosHTML/ManejadorForm")
public class ManejadorForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManejadorForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombreInput");
        String password = request.getParameter("passwordInput");
        String sexo = request.getParameter("genero");
        String[] programacion = request.getParameterValues("tecnologia");
        String ocupacion = request.getParameter("ocupacion");
        String[] genero = request.getParameterValues("musicaSelec");
        String comentario = request.getParameter("comentarios");

        System.out.println("<html>");
        System.out.println("<head>");
        System.out.println("<title>Resultado Servlet</title>");
        System.out.println("</head>");
        System.out.println("<body>");
        System.out.println("<h1>Parametros procesados por el Servlet:</h1>");
        System.out.println("<body>");
        System.out.println("</html>");
	}

}
