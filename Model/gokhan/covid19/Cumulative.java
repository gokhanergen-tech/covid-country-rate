package gokhan.covid19;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.LineChart.SortingPolicy;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.NumberAxis.DefaultFormatter;
import javafx.scene.chart.XYChart;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.Pane;

public class Cumulative extends Pane {
	
	private LineChart linechart;
	private CategoryAxis cat;
	private NumberAxis num;
	private ArrayList<CovidDatas> datas;
	public static final String DEATH="death";
	public static final String CASE="case";
	public ArrayList<String> countries;
	private XYChart.Series<String,Number> test;
	private ArrayList<String> dates;
	private String situation="";
      public Cumulative(ArrayList<CovidDatas> datas,String situation) {
    	  dates=new ArrayList<String>();
    	  for(int i=60;i>=0;i--) {
    		  dates.add(LocalDate.now().minusDays(i).toString());
    	  }
    	  
    	 
    	  countries=new ArrayList<>();
 	     cat=new CategoryAxis();
    	  cat.setFocusTraversable(true);
    
    	  num=new NumberAxis(0,10,0.1);
    
    	  num.setTickLabelFormatter(new NumberAxis.DefaultFormatter(new NumberAxis()){
    		  @Override
    		  public String toString(Number object) {
				return String.format("%4.2f", object);
    			  
    		  }
    	  });
    	
    	  linechart=new LineChart(cat,num);
    	
    	  linechart.setVerticalGridLinesVisible(false);
    	  linechart.setHorizontalGridLinesVisible(false);
    	  linechart.setEffect(new DropShadow());
    	  linechart.setAlternativeRowFillVisible(true);
    	  linechart.setCreateSymbols(false);
    	  
    	  this.datas=datas;
    	  this.situation=situation;
    	  linechart.setPrefSize(1000, this.getPrefHeight());
    	  test=new XYChart.Series<String,Number>();
          for(String s:dates) {
        	  test.getData().add(new XYChart.Data<String, Number>(s,0.0));
          }
          countries.add("Test");
          cat.getCategories().add("Test");
          test.setName("Test");
          linechart.getData().add(test);
          linechart.setLegendSide(Side.RIGHT);
         
    	  this.getChildren().add(linechart);
    	
      }
      public void addCountry(String country){
                 if(!countries.contains(country)) {
                	 countries.add(country);
               	     setTable(1); 
                 }else {
                	 deSelect(country);
                 }
            	  
              
    		 
    	  
    	 
      }
   
      private void setTable(int x) {
          
    	  if(situation.equals(DEATH)) {
    		  if(x==1) {
    			  for(CovidDatas s:datas) {
        			  if(countries.get(countries.size()-1).equals(s.getName())) {
        				    @SuppressWarnings("rawtypes")
        					XYChart.Series chart=new XYChart.Series();
        				    cat.getCategories().add(s.getName());
        				    chart.setName(s.getName());
        				    for(int i=s.getDatas().size()-1;i>=0;i--) {
        				    	if(dates.contains(s.getDatas().get(i).getDate().toString())) {
        				    		  if(s.getDatas().get(i).getDeaths()!=0) {
                  				    	  chart.getData().add(new XYChart.Data<String, Number>(s.getDatas().get(i).getDate().toString(),Math.log10(s.getDatas().get(i).getDeaths())));
                                     }else {
                 				    	  chart.getData().add(new XYChart.Data<String, Number>(s.getDatas().get(i).getDate().toString(),0));

                                     }
        				    	}
        				    }
        				  
        					  
        				    
        				    linechart.getData().add(chart);
        				    break;
        				    
        			  }
        		  } 
    		  }
    		
    	  }else if(situation.equals(CASE)) {
    		  
    		  if(x==1) {
    			  for(CovidDatas s:datas) {
        			  if(countries.get(countries.size()-1).equals(s.getName())) {
        				    @SuppressWarnings("rawtypes")
        					XYChart.Series<String, Number> chart=new XYChart.Series<String, Number>();
        				    cat.getCategories().add(s.getName());
        				    chart.setName(s.getName());
        				
        				    for(int i=s.getDatas().size()-1;i>=0;i--) {
        				    	
        				    	if(dates.contains(s.getDatas().get(i).getDate().toString())) {
        				    		 if(s.getDatas().get(i).getCases()!=0) {
                 				    	  chart.getData().add(new XYChart.Data<String, Number>(s.getDatas().get(i).getDate().toString(),Math.log10(s.getDatas().get(i).getCases())));
                                    }else {
                				    	  chart.getData().add(new XYChart.Data<String, Number>(s.getDatas().get(i).getDate().toString(),0));

                                    }
        				    	}
        				    }
        				    linechart.getData().add(chart);
        				    break;
        				    
        			  }
        		  } 
    		  }
    	  }
    	  
         
    	  
      }
      public void setCountry(String country) {
    	 
    	  for(CovidDatas s:datas) {
			  if(country.equals(s.getName())) {
				    @SuppressWarnings("rawtypes")
					XYChart.Series<String, Number> chart=new XYChart.Series<String, Number>();
				    cat.getCategories().add(s.getName());
				    chart.setName(s.getName());
				
				    for(int i=s.getDatas().size()-1;i>=0;i--) {
				    	
				    	if(dates.contains(s.getDatas().get(i).getDate().toString())) {
				    		 if(s.getDatas().get(i).getCases()!=0) {
         				    	  chart.getData().add(new XYChart.Data<String, Number>(s.getDatas().get(i).getDate().toString(),Math.log10(s.getDatas().get(i).getCases())));
                            }else {
        				    	  chart.getData().add(new XYChart.Data<String, Number>(s.getDatas().get(i).getDate().toString(),0));

                            }
				    	}
				    }
				    linechart.getData().set(0, chart);
				    break;
				    
			  }
		  } 
    	  
    	  
    
      }
      public void resetCountries() {
    	  cat.getCategories().clear();
    	 
    	  linechart.getData().remove(1, linechart.getData().size());
    	  cat.getCategories().add("Test");
    	  countries.clear();

    	  countries.add("Test");
          
      }
      public void deSelect(String country) {

    	 linechart.getData().remove(countries.indexOf(country));
    	 cat.getCategories().remove(country);
         countries.remove(country);
    		
    	
    	
      }
      
	
      
}
