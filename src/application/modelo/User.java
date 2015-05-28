package application.modelo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"usuario","password","permisos","estado","IPUser","NDispositivo"})
public class User {

	private  StringProperty Usuario;
	private  StringProperty Password;
	private  BooleanProperty Permisos;
	private  BooleanProperty Estado;
	private  StringProperty IPUser;
	private  StringProperty NDispositivo;
	
	public User(){
		this(null,null, false, false, null, null);
	}
	
	public User(String usuario, String pass, Boolean permisos, Boolean estado, String ipuser, String ndispo){
		this.Usuario = new SimpleStringProperty(usuario);
		this.Password = new SimpleStringProperty(pass);
		this.Permisos = new SimpleBooleanProperty(permisos);
		this.Estado = new SimpleBooleanProperty(estado);
		this.IPUser = new SimpleStringProperty(ipuser);
		this.NDispositivo = new SimpleStringProperty(ndispo);
		/* RELLENO */
		
		
		
		
	}
	
	public String getUsuario(){
		return Usuario.get();
	}
	@XmlElement(name="Usuario")
	public void setUsuario(String usuario) {
		this.Usuario.set(usuario);
	}

	public StringProperty UsuarioProperty() {
		return Usuario;
	}
	
	public String getPassword(){
		return Password.get();
	}
	@XmlElement(name="Password")
	public void setPassword(String password) {
		this.Password.set(password);
	}
	
	public StringProperty PasswordProperty() {
		return Password;
	}
	
	public Boolean getPermisos(){
		return Permisos.get();
	}
	@XmlElement(name="Permisos")
	public void setPermisos(Boolean permisos) {
		this.Permisos.set(permisos);
	}
	
	public BooleanProperty PermisosProperty() {
		return Permisos;
	}
	
	public Boolean getEstado(){
		return Estado.get();
	}
	@XmlElement(name="Estado")
	public void setEstado(Boolean estado) {
		this.Estado.set(estado);
	}
	
	public BooleanProperty EstadoProperty() {
		return Estado;
	}
	
	public String getIPUser(){
		return IPUser.get();
	}
	@XmlElement(name="IPUser")
	public void setIPUser(String ipuser) {
		this.IPUser.set(ipuser);
	}
	
	public StringProperty IPUserProperty() {
		return IPUser;
	}
	
	public String getNDispositivo(){
		return NDispositivo.get();
	}
	@XmlElement(name="NDispositivo")
	public void setNDispositivo(String ndispositivo) {
		this.NDispositivo.set(ndispositivo);
	}
	
	public StringProperty NDispositivoProperty() {
		return NDispositivo;
	}
	

	
}
