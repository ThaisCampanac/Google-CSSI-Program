import java.util.*;
import edu.duke.*;

/**
 * It is a class that has methods to determine the N biggest earthquakes, those
 * with largest magnitude
 * 
 * @author Thais Campanac
 * @version June 2019
 */

public class LargestQuake {
public void findLargestQuake(){
    EarthQuakeParser parser = new EarthQuakeParser();
    //String source = "data/nov20quakedatasmall.atom";
    String source= "data/nov20quakedata.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    
    /*for(QuakeEntry qe: list){
        System.out.println(qe);
    }*/
    System.out.println("read data for "+list.size()+" quakes");
    //int indexofgreatest = indexOfLargest(list);
    //System.out.println(list.get(indexofgreatest));
    ArrayList<QuakeEntry> secondlist = getLargest(list,50);
    for(QuakeEntry qe:secondlist){
        System.out.println(qe);
    }
    System.out.println("number of earthquakes" + secondlist.size());
}

public int indexOfLargest(ArrayList<QuakeEntry> data){
  int maxindex=0;
  for(int z=0; z<data.size();z++){
      if(data.get(z).getMagnitude()>data.get(maxindex).getMagnitude()){
          maxindex = z;
        }
    }
  return maxindex;
}

public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howmany){
    ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
    
    //for quakeData smaller than howmany
    if(quakeData.size()<howmany){
        for(int x= 0;x<quakeData.size();x++){
            int index = indexOfLargest(quakeData);
            answer.add(quakeData.get(index));
            quakeData.remove(index);
        }
    }
    //for quakeData larger than howmany
    else{
        for(int x=0; x<howmany;x++){
            int index = indexOfLargest(quakeData);
            answer.add(quakeData.get(index));
            quakeData.remove(index);
        }
    }
    return answer;
}
}
