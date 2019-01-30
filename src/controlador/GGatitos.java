package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Gatitos;
/**
 * Servlet implementation class GGatitos
 */
@WebServlet("/GGatitos")
public class GGatitos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GGatitos() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    protected void inicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		switch (request.getParameter("opcion")) {
		case "1":
			nuevoGato(request, response);
			break;
		case "2":
			borrarGato(request, response);
			break;
		case "3":
			buscarGato(request, response);
			break;
		default:
			System.out.println("Opcion no valida");
		}

	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/htmlUTF-8");
		this.inicio(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.inicio(request, response);
	}
	
	private void nuevoGato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String foto = request.getParameter("foto");

		Gatitos gatitos = new Gatitos(nombre, raza, edad, foto);
		if(request.getParameter("id") != "") {
			int id = Integer.parseInt(request.getParameter("id"));
			gatitos.setId(id);
			gatitos.actualizar();
		} else
			gatitos.insertar();

		response.sendRedirect("index.jsp");
	}
	
	private void borrarGato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gatitos gato = new Gatitos();
		gato.buscarID(Integer.parseInt(request.getParameter("id")));
		gato.borrar();
		response.sendRedirect("index.jsp");
	}
	
	private void buscarGato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id;

		if (Integer.parseInt(request.getParameter("id")) != 0) {
			id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			request.setAttribute("id", id);
			RequestDispatcher vista = request.getRequestDispatcher("formularioGatitos.jsp");
			vista.forward(request, response);
		} else {
			request.setAttribute("id", null);
			RequestDispatcher vista = request.getRequestDispatcher("formularioGatitos.jsp");
			vista.forward(request, response);
		}

	}

}
