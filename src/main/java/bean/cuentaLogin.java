package bean;

import java.util.ArrayList;
import java.util.List;

public class cuentaLogin {
	int idUsuario;
	String nombreUser, email, user, password;
	
	public cuentaLogin() {
		
	}
	
	public cuentaLogin(String[] aRegistro) {
		setRegistro(aRegistro);
	}
	
	public void setRegistro(String[] aRegistro) {
		if( aRegistro == null) return;
		
		idUsuario = Integer.parseInt(aRegistro[0]);
		nombreUser = aRegistro[1];
		email = aRegistro[2];
		user = aRegistro[3];
		password = aRegistro[4];
		
	}
	
	public Object[] getRegistro() {
		return new Object[] {
				idUsuario, nombreUser, email, user, password
		};
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUser() {
		return nombreUser;
	}

	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
