package models;

import java.util.List;

import javax.persistence.Entity;
import play.db.ebean.*;
import play.db.ebean.Model.Finder;

@Entity
public class City extends Model{

public long id;

public String name;

public static Finder<Long, City> finder = new Finder(Long.class,City.class);

public static List<City> all(){
	
	return finder.all();
	
}

}
