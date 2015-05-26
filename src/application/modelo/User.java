package application.modelo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

	private  StringProperty Usuario;
	private  StringProperty Password;
	private  BooleanProperty Permisos;
	private  BooleanProperty Estado;
	private  StringProperty IPUser;
	private  StringProperty NDispositivo;
	
	public User(){
		
	}
	
	public User(String usuario, String pass, Boolean permisos){
		this.Usuario = new SimpleStringProperty(usuario);
		this.Password = new SimpleStringProperty(pass);
		this.Permisos = new SimpleBooleanProperty(permisos);
		
		/* RELLENO */
		
		
		
		
	}
	
	public String getUsuario(){
		return this.Usuario.get();
	}
	
	public void setUsuario(String usuario) {
		this.Usuario.set(usuario);
	}
	
	public StringProperty UsuarioProperty() {
		return Usuario;
	}
	
	public String getPassword(){
		return this.Password.get();
	}
	
	public void setPassword(String password) {
		this.Password.set(password);
	}
	
	public StringProperty PasswordProperty() {
		return Password;
	}
	
	public Boolean getPermisos(){
		return this.Permisos.get();
	}
	
	public void setPermisos(Boolean permisos) {
		this.Permisos.set(permisos);
	}
	
	public BooleanProperty PermisosProperty() {
		return Permisos;
	}
	
	public Boolean getEstado(){
		return this.Estado.get();
	}
	
	public void setEstado(Boolean estado) {
		this.Estado.set(estado);
	}
	
	public BooleanProperty EstadoProperty() {
		return Estado;
	}
	
	public String getIPUser(){
		return this.IPUser.get();
	}
	
	public void setIPUser(String ipuser) {
		this.IPUser.set(ipuser);
	}
	
	public StringProperty IPUserProperty() {
		return IPUser;
	}
	
	public String getNDispositivo(){
		return this.NDispositivo.get();
	}
	
	public void setNDispositivo(String ndispositivo) {
		this.NDispositivo.set(ndispositivo);
	}
	
	public StringProperty NDispositivoProperty() {
		return NDispositivo;
	}
	

	
}
