package view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Animals;
import model.DataSamp;
import model.Models;
import model.NaturePreserve;
import controller.Main;
import controller.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Main;

/**
 * @author lenovo
 *
 */
public class MainViewController implements Initializable {
	
	private Main main;
	private Stage aStage;
	private NaturePreserve nat = NaturePreserve.getInstance();


	
	@FXML
	private AnchorPane BorderCenter;
	
	@FXML
	private BorderPane rootPane;
	
	
	@FXML
	private Button firstScene;
	
	@FXML
	private Button home;
    
	@FXML
	private Button extend;
	
	@FXML
	private Button cinitData;
	
	@FXML
	private TextField cattle;
	
	@FXML
	private TextField horsep;
	
	@FXML
	private TextField deerp;
	
	@FXML
	private TextField ccCattle;
	
	@FXML
	private TextField ccHorse;
	
	@FXML
	private TextField ccDeer;
	
	@FXML
	private Button pbtn;
	
	@FXML
	private Button cancel;
	
	@FXML
	private  Menu about;
	
	@FXML
	private  Menu help;
	

	

	
	
	
	
	@FXML
	public void change() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/secondView.fxml"));
		BorderPane pane = FXMLLoader.load(getClass().getResource("/view/secondView.fxml"));
		BorderCenter.getChildren().setAll(pane);
		
	}
	
	@FXML
	public void goHome() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/home.fxml"));
		BorderPane pane = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
		BorderCenter.getChildren().setAll(pane);
	}
	
	@FXML
	public void goSecondView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/thirdView.fxml"));
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/thirdView.fxml"));
		BorderCenter.getChildren().setAll(pane);
		
	}
	
	
	@FXML
	public void gocinitData() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/EditData.fxml"));
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/EditData.fxml"));
		BorderCenter.getChildren().setAll(pane);
	}
	
	
	public void pChange() {

		
		int cow;
		int horse;
		int deer;
		int carrCapCow;
		int carrCapHorse;
		int carrCapDeer;

		if (cattle.getText() == null || cattle.getText().length() == 0) {
			cow = nat.getOriginState().get(0).getcPopulation();
		} else {
			cow = Integer.parseInt(cattle.getText());
			nat.getOriginState().get(0).setcPopulation(cow);
			cattle.setText("");
		}
		
		if (ccCattle.getText() == null || ccCattle.getText().length() == 0) {
			carrCapCow = nat.getOriginState().get(0).getcarrCap();
		} else {
			carrCapCow = Integer.parseInt(ccCattle.getText());
			nat.getOriginState().get(0).setcarrCap(carrCapCow);
			ccCattle.setText("");
		}

		if (horsep.getText() == null || horsep.getText().length() == 0) {
			horse = nat.getOriginState().get(1).getcPopulation();
		} else {
			horse = Integer.parseInt(horsep.getText());
			nat.getOriginState().get(1).setcPopulation(horse);
			horsep.setText("");
		}
		
		if (ccHorse.getText() == null || ccHorse.getText().length() == 0) {
			carrCapHorse = nat.getOriginState().get(1).getcarrCap();
		} else {
			carrCapHorse = Integer.parseInt(ccHorse.getText());
			nat.getOriginState().get(1).setcarrCap(carrCapHorse);
			ccHorse.setText("");
		}
		
		if (deerp.getText() == null || deerp.getText().length() == 0) {
			deer = nat.getOriginState().get(2).getcPopulation();
		} else {
			deer = Integer.parseInt(deerp.getText());
			nat.getOriginState().get(2).setcPopulation(deer);
			deerp.setText("");
		}
		
		if (ccDeer.getText() == null || ccDeer.getText().length() == 0) {
			carrCapDeer = nat.getOriginState().get(2).getcarrCap();
		} else {
			carrCapDeer = Integer.parseInt(ccDeer.getText());
			 nat.getOriginState().get(2).setcarrCap(carrCapDeer);
			 ccDeer.setText("");
		}
		
		Alert alert = new Alert(AlertType.CONFIRMATION, "Data saved!  " );
		alert.showAndWait();
	}
	
	public void pCancel() {
		
		nat.fullReset();
		
		cattle.setText("");
		horsep.setText("");
		deerp.setText("");
		ccCattle.setText("");
		ccHorse.setText("");
		ccDeer.setText("");
		Alert alert = new Alert(AlertType.CONFIRMATION, "Data saved!  " );
		alert.showAndWait();
	}
	
	@FXML
	private void AboutUs() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Mr.Predictor");
		alert.setHeaderText("About");
		alert.setContentText("Welcome to Mr.Predictor.\n "
				+ "This application helps in predicting the population growth ofthe  three large herbivores: "
				+ "Cattle, Horses and Deer and also a predator Wolves. User can choose between two models two see the outcomes with a graphical analysis.\n"
				+ "Crated by: Mohammed Tarif Hussain, Vladimir pain, Alisa pasomthong , Micheal Bultema \"\r\n" 
				+ "Website: http://inholland.nl . ");
		alert.showAndWait();
	}
	
	
	@FXML
	private void Help() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Mr.Predictor");
		//((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
		//.add(new Image("file:resources/images/help.png"));
		alert.setHeaderText("Help");
		alert.setContentText("Welcome to Mr.Predictor.\n"
				+ "Choose one of the model. Insert valid numbers into the given input fields and click calculate. "
				+ "To change Carrying capacity and initial population go to change initial data. "
				+ "Insert the values and click proceed changes to confirm it. Click cancel to set back to the given data. ");
		alert.showAndWait();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void setPrevStage(Stage aStage) {
		// TODO Auto-generated method stub
		this.aStage = aStage;
	}
	
}
	
	