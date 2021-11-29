package gokhan.covid19;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class DistributionController {
	  @FXML
	  private VBox vbox; 
	  private Distribution d1,c1;
	  private int select=1;
	  @FXML
	  private Button back;

	 

	  @FXML
	  public void initialize() {
		 
		 
		  d1=new Distribution(MainViewController.data(),1);
		  c1=new Distribution(MainViewController.data(),2);
		  vbox.getChildren().add(d1);
	  }
	  @FXML
	  public void deaths() {
		  if(select!=1) {
			  vbox.getChildren().remove(c1);
			  vbox.getChildren().add(d1);
			  select=1;
		  }
		 
	  }
	  @FXML
	  public void cases() {
		  
		  if(select!=2) {
			  vbox.getChildren().remove(d1);
			  vbox.getChildren().add(c1);
			  select=2;
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
}
