import java.util.*;
import edu.duke.*;

/**
 * This class is to sort the quakes by depth, from largest depth to smallest depth
 * 
 * @author Thais Campanac 
 * @version June 2019
 */

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }
    
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
        if(!checkInSortedOrder(in)){
            int times = 0;
            for (int i=0; i< in.size(); i++) {
                int minIndex = getSmallestMagnitude(in,i);
                QuakeEntry originalIndex = in.get(i);
                QuakeEntry newMin = in.get(minIndex);
                in.set(i,newMin);
                in.set(minIndex,originalIndex);
                times++;
                if(checkInSortedOrder(in)){
                    System.out.println("the number of passes needed" + times);
                    break;
                }
            }
       }
    }
    
    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int from){
        int biggestDepth = from;
        for(int x=from + 1; x<quakeData.size(); x++){
            //the depth of the index of the loop
            double depth = quakeData.get(x).getDepth();
            //the depth of the index of the already declared biggest index
            double maxDepth = quakeData.get(biggestDepth).getDepth();
            // simple comparison
            if (depth > maxDepth) {
                biggestDepth = x; 
            }
        }
        
        return biggestDepth;
    }
    
    public void sortByLargestDepth(ArrayList<QuakeEntry> in){
        for(int i=0; i<50; i++){
            //find the biggest depth
            int bigDepth = getLargestDepth(in,i);
            //time to switch the values
            QuakeEntry current = in.get(i);
            QuakeEntry max = in.get(bigDepth);
            in.set(i,max);
            in.set(bigDepth,current);
        }
    }
    
    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, int numSorted){
        for(int x= 0; x<quakeData.size()-1-numSorted; x++){
            if(quakeData.get(x).getMagnitude()>quakeData.get(x+1).getMagnitude()){
                //switching the values
                QuakeEntry originalMin = quakeData.get(x);
                QuakeEntry newMin = quakeData.get(x+1);
                quakeData.set(x, newMin);
                quakeData.set(x+1, originalMin);
            }
        }
    }
    
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
        int times = 0;
        for(int x= 0; x< in.size()-1; x++){
            System.out.println("The number of passes:" + times);
            for(int y = 0; y<in.size(); y++){
                System.out.println(in.get(y));
            }
            onePassBubbleSort(in, times);
            times++;
        }
    }
    
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in){
        if(!checkInSortedOrder(in)){
            int times = 0;
            for(int x= 0; x< in.size()-1; x++){
                /*
                for(int y = 0; y<in.size(); y++){
                System.out.println(in.get(y));
                }*/
                System.out.println("the number of passes:" + times);
                onePassBubbleSort(in, times);
                times++;
                if(checkInSortedOrder(in)){
                    System.out.println("the number of passes needed " + times);
                    break;
                }
            }  
        }
    }
    
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes){
        for(int x = 0; x< quakes.size()-1; x++){
            if(quakes.get(x).getMagnitude() > quakes.get(x+1).getMagnitude()){
                return false;
            }
        }
        return true;
    }
    


    public void testSort() {
         EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "data/earthquakeDataSampleSix2.atom";
        //String source = "data/earthquakeDataSampleSix1.atom";
        //String source = "data/nov20quakedata.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/earthQuakeDataDec6sample2.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        sortByLargestDepth(list);
        //sortByMagnitudeWithBubbleSort(list);
        //sortByMagnitudeWithBubbleSortWithCheck(list);
        //sortByMagnitudeWithCheck(list);
        System.out.println("EarthQuakes in sorted order: ");
        for (QuakeEntry qe: list) { 
            System.out.println(qe); 
        
        }
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
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
