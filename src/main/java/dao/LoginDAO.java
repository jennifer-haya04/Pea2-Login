package dao;

import java.util.List;
import bean.cuentaLogin;

public class LoginDAO {
	db.db db = new db.db("LoginWeb");
	
	public String[] getUsuario(String user) {
		db.Sentencia(String.format("call sp_getUser('%s')", user));
		return db.getRegistro();
	}
	
	public String[] validaUser(String email) {
		db.Sentencia(String.format("call sp_validaUser('%s')", email));
		return db.getRegistro();
	}
	
	public int createUser(String nombre, String email, String user, String pass) {
		db.Sentencia(String.format("call sp_createUser('%s', '%s', '%s', '%s')", nombre , email, user, pass));
		return db.setRegistro();
	}
	
	public int updatePassword(int id, String pass) {
		db.Sentencia(String.format("call sp_updatePassword(%s, '%s')", id, pass));
		return db.setRegistro();
	}
	
	
	
	public int setNewUser(Object user) {
		db.Sentencia(String.format("call sp_setNewUser", user));
		return 1;
	}
	
	public int setNewPassword(String correo, String password) {
		db.equals(String.format("call sp_setNewPassword", null));
		return 1;
	}

}
