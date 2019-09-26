import java.util.*;
import edu.duke.*;
/*
 * @author Thais Campanac
 * 
 * This is the client class for the earthquake data
 */

public class EarthQuakeClient2 {
    
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        Filter mag = new MagnitudeFilter(3.5,4.5);
        Filter depth = new DepthFilter(-55000.0,-20000.0);
        ArrayList<QuakeEntry> test1 = filter(list, mag);
        ArrayList<QuakeEntry> test2 = filter(test1, depth);
        //Filter f = new MinMagFilter(4.0); 
        //ArrayList<QuakeEntry> test1  = filter(list, f); 
        //String whe = new String("end");
        //String phas = new String("a");
        //PhraseFilter pha = new PhraseFilter(whe, phas);
        //Location loc = new Location(39.7392,-104.9903);
        //DistanceFilter dis = new DistanceFilter(loc, 1000000);
        //ArrayList<QuakeEntry> test1 = filter(list, pha);
        //ArrayList<QuakeEntry> test2 = filter(m7, dis);
        for (QuakeEntry qe: test2) { 
            System.out.println(qe);
        } 
        System.out.println("read data for "+test2.size()+" quakes");
        
    }
    
    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        MatchAllFilter maf = new MatchAllFilter();
        
        //starting to add the filters
        maf.addFilter(new MagnitudeFilter(1.0, 4.0));
        maf.addFilter(new DepthFilter(-180000.0,-30000.0));
        String where = new String("any");
        String phase = new String("o");
        maf.addFilter(new PhraseFilter(where, phase));
        
        ArrayList<QuakeEntry> test1 = filter(list, maf);
        for (QuakeEntry qe: test1) { 
            System.out.println(qe);
        } 
        System.out.println("read data for "+test1.size()+" quakes");
        System.out.println("Filters used are: " + maf.getName());
    }
    
    public void testMatchAllFilter2(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        MatchAllFilter maf = new MatchAllFilter();
        
        //starting to add the filters
        maf.addFilter(new MagnitudeFilter(0.0, 5.0));
        Location loc = new Location(55.7308,9.1153);
        maf.addFilter(new DistanceFilter(loc, 3000000.0));
        String where = new String("any");
        String phase = new String("e");
        maf.addFilter(new PhraseFilter(where, phase));
        
        ArrayList<QuakeEntry> test2 = filter(list, maf);
        for (QuakeEntry qe: test2) { 
            System.out.println(qe);
        } 
        System.out.println("read data for "+test2.size()+" quakes");
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
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
