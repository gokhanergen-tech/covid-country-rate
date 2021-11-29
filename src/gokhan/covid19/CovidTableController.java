package gokhan.covid19;

import java.io.IOException;
import java.util.ArrayList;

import com.sun.prism.paint.Color;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

public class CovidTableController {
  @FXML
  private VBox vbox;
  @FXML
  private Button back;
 

  @FXML
  public void initialize() {
	  Dialog<Cumulative> dialog=new Dialog<>();
	  
	
	 
	  CovidTable t=new CovidTable();
	  t.setDatas(MainViewController.data());
	  t.setPrefHeight(1000);
	  Cumulative c=new Cumulative(MainViewController.data(),Cumulative.CASE);
	  
	  
	
	  dialog.getDialogPane().setContent(c);
	 
	  dialog.initModality(Modality.NONE);
	 
	  dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
      dialog.setTitle("Covid19 Case");
	  /*stack.getChildren().add(t);
	  stack.getChildren().add(cumulative);*/
	
	  
	  vbox.getChildren().add(t);
	  TableView view=(TableView) t.getChildren().get(0);
	  
	  view.getSelectionModel().selectedItemProperty().addListener(e->{
		  c.setCountry(((TableCVD)view.getSelectionModel().getSelectedItem()).getCountry());
		    dialog.close();
		    dialog.show();
	  });
	  
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
