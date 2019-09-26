
/**
 * DepthFilter implements Filter and checks the depth of the earthquake
 * data
 * 
 * @author Thais Campanac
 */
public class DepthFilter implements Filter {
    private double minDepth;
    private double maxDepth;
    private String name;
    
    public DepthFilter(double min, double max){
        minDepth = min;
        maxDepth = max;
        name = "DepthFilter";
    }
    
    public boolean satisfies(QuakeEntry qe){
        if(qe.getDepth() >= minDepth && qe.getDepth() <= maxDepth){
        return true;
       }
       return false;
    }
    
    public String getName(){
        return name;
    }
}
