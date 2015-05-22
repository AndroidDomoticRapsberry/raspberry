package application.vista;

import java.awt.TextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import application.Main;
import application.modelo.User;

public class UserOverviewController {

	@FXML
	private TextField A�adirUsuarioField;
	@FXML
	private TextField A�adirPassField;
	@FXML
	private TextField A�adirRPassField;
	@FXML
	private ComboBox<String> Permisos;
	
	 private Main main;
	 private User user;
	 private boolean AgregarClick;
	 
	
	 
 
	@FXML
	private void initialize() {
		
	}
	 
	public void setUser(User user) {
		this.user = user;
		
		A�adirUsuarioField.setText(user.setUsuario());
		A�adirPassField.setText(user.setPassword());
		
		
	}



	public void setMain(Main main) {
		this.main = main;
	}

	public boolean isAgregarClicked(){
		return AgregarClick;
	}

	@FXML
	private void handlePermisos(){
		
		ObservableList<String> options = 
			    FXCollections.observableArrayList(
			        "Item 1",
			        "Item 2"
			    );
		Permisos = new ComboBox<String>(options);
		Permisos.getValue();
	
	}
}
