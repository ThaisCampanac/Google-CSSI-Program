
/**
 *  MinMagFilter implements Filter. This class has a variable called magMin, rep.
 *  the minimum mag of earthquakes to consider for filtering
 * 
 * @author Thais Campanac 
 */
public class MinMagFilter implements Filter
{
    private double magMin; 
    private String name;
    
    //the class' constructor
    public MinMagFilter(double min) { 
        magMin = min;
        name = "MinMagFilter";
    } 
    
    //the required function for the class
    public boolean satisfies(QuakeEntry qe) { 
        return (qe.getMagnitude() >= magMin); 
    } 
    
    public String getName(){
        return name;
    }

}
