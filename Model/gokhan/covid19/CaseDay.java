package gokhan.covid19;

import java.time.LocalDate;

public class CaseDay {
   private int day;
   private int month;
   private int year;
   private int cases;
   private int Deaths;
   public CaseDay(int day,int month,int year,int cases,int Deaths) {
	   this.day=day;
	   this.month=month;
	   this.year=year;
	   this.cases=cases;
	   this.Deaths=Deaths;
   }
   public int getCases() {
	   return cases;
   }
   public int getDeaths() {
	   return Deaths;
   }
   public LocalDate getDate() {
	   return LocalDate.of(year, month, day);
   }
   public int getDay() {
	   return day;
   }
   public int getMonth() {
	   return month;
   }
   public int getYear() {
	   return year;
   }
   
}
