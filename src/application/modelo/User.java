package application.modelo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

	private  StringProperty Usuario = null;
	private  StringProperty Password = null;
	private  BooleanProperty Permisos = null;
	private  BooleanProperty Estado = null;
	private  StringProperty IPUser = null;
	private  StringProperty NDispositivo = null;
	
	public User(){
		this(null,null,null);
	}
	
	public User(String usuario, String pass, Boolean permisos){
		this.Usuario = new SimpleStringProperty(usuario);
		this.Password = new SimpleStringProperty(pass);
		this.Permisos = new SimpleBooleanProperty(permisos);
		
		/* RELLENO */
		
		
		
		
	}
	
	public String setUsuario(){
		return this.Usuario.get();
	}
	
	public void setUsuario(String usuario) {
		this.Usuario.set(usuario);
	}
	
	public StringProperty getUsuario() {
		return Usuario;
	}
	
	public String setPassword(){
		return this.Password.get();
	}
	
	public void setPassword(String password) {
		this.Password.set(password);
	}
	
	public StringProperty getPassword() {
		return Password;
	}
	
	public Boolean setPermisos(){
		return this.Permisos.get();
	}
	
	public void setPermisos(Boolean permisos) {
		this.Permisos.set(permisos);
	}
	
	public BooleanProperty getPermisos() {
		return Permisos;
	}
	
	public Boolean setEstado(){
		return this.Estado.get();
	}
	
	public void setEstado(Boolean estado) {
		this.Estado.set(estado);
	}
	
	public BooleanProperty getEstado() {
		return Estado;
	}
	
	public String setIPUser(){
		return this.IPUser.get();
	}
	
	public void setIPUser(String ipuser) {
		this.IPUser.set(ipuser);
	}
	
	public StringProperty getIPUser() {
		return IPUser;
	}
	
	public String setNDispositivo(){
		return this.NDispositivo.get();
	}
	
	public void setNDispositivo(String ndispositivo) {
		this.NDispositivo.set(ndispositivo);
	}
	
	public StringProperty getNDispositivo() {
		return NDispositivo;
	}
	

	
}
