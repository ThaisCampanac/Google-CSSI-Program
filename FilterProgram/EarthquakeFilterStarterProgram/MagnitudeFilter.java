
/**
 * MagnitudeFilter implements Filter and it checks the mag of the earthquake
 * data
 * 
 * @author Thais Campanac 
 */
public class MagnitudeFilter implements Filter{
    private double minMag;
    private double maxMag;
    private String name;
    
    public MagnitudeFilter(double min, double mag){
        minMag=min;
        maxMag=mag;
        name = "MagnitudeFilter";
    }
    
     public boolean satisfies(QuakeEntry qe){
        if(qe.getMagnitude() <= maxMag && qe.getMagnitude() >= minMag){
        return true;
       }
       return false;
    }
    
    public String getName(){
        return name;
    }
}
