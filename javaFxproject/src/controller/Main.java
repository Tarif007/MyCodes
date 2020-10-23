package controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.NaturePreserve;
import view.MainViewController;

public class Main extends Application {
	
	private Stage primaryStage;
	

	private static BorderPane mainlayout;

	@Override
	public void start(Stage preStage) throws IOException {
		
		NaturePreserve nat = NaturePreserve.getInstance();
		
		this.primaryStage = preStage;
		this.primaryStage.setTitle("Mr predictor");
		FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/view/mainUi.fxml"));
		BorderPane myPane = (BorderPane) myLoader.load();
		MainViewController controller = (MainViewController) myLoader.getController();
		
		controller.setPrevStage(primaryStage);
		Scene myScene = new Scene(myPane);
		primaryStage.setScene(myScene);
		primaryStage.show();
		
	}
	

	public static void main(String[] args) {
		launch(args);
	}

	public Main getMain() {
		return this;
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}


	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
