package dominio;

public class Usuario {
	
	private int idCliente;
	private String email;
	private String password;
	
	public Usuario() {
		
	}
	
	public Usuario (String email) {
		this.email = email;
	}
	
	public Usuario(String email,String password) {
		this.email = email;
		this.password = password;
	}
	
	

	public Usuario(int idCliente, String email, String password) {
		this.idCliente = idCliente;
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Usuario [idCliente=" + idCliente + ", email=" + email + ", password=" + password + "]";
	}

	
	
	
}
