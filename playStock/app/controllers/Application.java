package controllers;

import play.*;
import play.mvc.*;
import models.City;

import utils.dataRetrieval.GoogleStockDataRetrieval;
import views.html.*;
import play.libs.Json;
import org.codehaus.jackson.JsonNode;


public class Application extends Controller {
  
  public static Result index() {
    return ok(index.render("Your new application is ready."));
	  
	//  return ok("Your new application is ready.");
  }
  
  public static Result showUser(String id) {
	return ok("Do you want to check User with id =="+id+"?\n");
	  }
  
  public static Result cities(){

      City pune=new City();
      pune.name="pune";
      pune.save();

      City mumbai=new City();
      mumbai.name="mumbai";
      mumbai.save();

      return ok(Json.toJson(City.all()));
    }
  
  public static Result showReturnedJsonObjects(){

      City pune=new City();
      pune.name="pune";
      pune.save();

      City mumbai=new City();
      mumbai.name="mumbai";
      mumbai.save();

      return ok(Json.toJson(City.all()));
    }
  
  public static Result showParsedCity(){
	  return ok(show.render());
	  
  }
  
  public static Result getStockData(){
	  String resultString =GoogleStockDataRetrieval.getStockDataForSpecificCompany("NASDAQ", "GOOG");
	 JsonNode jNode =  Json.parse(resultString);
	  
	  return ok(jNode);
  }
  }
  
