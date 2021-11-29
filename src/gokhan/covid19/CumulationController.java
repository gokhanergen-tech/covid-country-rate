package gokhan.covid19;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;

public class CumulationController {
  @FXML
  private ListView<String> listview;
  @FXML
  private Button back;
  @FXML
  private HBox hbox;
  private Cumulative d1,c1;
  private String select=Cumulative.DEATH;
 
  @FXML
  public void initialize() {
	
	  d1=new Cumulative(MainViewController.data(),Cumulative.DEATH);
	  c1=new Cumulative(MainViewController.data(),Cumulative.CASE);
	
	  hbox.getChildren().add(0, c1);
	  
	  listview.setPrefSize(100, 400);
	
	  for(CovidDatas d:MainViewController.data()) {
		  listview.getItems().add(d.getName());
		  
	  }
	  listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	
	  listview.getSelectionModel().selectedItemProperty().addListener(ov->{
		     
		    	
		    		 c1.addCountry(listview.getSelectionModel().getSelectedItem());
				      d1.addCountry(listview.getSelectionModel().getSelectedItem()); 
				     
			   
		     
	  });


	  
  };
  @FXML
  public void deaths() {
	  if(!select.equals(Cumulative.DEATH)) {
		  
		  hbox.getChildren().set(0, d1);
		  select=Cumulative.DEATH;
	  }
	 
  }
  @FXML
  public void cases() {
	  
	  if(!select.equals(Cumulative.CASE)) {
		 
		  hbox.getChildren().set(0, c1);
		  select=Cumulative.CASE;
	  }
	
  }
  @FXML
  public void back_buton() {
	  Parent loader;
	try {
		loader = FXMLLoader.load(getClass().getResource("/main.fxml"));
		 back.getScene().setRoot(loader);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
  }
  @FXML
  public void selects() {
	  c1.resetCountries();
	  d1.resetCountries();
  }
}
