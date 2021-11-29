package gokhan.covid19;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
   
	  private static ArrayList<CovidDatas> datas=new ArrayList<>();
	  private Controller c;
	
	
   @Override
   public void start(Stage s) throws Exception {
	// TODO Auto-generated method stub
	   
	 
	  
	   
	   Parent root= FXMLLoader.load(getClass().getResource("/main.fxml"));

	 
	   TextField textfield=(TextField)root.lookup("#textfield");
	  

	 
	   /*Distribution d=new Distribution(datas,1);*/
	   /*Cumulative c=new Cumulative(datas,Cumulative.DEATH);
	   c.setCountry("Turkey","France","Russia","Italy","Poland");*/
	   s.setScene(new Scene(root,600,600));
	s.show();
   }
    
   public static void main(String[] args) throws IOException {
	 
	   
	   launch(args);
	   
	
   }
}
