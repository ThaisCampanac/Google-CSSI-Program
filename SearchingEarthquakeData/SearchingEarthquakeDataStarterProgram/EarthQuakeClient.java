import java.util.*;
import edu.duke.*;

/*
 * author: Thais Campanac
 * Purpose: To search through earthquake data by filtering the data
 */

public class EarthQuakeClient {
    
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for(QuakeEntry qe : quakeData)
        {
            if(qe.getMagnitude()>magMin)
            {
                answer.add(qe);
            }
        }

        return answer;
     }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,double distMax,Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for(QuakeEntry qe : quakeData){
            if(qe.getLocation().distanceTo(from)<distMax){
                answer.add(qe);
            }
        }
        
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,double minDepth, double maxDepth){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe:quakeData){
            if(qe.getDepth() <maxDepth && qe.getDepth()>minDepth){
                answer.add(qe);
            }
        }
        
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where, String phrase){
      ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
      for(QuakeEntry qe: quakeData){
          if(where.equals("start") && qe.getInfo().startsWith(phrase)){
              answer.add(qe);
            }
          else if(where.equals("end") && qe.getInfo().endsWith(phrase)){
              answer.add(qe);
            }
          else if(where.equals("any") && qe.getInfo().contains(phrase)){
              answer.add(qe);
            }
        }

      return answer;  
    }


        
        
    

    
    
    public void quakesByPhrase(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedatasmall.atom";
        String source= "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        
        System.out.println("read data for "+list.size()+" quakes");
        //String part = "end";
        //String state = "California";
        //String part = "start";
        //String state ="Explosion";
        String part="any";
        String state = "Can";
        ArrayList<QuakeEntry> secondlist = filterByPhrase(list,part,state);
        for(QuakeEntry qe: secondlist){
            System.out.println(qe);
        }
        System.out.println("read data for "+secondlist.size()+" quakes");
    }
    
    public void quakesOfDepth(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source= "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        
        System.out.println("read data for "+list.size()+" quakes");
        //ArrayList<QuakeEntry> firstlist = filterByDepth(list,-10000.0,-5000.0);
        ArrayList<QuakeEntry> secondlist = filterByDepth(list, -4000.0, -2000.0);
        for(QuakeEntry qe: secondlist){
            System.out.println(qe);
        }
        System.out.println("read data for "+secondlist.size()+" quakes");
    }

   public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
        for(QuakeEntry qe: listBig)
        {
            System.out.println(qe);
        }

    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        
        float distMax = 1000000; 
        //Location city = new Location(35.988, -78.907);
        Location city =  new Location(38.17, -118.82);
        ArrayList<QuakeEntry> listig = filterByDistanceFrom(list,distMax,city);
        for(QuakeEntry qe: listig){
            float dist = city.distanceTo(qe.getLocation());
            //dist is in meter so convert to kilometers
            dist = dist / 1000;
            System.out.println(dist + " " + qe.getInfo());
        }
        System.out.println("Found " + listig.size() + " that match that criteria");
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }
    
}
