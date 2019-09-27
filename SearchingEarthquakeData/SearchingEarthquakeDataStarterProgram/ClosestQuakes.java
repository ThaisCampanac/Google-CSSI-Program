import java.util.*;

/**
 * Find N-closest quakes
 * 
 * @author Thais Campanac
 * @version 1.1, June 2019
 */

public class ClosestQuakes {
    public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany) {
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TO DO
        //outer loop meant to find the number of earthquakes wanted
        for( int q=0; q<howMany;q++){
            //to keep track of the index of the minimum
            int minIndex = 0;
            
            //inner loop is to find the minimum distance in the entire ArrayList
            for(int k=1; k<copy.size();k++){
                QuakeEntry quake = copy.get(k);
                if (quake.getLocation().distanceTo(current)<copy.get(minIndex).getLocation().distanceTo(current)){
                    minIndex=k;
                }
           }
           
           //to add the minimum earthquake in the answer but also make sure that the 
           //minimum earthquake is not repeated
           answer.add(quakeData.get(minIndex));
           copy.remove(minIndex);
        }

        return answer;
    }

    public void findClosestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        
        System.out.println("read data for "+list.size());

        Location jakarta  = new Location(-6.211,106.845);

        ArrayList<QuakeEntry> close = getClosest(list,jakarta,3);
        for(int k=0; k < close.size(); k++){
            QuakeEntry entry = close.get(k);
            double distanceInMeters = jakarta.distanceTo(entry.getLocation());
            System.out.printf("%4.2f\t %s\n", distanceInMeters/1000,entry);
        }
        System.out.println("number found: "+close.size());
    }
    
}
