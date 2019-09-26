import java.util.*;
import edu.duke.*;
/**
 * MatchAllFilter implements Filter and can store and apply many filters on the 
 * given earthquake data
 * 
 * @author Thais Campanac 
 */
public class MatchAllFilter implements Filter{
    private ArrayList<Filter> filters;
    
    public MatchAllFilter(){
        filters = new ArrayList<Filter>();
    }
    
    public void addFilter(Filter filter){
        filters.add(filter);
    }
    
    public boolean satisfies(QuakeEntry qe){
        for(Filter filter: filters){
            if(!filter.satisfies(qe)){
                return false;
            }
        }
        return true;
    }
    
    public String getName(){
        String name = "";
        for(Filter filter: filters){
            name += filter.getName() + " ";
        }
        return name;
    }
}
