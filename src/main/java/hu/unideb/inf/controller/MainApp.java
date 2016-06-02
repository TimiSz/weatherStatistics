package hu.unideb.inf.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The MainApp class. It shows the user interface.
 * 
 * @author Tímea Szabó
 *
 */
public class MainApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainScene.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Weather Statistics");
        stage.setScene(scene);
        stage.show();
		
	}
	
	/**
	 * The main function.
	 * @param args Unused.
	 */
	public static void main(String[] args) {
        launch(args);
    }

}
