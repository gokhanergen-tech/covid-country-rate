package gokhan.covid19;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gokhan.covid19.CaseDay;
import gokhan.covid19.CovidDatas;

public class Controller {
	 private Pattern pattern;
	 private Scanner s;
	 private StringBuilder builder;
	 private URL ur;
	 private URLConnection g;
	 private String country;
	 private ArrayList<CaseDay> days;
	 private ArrayList<CovidDatas> countries=new ArrayList<>();
	private ArrayList<String[]> lists=new ArrayList<>();
	 public Controller(String url) throws IOException {
		 builder=new StringBuilder();
		 try {
			ur=new URL(url);
			g=ur.openConnection();
			s=new Scanner(g.getInputStream());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Bir hata oluþtu.");
		}
		  
			
		
		 while(s.hasNext()) {
				
				 builder.append(s.next());
			}
		 pattern=Pattern.compile("(<record>)(.*?)(</record>)");
			Matcher matcher=pattern.matcher(builder.toString());
			matcher.reset();
			while(matcher.find()) {
				lists.add(matcher.group(2).split("<dateRep>|</dateRep><day>|</day><month>|</month><year>|</year><cases>|</cases><deaths>|</deaths><countriesAndTerritories>|</countriesAndTerritories><geoId>|</geoId><countryterritoryCode>|</countryterritoryCode><popData2018>|</popData2018><continentExp>|</continentExp>"));
			}
			country=lists.get(0)[7];
			countries.add(new CovidDatas(country,lists.get(0)[8],lists.get(0)[9],lists.get(0)[10]));
			days=new ArrayList<>();
			int counter=0;
		for(String[] a:lists) {
				
				if(a[7].equals(country)) {
					days.add(new CaseDay(Integer.valueOf(a[2]),Integer.valueOf(a[3]),Integer.valueOf(a[4]),Integer.valueOf(a[5]),Integer.valueOf(a[6])));
				}else {
					countries.get(countries.size()-1).loadDatas(days);
					countries.add(new CovidDatas(a[7],a[8],a[11],a[10]));
					country=a[7];
					days=new ArrayList<>();
					days.add(new CaseDay(Integer.valueOf(a[2]),Integer.valueOf(a[3]),Integer.valueOf(a[4]),Integer.valueOf(a[5]),Integer.valueOf(a[6])));
				}
				counter++;
				if(counter==lists.size()) {
					countries.get(countries.size()-1).loadDatas(days);
				}
			}
			
	 }
	 public ArrayList<CovidDatas> getCovidDatas() {
		 return countries;
	 }
}
