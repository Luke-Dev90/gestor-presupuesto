package web;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.OperacionesDao;
import datos.UsuarioDao;
import dominio.Operaciones;
import dominio.Usuario;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		
		String accion = request.getParameter("accion");
		if(accion !=null) {
			switch (accion) {
			case "inicio":
				this.inicio(request, response);
				break;
			case "Obtenerlistado":
				this.listadoGeneral(request, response);
				break;
			case "eliminar":
				this.eliminarOperacion(request,response);
			break;
			case "editar":
				this.editarOperacion(request, response);
				break;
			case "cerrar":
				this.inicio(request, response);
			break;
			}
		}
	
	}
	
	private void eliminarOperacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idOperacion = Integer.parseInt(request.getParameter("idOperacion"));
		Operaciones operacion = new Operaciones(idOperacion);
		
		int registrosModificados = new OperacionesDao().Eliminar(operacion);
		System.out.println("Registros modificados: " + registrosModificados);
		this.accionDefault(request, response);
	}

	private void editarOperacion(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		int idOperacion = Integer.parseInt(request.getParameter("idOperacion"));

		Operaciones operacion = new OperacionesDao().encontrar(new Operaciones(idOperacion));
		
		request.setAttribute("operaciones", operacion);
		
		String path = "/WEB-INF/paginas/ventas/editarOperacion.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException,IOException
		{
		
		String accion = request.getParameter("accion");
		if(accion !=null) {
			switch (accion) {
			case "inicio":
				this.inicio(request, response);
				break;
				
			case "newUser":
					this.newUser(request, response);
				break;
				
			case "loginUser":
					this.loginUser(request, response);
				break;
				
			
			case "insertar":
					this.insertarOperacion(request, response);
				break;
			
			case "modificar":
					this.modificarOperacion(request,response);
				break;
			
			
			default:
					
				break;
			}
			
		}
		
	}
	
	private void modificarOperacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idOperacion = Integer.parseInt(request.getParameter("idOperacion"));
		
		Operaciones operacionFecha = new OperacionesDao().encontrar(new Operaciones(idOperacion));
		
		String concepto = request.getParameter("concepto");
		double monto = 0;
		String montoStr = request.getParameter("monto");
		
		if(montoStr !=null && !"".equals(montoStr)) {
			monto = Double.parseDouble(montoStr);
		}
		
		Date fecha = operacionFecha.getFecha();
		
		
		String tipo = request.getParameter("tipo");
		
		if(tipo.equals("mantener")) {
			tipo = operacionFecha.getTipo();
		}
		
		Operaciones operacion = new Operaciones(idOperacion,concepto,monto,fecha,tipo);
		
		int registroModificado = new OperacionesDao().Actualizar(operacion);
		
		System.out.println("Registros modificados: " + registroModificado);
		
		this.listadoGeneral(request, response);
	}

	private void insertarOperacion(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		
		String concepto = request.getParameter("concepto");
		double monto = 0; 
		String montoStr = request.getParameter("monto");
		
		if(montoStr !=null && !"".equals(montoStr)){
			monto = Double.parseDouble(montoStr);
		}
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		String tipo = request.getParameter("tipo");
		
		Operaciones operacion = new Operaciones(concepto,monto,sqlDate,tipo);
		
		int operacionesInser = new OperacionesDao().insertar(operacion);
		
		System.out.println("operacion nueva" + operacionesInser);
		
		this.accionDefault(request, response);
	}
	
	
	private void listadoGeneral(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		List<Operaciones> listado = null;
		HttpSession sesion = request.getSession();
		String accion2 = request.getParameter("accion2");
		Operaciones operacion = null;
		if(accion2!=null) {
			switch (accion2) {
			case "general":
				listado = new OperacionesDao().listar();
				break;
			case "ingresos":
				listado = new OperacionesDao().tipoOperacion("ingresos");
				break;
			case "egresos":
				listado = new OperacionesDao().tipoOperacion("egresos");
				break;
			default:
				
				break;
			}
			
		}
		
		
			sesion.setAttribute("listado", listado);
			sesion.setAttribute("saldoTotal", this.saldoTotal());
			response.sendRedirect("gestorPresupuesto.jsp");
		}
		


	
	public double saldoTotal() {
		List<Operaciones> listado = new OperacionesDao().listar();
		List<Operaciones> listaEgresos = new OperacionesDao().tipoOperacion("egresos");
		double subTotal = 0;
		double egresos = 0;
		double total = 0;
		for (Operaciones operaciones : listado) {
			subTotal += operaciones.getMonto();
		}
		
		for(Operaciones Egresos : listaEgresos) {
			egresos += Egresos.getMonto();
		}
		total = subTotal - egresos;
		
		return total;
	}

	private void newUser(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		
		String email = request.getParameter("emailNew");
		String password = request.getParameter("passNew");
		
		Usuario nuevoUsuario = new Usuario(email,password);
		Usuario buscadoUsuario = null;
		
		if(nuevoUsuario!=null) {
			try {
				buscadoUsuario = new UsuarioDao().encontrar(nuevoUsuario);
				
				System.err.print("Usuario existente");
				if(buscadoUsuario.getEmail().equals(nuevoUsuario.getEmail())) {
					String path = "/WEB-INF/paginas/comunes/errorUsuarioExistente.jsp";
					request.getRequestDispatcher(path).forward(request, response);	
				}
				
			}catch(Exception e) {
				
				UsuarioDao.newUser(nuevoUsuario);
				System.out.print("Usuario registrado correctamente");
				
				String path = "/WEB-INF/paginas/comunes/UsuarioCorrecto.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				/*
				
				String path = "/WEB-INF/paginas/comunes/UsuarioCorrecto.jsp";
				request.getRequestDispatcher(path).forward(request, response);*/
				
				e.printStackTrace();
			}		
		}
	}
	
	private void loginUser(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{

		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		Usuario loginUser = new Usuario(email,password);
		Usuario buscado = null;
		
		if(loginUser!=null) {
			try {
				buscado = new UsuarioDao().encontrar(loginUser);
				
				if(buscado.getEmail().equals(loginUser.getEmail()) && buscado.getPassword().equals(loginUser.getPassword())) {
				
				String path = "gestorPresupuesto.jsp";
				request.getRequestDispatcher(path).forward(request, response);	
				
				HttpSession sesiona = request.getSession();
				sesiona.setAttribute("loginUser", loginUser);
				}else {
					String path3 = "/WEB-INF/paginas/comunes/errorUsuarioInvalido.jsp";
					request.getRequestDispatcher(path3).forward(request, response);
				}
			}catch(Exception e) {
				String path2 = "/WEB-INF/paginas/comunes/errorUsuarioInvalido.jsp";
				request.getRequestDispatcher(path2).forward(request, response);
				e.printStackTrace();
			}		
		}
	}
	
	private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		String path = "gestorPresupuesto.jsp";
		request.getRequestDispatcher(path).forward(request, response);	
	}
	
	private void inicio(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		String path = "presupuesto.jsp";
		request.getRequestDispatcher(path).forward(request, response);	
	}

}
