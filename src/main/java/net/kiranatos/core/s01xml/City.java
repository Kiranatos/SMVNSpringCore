package net.kiranatos.core.s01xml;

//import java.util.ArrayList;
//String text = String.format( " Пример %s, %d, %td, %f " , "текст", 15, new Date(), 6.05);
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

public interface City {    
    public String getName();    
}

enum Music { JPOP, JROCK, KPOP, KROCK }

class Tokyo implements City { // [XML1000]    
    private List<String> shops;
    private List<Random> ran;
    private List<City> cities;
    private Set<String> prefs;
    private Map<Music, City> exMap;
    private Properties props;

    public Tokyo(List<Random> ran, Random rNull) {        
        System.out.println("\t- Injection of List (" + ran.getClass().getSimpleName() + ") with Inner-Beans: ");
        for (Random r: ran) {
            System.out.println("\t\t" + r);
        }
        System.out.println("\t- Injection of NULL: " + rNull);
        this.ran = ran;
    }
    
    public void setShops(List<String> shops) {        
        System.out.print("\t- Injection of List (" + shops.getClass().getSimpleName() + ") with Simple Values: ");        
        for (String shop: shops) {
            System.out.print(shop + " ");
        }
        System.out.println("");
        this.shops = shops;
    }
    
    public void setOneTown(List<City> city) {
        System.out.println("\t- Injection of List (" + city.getClass().getSimpleName() + ") with Other Beans: ");
        for (City c: city) {
            System.out.println("\t\t" + c);
        }        
        this.cities = city;
    }
    
    public void setPrefectures(Set<String> prefs) {
        System.out.print("\t- Injection of Set (" + prefs.getClass().getSimpleName() + ") with Simple Values: ");
        for (String p: prefs) {
            System.out.print(p + " ");
        }
        System.out.println("");
        this.prefs = prefs;
    }
    
    public void setExMap(Map<Music, City> exMap) {
        System.out.println("\t- Injection of Map (" + exMap.getClass().getSimpleName() + ") with Enum & Other Beans: ");
        for (Music m: exMap.keySet()) {
            System.out.println("\t\tkey=" + m.name() + "\t value = " + exMap.get(m));
        }        
        this.exMap = exMap;
    }
    
    public void setPropertiesMethod(Properties props) {
        System.out.println("\t- Injection of Properties (" + props.getClass().getSimpleName() + ") with String: ");        
        for (String p: props.stringPropertyNames()) {
            System.out.println("\t\t key=" + p + " :\tvalue=" + props.getProperty(p));
        }        
        this.props = props;
    }
    
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }    
} // end of class Tokyo

class Toyokawa implements City { // [XML1000]
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }    
} // end of class Toyokawa

class Nagoya implements City { // [XML1001]
    private int population;
    private String region, website;

    public void setWebsite(String website) {
        this.website = website;
    }

    public Nagoya(int population, String region) {
        this.population = population;
        this.region = region;
    }
    
    @Override
    public String getName() {        
        return String.format("%s population: %d, region: %s, site:%s",
                this.getClass().getSimpleName(), population, region, website);
    }    
} // end of class Nagoya

class Iwakura implements City { // [XML1002] Schemes and Namespaces UTIL
    private double pi;
    public void setMathPI(double pii) { this.pi = pii; }    
    @Override
    public String getName() {        
        return String.format("%s pi=%f ",
                this.getClass().getSimpleName(), pi);
    }    
} // end of class Iwakura

class Yokote  implements City { // [XML1003] Schemes and Namespaces p and c
    private int area, population;
    private String region, localEvent;
    private City city1, city2;
    
    public void setCityTwo(City city2)              { this.city2 = city2; }
    public void setPopulation(int population)       { this.population = population;  }
    public void setLocalEvent(String localEvent)    { this.localEvent = localEvent; }

    public Yokote(String region, int area, City cityOne) {
        this.region = region;
        this.city1 = cityOne;
        this.area = area;
    }
    
    @Override
    public String getName() {        
        return String.format("%s, Population: %d; Area: %d km2; %s; Local Event: %s; Neighboring municipalities: %s, %s ",
                this.getClass().getSimpleName(), population, area, region, localEvent, city1.getName(), city2.getName());
    }    
} // end of class Yokote 

class Daisen implements City { // [XML1003] help class
    @Override
    public String getName() {        
        return String.format("[helpCity]%s",this.getClass().getSimpleName());
    }    
} // end of class Daisen

class Ugo extends Daisen { /* [XML1003] help class */ }