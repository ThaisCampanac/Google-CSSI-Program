
/**
 * Filter is an interface class that has two functions called satisfies and get
 * name
 * 
 * @author Thais Campanac-Climent 
 * @version June
 */
public interface Filter
{
    public  boolean satisfies(QuakeEntry qe); 
    public String getName();
}
