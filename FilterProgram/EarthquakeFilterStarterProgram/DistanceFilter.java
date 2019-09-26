
/**
 * DistanceFilter implement Filter and checks the distance of a given location
 * is less then the specified maximum distance
 * 
 * @author Thais Campanac 
 */
public class DistanceFilter implements Filter {
    private Location location;
    private double maxDistance;
    private String name;
    
    public DistanceFilter(Location loc, double dis){
        location = loc;
        maxDistance = dis;
        name = "DistanceFilter";
    }
    
    public boolean satisfies(QuakeEntry qe){
        //distance has to be in meters
        if(qe.getLocation().distanceTo(location)< maxDistance){
        return true;
        }
        return false;
    }
    
    public String getName(){
        return name;
    }
}
