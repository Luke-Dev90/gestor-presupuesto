package datos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Usuario;

public interface Iusuario {

	public Usuario encontrar(Usuario encontrar) ;


	public int newUser(Usuario usuario) ;
}
