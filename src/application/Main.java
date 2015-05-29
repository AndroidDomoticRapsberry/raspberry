package application;


import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


import application.modelo.User;
import application.modelo.UserListWrapper;
import application.vista.UserOverviewController;




public class Main extends Application {
	public static ObservableList<User> userdata = FXCollections.observableArrayList();
	

	public static  ObservableList<User> getUserdata() {
		return userdata;
	}
	private Stage primaryStage;

	/**
	 * Inicia el Stage de FXML y llama al Inicializador de UserOverview
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle(
					"Android Domotic Raspberry Control");
			primaryStage.setMinHeight(438);
			primaryStage.setMinWidth(618);
			primaryStage.setMaxHeight(438);
			primaryStage.setMaxWidth(618);


			this.primaryStage.getIcons().add(new Image("file:resources/images/LOGOFINALICONO.png"));

			initUserOverview();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga el FXML, inicia la escena y se comunica con el Controlador.
	 */
	public void initUserOverview() {


		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(
					"vista/UserOverview.fxml"));
			TabPane userOverview = (TabPane) loader.load();

			Scene scene = new Scene(userOverview);
			primaryStage.setScene(scene);
			primaryStage.show();

			UserOverviewController controller = loader.
					getController();
			controller.setMain(this);



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Marshall
	 * Convierte Objetos a XML.
	 */
	public static void JAXBmarshall(){
		try {

			File file = new File("file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(
					UserListWrapper.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();


			jaxbMarshaller.setProperty(Marshaller.
					JAXB_FORMATTED_OUTPUT, true);

			UserListWrapper user = new UserListWrapper();
			user.setUsers(userdata);

			jaxbMarshaller.marshal(user, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}


	/**
	 * Unmarshall
	 * Convierte XML a Objetos.
	 * @return
	 */
	public static  void JAXBunmarshall(File file){
		try {


			JAXBContext jaxbContext = JAXBContext.newInstance(
					UserListWrapper.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			UserListWrapper user = (UserListWrapper) jaxbUnmarshaller.
					unmarshal(file);

			userdata.clear();
			userdata.addAll(user.getUser());

		} catch (JAXBException e) {
			
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		File file = new File("file.xml");
		if (file != null){
			JAXBunmarshall(file);
		}


		launch(args);


	}
}
