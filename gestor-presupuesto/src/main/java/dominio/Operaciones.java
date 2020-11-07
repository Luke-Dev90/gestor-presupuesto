package dominio;

import java.sql.Date;

public class Operaciones {
	
	private int idOperaciones;
	private String concepto;
	private double monto;
	private Date fecha;
	private String tipo;
	
	
	

	public Operaciones() {
		
	}
	
	public Operaciones(int idOperaciones) 
	{
		this.idOperaciones = idOperaciones;
	}
	
	public Operaciones(String tipo) {
		this.tipo = tipo;
	}
	
	public Operaciones(String concepto, double monto, Date fecha, String tipo) 
	{
		this.concepto = concepto;
		this.monto = monto;
		this.fecha = fecha;
		this.tipo = tipo;
	}
	
	public Operaciones(int idOperaciones, String concepto, double monto, Date fecha, String tipo) 
	{
		this.idOperaciones = idOperaciones;
		this.concepto = concepto;
		this.monto = monto;
		this.fecha = fecha;
		this.tipo = tipo;
	}
	
	public int getIdOperacion() {
		return idOperaciones;
	}
	public void setIdOperacion(int idOperaciones) {
		this.idOperaciones = idOperaciones;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipoOperacion) {
		this.tipo = tipoOperacion;
	}
	
	@Override
	public String toString() {
		return "Operaciones [idOperaciones=" + idOperaciones + ", concepto=" + concepto + ", monto=" + monto
				+ ", fecha=" + fecha + ", tipo=" + tipo + "]";
	}
	
}
