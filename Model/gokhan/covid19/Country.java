package gokhan.covid19;

public class Country {
  private String country_name;
  private String geoID;
  private String ContinentExp;
  private String population;
  
  public Country(String name,String geoID,String Exp,String pop) {
	  this.country_name=name;
	  this.geoID=geoID;
	  this.ContinentExp=Exp;
	  this.population=pop;
  }
  public String getPop() {
	  return population;
  }
  public String getName() {
	  return country_name;
  }
  public String ContinentExp() {
	  return ContinentExp;
  }
}
