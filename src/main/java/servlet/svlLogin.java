package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.function.IntToDoubleFunction;

import bean.cuentaLogin;

/**
 * Servlet implementation class svlLogin
 */
public class svlLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svlLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		dao.LoginDAO daoLogin = new dao.LoginDAO();
		
		String id = request.getParameter("id");
		String userName = request.getParameter("username");
		String pass = request.getParameter("pass");
		
		/*Nuevo Usuario*/
		String nombre = request.getParameter("newUserName");
		String email = request.getParameter("newUserEmail");
		String userNew = request.getParameter("newUser");
		String passwordNew = request.getParameter("newPass");
		
		/*Cambio de clave*/
		String emailUpdate = request.getParameter("emailUser");
		String passwordUpdate = request.getParameter("newPass");
		
		if(id == null) {
			String[] usuario = daoLogin.getUsuario(userName);
			if(usuario != null) {
				if(usuario[4].equals(pass)) {
					id = "Logueado";
					session.setAttribute("id", id);
					session.setAttribute("user", usuario);
					response.sendRedirect("Inicio.jsp");
				}else {
					id = "ClaveErronea";
					session.setAttribute("id", id);
					session.setAttribute("user", usuario);
					response.sendRedirect("Inicio.jsp");
					
				}
				
			}
		}else if(id.equals("login")) {
			response.sendRedirect("login.jsp");
		}else if(id.equals("crearCuenta")) {
			response.sendRedirect("crearCuenta.jsp");
			
		}else if(id.equals("nuevoUser")) {
			String[] userExiste = daoLogin.validaUser(email);
			if(userExiste == null) {
				int userCreate = daoLogin.createUser(nombre, email, userNew, passwordNew);
				if(userCreate == 1) {
					id = "UsuarioCreado";
					session.setAttribute("id", id);
					response.sendRedirect("Inicio.jsp");
				}
			}else {
				id = "UsuarioEnBD";
				session.setAttribute("id", id);
				session.setAttribute("user", userExiste);
				response.sendRedirect("Inicio.jsp");
			}
			
		}else if(id.equals("cambiarContraseña")) {
			response.sendRedirect("cambioPass.jsp");
			
		}else if(id.equals("newPassword")) {
			String[] userExiste = daoLogin.validaUser(emailUpdate);
			if(userExiste != null) {
				int idUser = Integer.parseInt(userExiste[0]);
				int updatePass = daoLogin.updatePassword(idUser, passwordUpdate);
				if(updatePass == 1) {
					id = "ClaveActualizada";
					session.setAttribute("user", userExiste);
					session.setAttribute("id", id);
					response.sendRedirect("Inicio.jsp");
				}
				
			}else {
				id = "CorreoNoExiste";
				session.setAttribute("id", id);
				response.sendRedirect("Inicio.jsp");
			}
			
		}
		
		
		
		
		
		
		
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
