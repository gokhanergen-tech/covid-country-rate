package gokhan.covid19;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

public class Distribution extends Pane {
	private StackedBarChart chart;
    public Distribution(ArrayList<CovidDatas> datas,int select) {
    
    	
    	switch(select){
    	  case 1:
    		  setD1(datas);
    		  break;
    	  case 2:
    		  setC2(datas);
    		  break;
    	}
    	
    	this.getChildren().add(chart);
    }
    private void setD1(ArrayList<CovidDatas> datas) {
    	init();
    	@SuppressWarnings("rawtypes")
		XYChart.Series europe,america,asia,oceania,africa;
    	europe=new XYChart.Series();
    	america=new XYChart.Series();
    	asia=new XYChart.Series();
    	oceania=new XYChart.Series();
    	africa=new XYChart.Series();
    	europe.setName("Europe");
    	america.setName("America");
    	asia.setName("Asia");
    	oceania.setName("Oceania");
    	africa.setName("Africa");
    	
    	for(CovidDatas data:datas) {
    	    
    		switch(data.ContinentExp()) {
    		case "Europe":
    			for(CaseDay day:data.getDatas()) {
    				if(day.getMonth()>=4&&day.getDay()>0&&day.getYear()==2020)
    				  europe.getData().add(new XYChart.Data<String, Integer>(day.getDate().toString(), day.getDeaths()));

    				
    			}
    			break;
    		case "America":
    			for(CaseDay day:data.getDatas()) {
    				if(day.getMonth()>=4&&day.getDay()>0&&day.getYear()==2020)
      				  america.getData().add(new XYChart.Data<String, Integer>(day.getDate().toString(), day.getDeaths()));
    			}
    			break;
    		case "Asia":
    			for(CaseDay day:data.getDatas()) {
    				if(day.getMonth()>=4&&day.getDay()>0&&day.getYear()==2020)
      				  asia.getData().add(new XYChart.Data<String, Integer>(day.getDate().toString(), day.getDeaths()));
    			}
    			break;
    		case "Oceania":
    			for(CaseDay day:data.getDatas()) {
    				if(day.getMonth()>=4&&day.getDay()>0&&day.getYear()==2020)
      				  oceania.getData().add(new XYChart.Data<String, Integer>(day.getDate().toString(), day.getDeaths()));
    			}
    			break;
    		case "Africa":
    			for(CaseDay day:data.getDatas()) {
    				if(day.getMonth()>=4&&day.getDay()>0&&day.getYear()==2020)
      				  africa.getData().add(new XYChart.Data<String, Integer>(day.getDate().toString(), day.getDeaths()));
    			}
    			break;
    		}
    	}
    	
        chart.prefWidthProperty().bind(this.widthProperty());
       
        ObservableList<XYChart.Series<String,Integer>> list=FXCollections.observableArrayList();
        list.addAll(europe,america,asia,oceania,africa);
    	chart.getData().addAll(list);
    }
    private void setC2(ArrayList<CovidDatas> datas) {
    	init();
    	XYChart.Series europe,america,asia,oceania,africa;
    	europe=new XYChart.Series();
    	america=new XYChart.Series();
    	asia=new XYChart.Series();
    	oceania=new XYChart.Series();
    	africa=new XYChart.Series();
    	europe.setName("Europe");
    	america.setName("America");
    	asia.setName("Asia");
    	oceania.setName("Oceania");
    	africa.setName("Africa");
    	for(CovidDatas data:datas) {
    	    
    		switch(data.ContinentExp()) {
    		case "Europe":
    			for(CaseDay day:data.getDatas()) {
    				if(day.getMonth()>=4&&day.getDay()>0&&day.getYear()==2020)
    				  europe.getData().add(new XYChart.Data<String, Integer>(day.getDate().toString(), day.getCases()));

    				
    			}
    			break;
    		case "America":
    			for(CaseDay day:data.getDatas()) {
    				if(day.getMonth()>=4&&day.getDay()>0&&day.getYear()==2020)
      				  america.getData().add(new XYChart.Data<String, Integer>(day.getDate().toString(), day.getCases()));
    			}
    			break;
    		case "Asia":
    			for(CaseDay day:data.getDatas()) {
    				if(day.getMonth()>=4&&day.getDay()>0&&day.getYear()==2020)
      				  asia.getData().add(new XYChart.Data<String, Integer>(day.getDate().toString(), day.getCases()));
    			}
    			break;
    		case "Oceania":
    			for(CaseDay day:data.getDatas()) {
    				if(day.getMonth()>=4&&day.getDay()>0&&day.getYear()==2020)
      				  oceania.getData().add(new XYChart.Data<String, Integer>(day.getDate().toString(), day.getCases()));
    			}
    			break;
    		case "Africa":
    			for(CaseDay day:data.getDatas()) {
    				if(day.getMonth()>=4&&day.getDay()>0&&day.getYear()==2020)
      				  africa.getData().add(new XYChart.Data<String, Integer>(day.getDate().toString(), day.getCases()));
    			}
    			break;
    		}
    	}
    	
        chart.prefWidthProperty().bind(this.widthProperty());
        ObservableList<XYChart.Series<String,Integer>> list=FXCollections.observableArrayList();
        list.addAll(europe,america,asia,oceania,africa);
    	chart.getData().addAll(list);
    	
    }
    private void init() {
        CategoryAxis cat=new CategoryAxis();
    	NumberAxis yAxis=new NumberAxis();
    	
    	cat.getCategories().addAll("Europe","America","Asia","Oceania","Africa");
    	
    	
    	
    	chart=new StackedBarChart(cat,yAxis);
    	
    	
    	
    	
    	
    }
}
