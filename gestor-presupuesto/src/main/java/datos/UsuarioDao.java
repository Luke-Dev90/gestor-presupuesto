package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Usuario;

public class UsuarioDao {

	private static final String SQL_SELECT_USER = "SELECT id_usuario, email,password FROM usuarios where email=?";
	private static final String SQL_INSERT_USER = "INSERT INTO usuarios (email,password) VALUES (?,?)";
	private static final String SQL_SELECT = "SELECT id_usuario, email,password from usuarios";
	
	

	
	public static int newUser(Usuario usuario) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT_USER);
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getPassword());
			
			rows = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally{
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		
		return rows;
	}
	
	
	public Usuario encontrar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuarioEcontrado = null;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_USER);
			stmt.setString(1, usuario.getEmail());
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int idUsuario = rs.getInt("id_usuario");
				String email = rs.getString("email"); 	
				String password= rs.getString("password");
				usuarioEcontrado = new Usuario(idUsuario,email,password);
			}
		
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		return usuarioEcontrado;
	}
	
	public static Usuario encontrarU(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario datoEncontrado = null;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_USER);
			stmt.setString(1,usuario.getEmail());
			
			rs = stmt.executeQuery();
			
			
			String email = rs.getString("email");
			String password = rs.getString("password");
				
			datoEncontrado = new Usuario(email,password);
			
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			Conexion.close(rs);
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		return datoEncontrado;
	}
	
	public List<Usuario>listar() 
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		List<Usuario> usuarios = new ArrayList<>();
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int idUsuario = rs.getInt("id_usuario");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				usuario = new Usuario(idUsuario,email,password);
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			Conexion.close(rs);
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		
		return null;
		
	}
}
