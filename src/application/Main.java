package application;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import application.vista.UserOverviewController;



public class Main extends Application {
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
		    this.primaryStage.setTitle("Android Domotic Raspberry Control");
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
	
	public void initUserOverview() {
		   

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("vista/UserOverview.fxml"));
			TabPane userOverview = (TabPane) loader.load();

			Scene scene = new Scene(userOverview);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			UserOverviewController controller = loader.getController();
			controller.setMain(this);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
   public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
