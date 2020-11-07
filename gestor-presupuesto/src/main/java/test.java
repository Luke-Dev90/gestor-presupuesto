
import java.sql.Date;
import java.util.List;

import datos.OperacionesDao;
import dominio.Operaciones;


public class test  {
	
	public static void main(String[]args) {
			/*
			String user = "admin@admin.com";
			String pass = "";
			Usuario nuevo = new Usuario(user,pass);
			
			Usuario registro = UsuarioDao.encontrarU(nuevo);
			
			if(nuevo.getEmail().equals(registro.getEmail()) && nuevo.getPassword().equals(registro.getPassword())) {
				
				System.out.println("bienvenido");
			}else {
				System.out.println("incorrecto");
			}
			
		*/
		
		Operaciones operacionFecha = new OperacionesDao().encontrar(new Operaciones(3));
		int id = 3;
		String concepto ="mortadela";
		double monto = 150;
		Date sqlDate = operacionFecha.getFecha();
		String tipo = "ingresos";
		
		Operaciones actualizar = new Operaciones(id,concepto,monto,sqlDate,tipo);
		
		int actualizarReg = new OperacionesDao().Actualizar(actualizar);
		System.out.println("actualizar" + actualizarReg);
		
	}
}
