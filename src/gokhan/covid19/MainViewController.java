package gokhan.covid19;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

public class MainViewController {
	  @FXML
	  private TextField textfield;
	  @FXML
	  private ProgressBar datacontrol;
	
	  private static ArrayList<CovidDatas> datas=new ArrayList<>();
	  private Controller c;
	  public MainViewController() {
		  
	  }
	  @FXML
	  public void initialize() {
		  datacontrol.setVisible(false);
	  }
	  @FXML
	  private void getData() {
		  datacontrol.setVisible(true);
	      Thread t;
	      Runnable r;
	      ScheduledExecutorService service=Executors.newScheduledThreadPool(1);
		  Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
		  alert.setTitle("Bilgi");
		  
		  alert.setHeaderText(null);
		  alert.initOwner(textfield.getScene().getWindow());
				// TODO Auto-generated method stub
				
					 r=new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							  try {
								c=new Controller(textfield.getText());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							  datas=c.getCovidDatas();
							  
						}
					
					 };
					  
					
					  
				 
				  
	           t=new Thread(r);
	           t.start();
	           Timeline y=new Timeline(new KeyFrame(Duration.millis(100),e-> {
	        	   
	        	   if(datas.size()>0) {
	        		    t.interrupt();
	        		    datacontrol.setVisible(false);
					    alert.setTitle("Veri Ýþlemi");
					    alert.setContentText("Veri çekildi grafik seçebilirsiniz...");
					    alert.getButtonTypes().remove(1);
					    alert.show();
					     
				        }
	           }));
	        
	           
	           
	           y.setAutoReverse(true);
	           service.schedule(new Runnable() {
               
				@Override
				public void run() {
					// TODO Auto-generated method stub
					 if(datas.size()>0) {
						 y.play(); 
						 service.shutdownNow();
					 }
					 
					  service.schedule(this, 1000, TimeUnit.MILLISECONDS);
				}
	        	   
	           }, 1000, TimeUnit.MILLISECONDS);
	          
		     
		  
		 
		  
		 
	
	  }
	 
	  @FXML
	  public void covidtable() {
		  try {
			    if(datas.size()>0) {
			    	Parent loader=FXMLLoader.load(getClass().getResource("/covidtable.fxml"));
					textfield.getScene().setRoot(loader);
			    }
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  @FXML
	  public void distribution() {
		  try {
			    if(datas.size()>0) {
			    	Parent loader=FXMLLoader.load(getClass().getResource("/distribution.fxml"));
					textfield.getScene().setRoot(loader);
			    }
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  @FXML
	  public void cumulative() {
		  try {
			    if(datas.size()>0) {
			    	Parent loader=FXMLLoader.load(getClass().getResource("/cumulation.fxml"));
					textfield.getScene().setRoot(loader);
			    }
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  public static ArrayList<CovidDatas> data() {
		  return datas;
	  }
	 
}
