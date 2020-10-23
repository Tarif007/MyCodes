package view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import model.DataSamp;
import model.Models;
import model.NaturePreserve;


public class GraphController implements Initializable {

	
	
	
	private NaturePreserve natureP = NaturePreserve.getInstance();
	private Models modelP = new Models();
	
	
	@FXML
	private LineChart<Number,Number> linechart;

	@FXML
	private LineChart<Number,Number> linechart2;
	
	@FXML
	private TextField firstScreneCalc;
	
	@FXML
	private TextField wolfNumber;
	
	@FXML
	private TextField years;
	
	@FXML
	private Button calculatePredator;
	@FXML
	
	private Button calculate1;
	@FXML
	
	private TextField area;
	
	@FXML
	private TextField years1;
	
	@FXML
	private TableView<DataSamp> table;
	
	@FXML
	private TableColumn<DataSamp, Integer> year;

	@FXML
	private TableColumn<DataSamp, Integer> cattles;

	@FXML
	private TableColumn<DataSamp, Integer> horse;

	@FXML
	private TableColumn<DataSamp, Integer> deer;

	@FXML
	private TableColumn<DataSamp, Integer> wolf;

	@FXML
	private ObservableList<DataSamp> tblData;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

			tblData = FXCollections.observableArrayList();
			
		}

	
	
	@FXML
	public void calcPredators() throws IOException {
		natureP.reset();
		modelP.resetState();

        XYChart.Series cattlesseries = new XYChart.Series<Number, Number>();
		cattlesseries.setName("Cattles");
		XYChart.Series horsesseries = new XYChart.Series<Number, Number>();
		horsesseries.setName("Horses");
		XYChart.Series deersseries = new XYChart.Series<Number, Number>();
		deersseries.setName("Deers");
		XYChart.Series wolvesseries = new XYChart.Series<Number, Number>();
		wolvesseries.setName("Wolves");
		this.linechart.getData().clear();
		
		
		
		int packAmount = 0;
		int yearsNeeded = 0;
		
		try{
			packAmount =  Integer.parseInt(wolfNumber.getText());
			yearsNeeded =  Integer.parseInt(years.getText());
			
		}catch (NumberFormatException ex) {
			Alert alert = new Alert(AlertType.ERROR, "Invalid input!  " );
			alert.showAndWait();
			return;
		}
	
		
		
		 if(yearsNeeded <0   || packAmount <0 ) {
			Alert alert = new Alert(AlertType.ERROR, "Invalid input!  " );
			alert.showAndWait();
			
		}
		 else if(yearsNeeded == 0   || packAmount == 0) {
			Alert alert = new Alert(AlertType.INFORMATION, " Cattle: 200\n Horse: 990\n Deer: 2500\n Wolves: 0  " );
			alert.showAndWait();
			
		} 
		 else {
			
			
		natureP.getAnimalsPop().get(3).setcPopulation(packAmount);

			for (int i = 0 ; i<=yearsNeeded - 1; ++i) {
				
				int newCowPop = modelP.calPopWPred(0);
				int newHorsePop = modelP.calPopWPred(1);
				int newDeerPop = modelP.calPopWPredDeer(2);
				int newWolfPop = modelP.predatorGrowth(3);
				
				if(newCowPop == 0 && newDeerPop == 0 && newHorsePop == 0) {
					natureP.getAnimalsPop().get(3).setcPopulation(0);
					
				}
				
				
				cattlesseries.getData().add(new XYChart.Data<Number, Number>(i +1 ,newCowPop ));
				horsesseries.getData().add(new XYChart.Data<Number, Number>(i + 1, newHorsePop));
				deersseries.getData().add(new XYChart.Data<Number, Number>(i + 1, newDeerPop));		
				wolvesseries.getData().add(new XYChart.Data<Number, Number>(i + 1, newWolfPop));
				natureP.addToData(new DataSamp(i+1, newCowPop, newHorsePop, newDeerPop, newWolfPop));
				
}

		
			linechart.getData().add(cattlesseries);
			linechart.getData().add(horsesseries);
			linechart.getData().add(deersseries);
			linechart.getData().add(wolvesseries);
			this.createTable();
		
	    
	}
		 }
	
	
	
	
	
	
	@FXML
	public void calcExtend() throws IOException {
		 natureP.reset();
		 modelP.resetState();
		this.linechart2.getData().clear();
		double ar = 0;
		int ye = 0;
		
		try{
			ar = Double.parseDouble(area.getText());
			ye = Integer.parseInt(years1.getText());
			
		}catch (NumberFormatException ex) {
			Alert alert = new Alert(AlertType.ERROR, "Invalid input!  " );
			alert.showAndWait();
			return;
		}

		
		 if(ar <0 || ye  <0 ) {
			Alert alert = new Alert(AlertType.ERROR, "Invalid input!  " );
			alert.showAndWait();
			
		} 
		 else if(ye == 0   || ar == 0) {
				Alert alert = new Alert(AlertType.INFORMATION, " Cattle: 200\n Horse: 990\n Deer: 2500\n Wolves: 0  " );
				alert.showAndWait();
				
			}
		 else {
		
			XYChart.Series cattlesseries = new XYChart.Series<Number, Number>();
			cattlesseries.setName("Cattles");
			XYChart.Series horsesseries = new XYChart.Series<Number, Number>();
			horsesseries.setName("Horses");
			XYChart.Series<Number, Number> deersseries = new XYChart.Series<Number, Number>();
			deersseries.setName("Deers");
			
			
		
			for (int i = 1 ; i<=ye; ++i) {
				
				int newCowPop = modelP.extendWcom(0 , ar);
				int newHorsePop = modelP.extendWcom(1 , ar);
				int newDeerPop = modelP.deerWextend(2 , ar);
				
				
				
			cattlesseries.getData().add(new XYChart.Data<Number, Number>(i + 1, newCowPop));
				
			horsesseries.getData().add(new XYChart.Data<Number, Number>(i + 1, newHorsePop));
		 
	        deersseries.getData().add(new XYChart.Data<Number, Number>(i + 1, newDeerPop));
	       
	        natureP.addToData(new DataSamp(i, newCowPop, newHorsePop, newDeerPop, 0));

		    }
            
		
	        linechart2.getData().add(cattlesseries);
			linechart2.getData().add(horsesseries);
		    linechart2.getData().add(deersseries);
			this.createTable();
			
		
		}
	}
	
	
	
	public void createTable() {
		tblData.clear();
		table.getItems().clear();
		
		
		year.setCellValueFactory(new PropertyValueFactory<DataSamp, Integer>("year"));
		cattles.setCellValueFactory(
				new Callback<CellDataFeatures<DataSamp, Integer>, ObservableValue<Integer>>() {
					@Override
					public ObservableValue call(CellDataFeatures<DataSamp, Integer> c) {
						return new SimpleIntegerProperty(c.getValue().getCowPop());
						
					}
				});
		horse.setCellValueFactory(
				new Callback<CellDataFeatures<DataSamp, Integer>, ObservableValue<Integer>>() {
					@Override
					public ObservableValue call(CellDataFeatures<DataSamp, Integer> c) {
						return new SimpleIntegerProperty(c.getValue().getHorsePop());
					}
				});
		deer.setCellValueFactory(
				new Callback<CellDataFeatures<DataSamp, Integer>, ObservableValue<Integer>>() {
					@Override
					public ObservableValue call(CellDataFeatures<DataSamp, Integer> c) {
						return new SimpleIntegerProperty(c.getValue().getDeerPop());
					}
				});
		wolf.setCellValueFactory(
				new Callback<CellDataFeatures<DataSamp, Integer>, ObservableValue<Integer>>() {
					@Override
					public ObservableValue call(CellDataFeatures<DataSamp, Integer> c) {
						return new SimpleIntegerProperty(c.getValue().getWolfPop());
					}
				});
		
		for (DataSamp prepop : natureP.getList()) {
			tblData.add(prepop);
			
		}
	
		table.setItems(tblData);
		
		
		
		
	}

	
	
}
