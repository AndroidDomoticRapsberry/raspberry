package application.vista;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import org.controlsfx.dialog.Dialogs;

import application.Main;
import application.modelo.User;

public class UserOverviewController {

	@FXML
	private TextField AnadirUsuarioField;
	@FXML
	private TextField AnadirPassField;
	@FXML
	private TextField AnadirRPassField;
	@FXML
	private ComboBox<String> Permisos;
	
	private Main main;
	private User user;

	 
	 ObservableList<String> options = 
	    FXCollections.observableArrayList(
	        "Control",
	        "Visión"
	    );
		
	 
 
	@FXML
	private void initialize() {
		
		Permisos.getItems().clear();
		Permisos.getItems().addAll(options);
		

	}
	 
	public UserOverviewController() {
		
	}

	public void setUser(User user) {
		this.user = user;
		
		AnadirUsuarioField.setText(user.getUsuario());
		AnadirPassField.setText(user.getPassword());

		
		
	}



	public void setMain(Main main) {
		this.main = main;
	}


	

	private boolean comboperm(String perm){
		if (Permisos.getSelectionModel().getSelectedItem().equals("Control")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	 
	@FXML
	private void btnAnadir(){
		
		if (isInputValid()) {
		
			user = new User(AnadirUsuarioField.getText(),AnadirPassField.getText(),comboperm(Permisos.getSelectionModel().getSelectedItem()));
//			user.setUsuario(AnadirUsuarioField.getText());
//			user.setPassword(AnadirPassField.getText());
//			user.setPermisos(comboperm(Permisos.getSelectionModel().getSelectedItem()));
			 Dialogs.create()
             .title("")
             .masthead("Usuario añadido con exito.").showInformation();
			 System.out.println(user.getPermisos());
				
			
		

		} 
//		System.out.println(AnadirUsuarioField.getText());
//		if (AnadirPassField.getText().equals(AnadirRPassField.getText())) {
//			System.out.println("Contraseña OK");
//		} else {
//			System.out.println("Las contraseñas no coinciden");
//		}
//		System.out.println(Permisos.getSelectionModel().getSelectedItem());	
	}
	
	
	  private boolean isInputValid() {
	        String errorMessage = "";

	        
//	        if (AnadirUsuarioField.getText().equals(user.getUsuario())){
//	        	errorMessage += "El Usuario ya existe. \n";
//	        }
	        
	
			
//	        
	        if (AnadirUsuarioField.getText().isEmpty()){
	        	errorMessage += "El campo Usuario esta vacio. \n";
	        }
	  
	        if (AnadirPassField.getText().isEmpty()){
	        	errorMessage += "El campo Contraseña esta vacio. \n";
	        }
	        
	        if (AnadirRPassField.getText().isEmpty()){
	        	errorMessage += "El campo Repetir Contraseña esta vacio. \n";
	        }
	        
	        if (!AnadirPassField.getText().isEmpty() && !AnadirRPassField.getText().isEmpty()) {
	            if (!AnadirPassField.getText().equals(AnadirRPassField.getText())) {
		            errorMessage += "Las contraseñas deben coincidir. \n"; 
		        }
			}
	        
	        
	        if (Permisos.getValue() == null ){
	        	errorMessage += "No has elegido ningun permiso. \n";
	        }
	 

	        if (errorMessage.length() == 0) {
	            return true;
	        } else {
	            // Show the error message.
	            Dialogs.create()
	                .title("Error")
	                .masthead("Por favor corrija los siguientes errores:")
	                .message(errorMessage)
	                .showError();
	            return false;
	        }
	    }
}
