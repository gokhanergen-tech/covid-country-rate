package gokhan.covid19;

import java.util.ArrayList;

public class CovidDatas extends Country implements Comparable {
   private ArrayList<CaseDay> days;
   private int total_cases=0,total_deaths=0;
   
   public CovidDatas(String Country,String geoID,String Exp,String pop) {
	   super(Country,geoID,Exp,pop);
   }
   public void loadDatas(ArrayList<CaseDay> arr) {
	   days=new ArrayList<CaseDay>(arr);
	   compute_total_cases();
	   compute_total_deaths();
   }
   public ArrayList<CaseDay> getDatas() {
	   return days;
   }
   public int get_total_case() {
	   return total_cases;
   }
   public int get_total_deaths() {
	   return total_deaths;
   }
   private void compute_total_cases() {
	   total_cases=0;
	   for(CaseDay c:days) {
		   total_cases+=c.getCases();
	   }
   }
   private void compute_total_deaths() {
	   total_deaths=0;
	   
	   for(CaseDay c:days) {
		   total_deaths+=c.getDeaths();
	   }
   }
@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	if(o instanceof CovidDatas) {
		CovidDatas d=(CovidDatas)o;
		if(this.total_cases<d.total_cases)
		   return 1;
		else 
			return -1;
	}
	return 0;
}
}
