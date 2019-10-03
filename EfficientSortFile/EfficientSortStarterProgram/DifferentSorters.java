
/**
 * This is the tester class/main class that executes all sorters
 * 
 * @author Thais Campanac-Climent
 * @version June 2019
 */

import java.util.*;

public class DifferentSorters {
    public void sortWithCompareTo() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list);
        
        //int quakeNumber = 10;
        int quakenumber = 600;
        System.out.println("Print quake entry in position " + quakenumber);
        System.out.println(list.get(quakenumber));
        /*for(QuakeEntry qe: list) {
            System.out.println(qe);
        }*/

    }    

    public void sortByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new MagnitudeComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }

    public void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }
    
    public void sortByTitleAndDepth(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/earthQuakeDataWeekDec6sample2.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new TitleAndDepthComparator());
        /* for(QuakeEntry qe: list) {
            System.out.println(qe);
        }*/
        
        //int quakenumber = 10;
        int quakenumber = 500;
        System.out.println("Print quake entry in position " + quakenumber);
        System.out.println(list.get(quakenumber));
       
    }
    
    public void sortByLastWordInTitleByMagnitude(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new TitleLastAndMagnitudeComparator());
        /*for(QuakeEntry qe: list) {
            System.out.println(qe);
        }*/
        
        //int quakenumber =10;
        int quakenumber = 500;
        System.out.println("Print quake entry in position " + quakenumber);
        System.out.println(list.get(quakenumber));
    }
}
