
/**
 * This class implements a Comprator of type QuakeEntry and compares the titles of earthquake entries and alphebetize them
 * if they start with the same letter then they will be compared based on Depth size.
 * 
 * @author Thais Campanac 
 * @version June 2019
 */
import java.util.*;
public class TitleAndDepthComparator implements Comparator<QuakeEntry>{
    public int compare(QuakeEntry q1, QuakeEntry q2){
        int value = q1.getInfo().compareTo(q2.getInfo());
        if(value == 0){
            if(q1.getDepth()<q2.getDepth()){
                return -1;
            }
            else if(q1.getDepth()>q2.getDepth()){
                return 1;
            }
            else return 0;
        }
        return value;
    }
}
