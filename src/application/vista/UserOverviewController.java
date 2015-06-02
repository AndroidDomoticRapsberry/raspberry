package application.vista;



import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import application.MainControl;
import application.modelo.User;

@SuppressWarnings("static-access")
public class UserOverviewController {


	/**
	 * Variables Añadir
	 */
	@FXML
	private TextField AnadirUsuarioField;
	@FXML
	private TextField AnadirPassField;
	@FXML
	private TextField AnadirRPassField;
	@FXML
	private ComboBox<String> permisosanadir;
	private Boolean AnadirClicked = false;
	/**
	 * Variables Editar
	 */
	@FXML
	private TextField EditarUsuarioField;
	@FXML
	private TextField EditarPassField;
	@FXML
	private TextField EditarRPassField;
	@FXML
	private ComboBox<String> permisoseditar;
	@FXML
	private ComboBox<String> usuarioseditar;
	private Boolean EditarClicked = false;

	/**
	 * Variables Borrar
	 */
	private Boolean BorrarClicked = false;
	@FXML
	private ComboBox<String> usuariosborrar;

	/**
	 * Variables Ver 
	 */
	@FXML
	private TableView<User> userTable;
	@FXML
	private TableColumn<User, String> usuarioColumn;
	@FXML
	private TableColumn<User, String> passColumn;
	@FXML
	private TableColumn<User, String> ndColumn;
	@FXML
	private TableColumn<User, String> ipdColumn;
	@FXML
	private TableColumn<User, String> permisosColumn;


	/**
	 * Variables generales
	 */
	private MainControl main;
	private User user;
	private static ObservableList<User> userdata = FXCollections.observableArrayList();
	ObservableList<String> options = 
			FXCollections.observableArrayList(
					"Control",
					"Visión"
					);
	ObservableList<String> listusers = 
			FXCollections.observableArrayList();

	//---------------------------------
	//METODOS GENERAL
	//---------------------------------


	@FXML
	private void initialize() {



		permisosanadir.getItems().clear();
		permisosanadir.getItems().addAll(options);

		usuarioseditar.getItems().clear();
		usuarioseditar.getItems().addAll(listusers);

		permisoseditar.getItems().clear();
		permisoseditar.getItems().addAll(options);

		usuariosborrar.getItems().clear();
		usuariosborrar.getItems().addAll(listusers);



		if (main.userdata != null){
			llenarlista();
		}
		table();
		
	}

	public UserOverviewController() {

	}

	public void setUser(User user) {
		this.user = user;
		AnadirUsuarioField.setText(user.getUsuario());
		AnadirPassField.setText(user.getPassword());		
	}

	public void setMain(MainControl main) {
		this.main = main;
	}

	private void llenarlista(){
		listusers.clear();

		for (User user :  main.userdata) {
			listusers.add(user.getUsuario());
		}

		usuarioseditar.getItems().clear();
		usuarioseditar.getItems().addAll(listusers);

		usuariosborrar.getItems().clear();
		usuariosborrar.getItems().addAll(listusers);

	}


	//---------------------------------
	//METODOS VER
	//---------------------------------

	private void preparetable(){
		usuarioColumn.setCellValueFactory(new PropertyValueFactory<User,String>("Usuario"));
		passColumn.setCellValueFactory(new PropertyValueFactory<User,String>("Password"));
		ndColumn.setCellValueFactory(new PropertyValueFactory<User,String>("NDispositivo"));
		ipdColumn.setCellValueFactory(new PropertyValueFactory<User,String>("IPUser"));
		permisosColumn.setCellValueFactory(new PropertyValueFactory<User,String>("Permisos"));

	
	}
	private void loadData(){
		userTable.getItems().clear();
		userTable.getItems().addAll(main.userdata);
		
	}
	private void table(){
		main.unmarshall();
		preparetable();
		loadData();
	}

	@FXML
	private void btnReload(){
		
		table();
	}

	//---------------------------------
	//METODOS AÑADIR
	//---------------------------------

	@FXML
	private void btnAnadir(){

		AnadirClicked = true;
		if (isInputValid()) {

			user = new User(AnadirUsuarioField.getText(),AnadirPassField.getText(),
					permisosanadir.getSelectionModel().getSelectedItem(), false, " ", " ");

			Dialogs.create()
			.title("")
			.masthead("Usuario añadido con exito.").showInformation();
			//Añadir los datos a la lista.
			main.getUserdata().add(user);
			//Llamar al marshaller para convertir la lista de users a xml
			main.JAXBmarshall();
			llenarlista();
			iniAnadir();
			iniEditar();
			iniBorrar();
			table();

		} 
	}


	private void iniAnadir(){
		AnadirUsuarioField.setText(null);
		AnadirPassField.setText(null);
		AnadirRPassField.setText(null);
		permisosanadir.setValue(null);
	}

	//---------------------------------
	//METODOS EDITAR
	//---------------------------------


	@FXML
	private void btnEditar(){

		EditarClicked = true;



		if (isInputValid()){

			Action cuidado = Dialogs.create().title("Cuidado").masthead("¿Seguro que deseas editar este Usuario?").showConfirm();

			if (cuidado == Dialog.Actions.YES){
				userdata.addAll(main.getUserdata());
				@SuppressWarnings("rawtypes")
				Iterator iterator = userdata.iterator();
				boolean ok = true;

				while (iterator.hasNext() && ok) {
					User husah= (User) iterator.next();
					if (usuarioseditar.getSelectionModel().getSelectedItem().equals(husah.getUsuario())){
						ok = false;
						User usa = husah;
						usa.setUsuario(EditarUsuarioField.getText());
						usa.setPassword(EditarPassField.getText());
						usa.setPermisos(permisoseditar.getSelectionModel().getSelectedItem());
						main.getUserdata().add(usa);
						main.getUserdata().remove(usa);
						main.JAXBmarshall();
						llenarlista();
						iniEditar();
						iniAnadir();
						iniBorrar();
						table();


					}
				}
			} else {
				if (cuidado == Dialog.Actions.NO){
					iniEditar();
				}
			}


		}

	}

	private void iniEditar(){
		usuarioseditar.setValue(null);
		EditarUsuarioField.setText(null);
		EditarPassField.setText(null);
		EditarRPassField.setText(null);
		permisoseditar.setValue(null);
	}

	//---------------------------------
	//METODOS BORRAR
	//---------------------------------
	@FXML
	private void btnBorrar() {
		BorrarClicked = true;
		Action cuidado = Dialogs.create().title("Precaución").
				masthead("¿Seguro que deseas eliminar este Usuario?").
				message("Recuerda que una vez eliminado no podras recuperarlo.").
				showConfirm();

		if (cuidado == Dialog.Actions.YES){

			@SuppressWarnings("rawtypes")
			Iterator iterator = main.userdata.iterator();
			boolean ok = true;
			while (iterator.hasNext() && ok) {
				User husah= (User) iterator.next();
				if (usuariosborrar.getSelectionModel().getSelectedItem().equals(husah.getUsuario())){
					ok = false;
					User usa = husah;
					main.getUserdata().remove(usa);
					main.JAXBmarshall();
					llenarlista();
					iniBorrar();
					iniEditar();
					iniAnadir();
					table();


				}
			}
		} else {
			if (cuidado == Dialog.Actions.NO){
				iniBorrar();

			}
		}	
	}
	private void iniBorrar(){
		usuariosborrar.setValue(null);
	}

	/**
	 * Control de errores
	 * @return
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (AnadirClicked){     	


			for (User nombre : main.userdata) {
				if (nombre.getUsuario().equals(AnadirUsuarioField.getText())) {
					errorMessage += "El Usuario ya existe. \n";
				}

			}

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

			if (permisosanadir.getValue() == null ){
				errorMessage += "No has elegido ningun permiso. \n";
			}

			AnadirClicked = false;
		}

		if (EditarClicked) {

			if (usuarioseditar.getValue() != null ){


				for (User nombre : main.userdata) {
					if (nombre.getUsuario().equals(EditarUsuarioField.getText())) {
						errorMessage += "Nombre de Usuario no disponible. \n";
					}

				}

				if (EditarUsuarioField.getText().isEmpty()){
					errorMessage += "El campo Usuario esta vacio. \n";
				}

				if (EditarPassField.getText().isEmpty()){
					errorMessage += "El campo Contraseña esta vacio. \n";
				}

				if (EditarRPassField.getText().isEmpty()){
					errorMessage += "El campo Repetir Contraseña esta vacio. \n";
				}

				if (!EditarPassField.getText().isEmpty() && !EditarRPassField.getText().isEmpty()) {
					if (!EditarPassField.getText().equals(EditarRPassField.getText())) {
						errorMessage += "Las contraseñas deben coincidir. \n"; 
					}
				}

				if (permisoseditar.getValue() == null ){
					errorMessage += "No has elegido ningun permiso. \n";
				}

			} else {
				errorMessage += "No has elegido ningun usuario. \n";
			}

			EditarClicked = false;
		}

		if (BorrarClicked){

			BorrarClicked = false;
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
