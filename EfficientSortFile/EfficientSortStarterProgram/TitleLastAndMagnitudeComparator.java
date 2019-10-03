
/**
 * This class implements the comparator class and compares the earthquake data based on the lastword of the info and if they are the same then
 * the class will order them based them on magnitude
 * 
 * @author Thais Campanac-Climent 
 * @version June 2019
 */

import java.util.*;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2){
        //trying to condence the amount of methods called upon so...
        String Title1 = q1.getInfo();
        String Title2 = q2.getInfo();
        String Lastword1 = Title1.substring(Title1.lastIndexOf(" ")+1);
        String Lastword2 = Title2.substring(Title2.lastIndexOf(" ")+1);
        
        int value = Lastword1.compareTo(Lastword2);
        if(value == 0){
           if(q1.getMagnitude()>q2.getMagnitude()){
               return 1;
           }
           
           else if(q2.getMagnitude()<q2.getMagnitude()){
               return 0;
           }
           
           else return 0;
        }
        return value;
    }
}
