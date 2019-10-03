
/**
 * This comparator calls onto another compare class called double to return a positive, negative, of 0 value based on two earthquakes
 * 
 * @author Thais Campanac-Climent 
 * @version June 2019
 */

import java.util.*;

public class MagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        return Double.compare(qe1.getMagnitude(), qe2.getMagnitude());
    }
}
