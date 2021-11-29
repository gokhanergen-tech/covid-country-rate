package gokhan.covid19;

import javafx.beans.property.StringProperty;

public class TableCVD {
  private String country,totalcase,newcases,totaldeath,newdeath,pop,mortality,attack_rate;
  public TableCVD(String country,String totalcase,String newcases,String totaldeath,String newdeath,String pop,String mortality,String attack_rate) {
	  this.country=country;
	  this.totalcase=totalcase;
	  this.newcases=newcases;
	  this.totaldeath=totaldeath;
	  this.newdeath=newdeath;
	  this.pop=pop;
	  this.mortality=mortality;
	  this.attack_rate=attack_rate;

  }
  public String getCountry() {
	  return country;
  }
  public String getTotalcase() {
	  return totalcase;
  }
  public String getNewcases() {
	  return newcases;
  }
  public String getTotaldeath() {
	  return totaldeath;
  }
  public String getNewdeath() {
	  return newdeath;
  }
  public String getPop() {
	  return pop;
  }
  public String getMortality() {
	  return mortality;
  }
  public String getAttack_rate() {
	  return attack_rate;
  }
}
