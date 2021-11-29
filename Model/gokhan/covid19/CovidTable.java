package gokhan.covid19;
import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.Cursor;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class CovidTable extends Pane {
    private TableView table;
    private TableCVD cvd;
    private TableColumn<String,TableCVD> country,totalcase,newcases,totaldeath,newdeath,pop,mortality,attack_rate;
    
    public CovidTable() {
    	table=new TableView();
    	country=new TableColumn<>("Country");
    	country.setCellValueFactory(new PropertyValueFactory<>("country"));
    	totalcase=new TableColumn<>("Total Cases");
    	totalcase.setCellValueFactory(new PropertyValueFactory<>("totalcase"));
    	
    	
    	newcases=new TableColumn<>("New Cases");
    	newcases.setCellValueFactory(new PropertyValueFactory<>("newcases"));
    	totaldeath=new TableColumn<>("Total Deaths");
    	totaldeath.setCellValueFactory(new PropertyValueFactory<>("totaldeath"));
    	newdeath=new TableColumn<>("New Deaths");
    	newdeath.setCellValueFactory(new PropertyValueFactory<>("newdeath"));
    	pop=new TableColumn<>("Population");
    	pop.setCellValueFactory(new PropertyValueFactory<>("pop"));
    	mortality=new TableColumn<>("Mortality");
    	mortality.setCellValueFactory(new PropertyValueFactory<>("mortality"));
    	attack_rate=new TableColumn<>("Attack Rate");
    	attack_rate.setCellValueFactory(new PropertyValueFactory<>("attack_rate"));
    	table.getColumns().addAll(country,totalcase,newcases,totaldeath,newdeath,pop,mortality,attack_rate);
    	this.getChildren().add(table);
    	table.prefWidthProperty().bind(this.widthProperty());
    	table.prefHeightProperty().bind(this.heightProperty());
    	table.setStyle("-fx-background-color:green");
    	table.setCursor(Cursor.OPEN_HAND);
    	
    	
    }
    public void setDatas(ArrayList<CovidDatas> datas) {
    	String country,totalcase,newcases,totaldeath,newdeath,pop,mortality,attack_rate="";
    	Collections.sort(datas);
    	for(CovidDatas data:datas) {
    		country=data.getName();
    		totalcase=String.format("%d",data.get_total_case());
    		newcases=String.format("%d",data.getDatas().get(0).getCases());
    		totaldeath =String.format("%d",data.get_total_deaths());
    		newdeath=String.format("%d",data.getDatas().get(0).getDeaths());
    		pop=data.getPop();
    		mortality=String.format("%f",Float.parseFloat(totaldeath)/Integer.parseInt(totalcase));
    		if(pop.length()>0)
    		 attack_rate=String.format("%f",Float.parseFloat(totalcase)/Integer.parseInt(pop));
    		table.getItems().add(new TableCVD(country,totalcase,newcases,totaldeath,newdeath,pop,mortality,attack_rate));
    	}
    	
    }
}
