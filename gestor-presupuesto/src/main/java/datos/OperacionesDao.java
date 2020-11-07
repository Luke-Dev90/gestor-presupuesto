package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Operaciones;

public class OperacionesDao 
{
	private static final String SQL_LISTAR = "SELECT id_operaciones, concepto,monto,fecha,tipo_operacion from operaciones";
	
	private static final String SQL_SELECT_TIPO = "SELECT id_operaciones, concepto,monto,fecha,tipo_operacion from operaciones where tipo_operacion=?";
	private static final String SQL_SELECT_ID = "SELECT id_operaciones, concepto,monto,fecha,tipo_operacion from operaciones where id_operaciones=?";
	
	private static final String SQL_SELECT_UPDATE = "UPDATE operaciones SET "
			+ "concepto=?,monto=?,fecha=?,tipo_operacion=? "
			+ "where id_operaciones=?";
	
	private static final String SQL_DELETE = "DELETE FROM operaciones where id_operaciones =?";
	
	private static final String SQL_INSERT = "INSERT INTO operaciones (concepto,monto,fecha,tipo_operacion) values (?,?,?,?)";
	
	public Operaciones encontrar(Operaciones operacion){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ID);
			stmt.setInt(1, operacion.getIdOperacion());
			rs = stmt.executeQuery();

			while(rs.next()) {
				String concepto = rs.getString("concepto");
				double monto = rs.getDouble("monto");
				Date fecha = rs.getDate("fecha");
				String tipo = rs.getString("tipo_operacion");
				
				operacion.setConcepto(concepto);
				operacion.setMonto(monto);
				operacion.setFecha(fecha);
				operacion.setTipo(tipo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			Conexion.close(rs);
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		return operacion;
	}
	
	public List<Operaciones> listar(){
			
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Operaciones operacion = null;
		List<Operaciones> operaciones = new ArrayList<>();
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_LISTAR);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int idOperaciones = rs.getInt("id_operaciones");
				String concepto = rs.getString("concepto");
				double monto = rs.getDouble("monto");
				Date fecha = rs.getDate("fecha");
				String tipo = rs.getString("tipo_operacion");
				
				operacion = new Operaciones(idOperaciones,concepto,monto,fecha,tipo);
				operaciones.add(operacion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Conexion.close(rs);
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		
		return operaciones;
	}
	
	public List<Operaciones> tipoOperacion(String operacion) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Operaciones operacionTipo =null;
		List<Operaciones> operacionesTipo = new ArrayList<>();
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_TIPO);
			stmt.setString(1, operacion);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				int idOperacion = rs.getInt("id_operaciones");
				String concepto = rs.getString("concepto");
				double monto = rs.getDouble("monto");
				Date fecha = rs.getDate("fecha");
				String tipoOperacion = rs.getString("tipo_operacion");
				
				operacionTipo = new Operaciones(idOperacion,concepto,monto,fecha,tipoOperacion);
				operacionesTipo.add(operacionTipo);
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			Conexion.close(rs);
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		return operacionesTipo;
	}
	
	public int Actualizar(Operaciones operacion) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_UPDATE);
			stmt.setString(1, operacion.getConcepto());
			stmt.setDouble(2, operacion.getMonto());
			stmt.setDate(3, operacion.getFecha());
			stmt.setString(4, operacion.getTipo());
			stmt.setInt(5, operacion.getIdOperacion());
			rows = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		
		return rows;
	}
	public int insertar(Operaciones operacion) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			
			stmt.setString(1, operacion.getConcepto());
			stmt.setDouble(2, operacion.getMonto());
			stmt.setDate(3, operacion.getFecha());
			stmt.setString(4, operacion.getTipo());

			rows = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		
		return rows;
	}
	
	public int Eliminar(Operaciones operacion) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, operacion.getIdOperacion());
			rows = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		
		return rows;
	}
}
