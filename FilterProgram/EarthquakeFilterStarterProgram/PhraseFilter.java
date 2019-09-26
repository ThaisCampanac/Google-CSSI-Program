
/**
 * PhraseFilter implements Filter and checks for certain phrases inside the 
 * earthquake data
 * 
 * @author Thais Campanac
 */
public class PhraseFilter implements Filter {
    private String where;
    private String phrase;
    private String name;
    
    public PhraseFilter(String area, String word){
        where = area;
        phrase = word;
        name = "PhraseFilter";
    }
    
    public boolean satisfies(QuakeEntry qe){
        if(where.equals("start") && qe.getInfo().startsWith(phrase)){
            return true;
        }
        if(where.equals("end") && qe.getInfo().endsWith(phrase)){
            return true;
        }
        if(where.equals("any") && qe.getInfo().contains(phrase)){
            return true;
        }
       return false;
    }
    
    public String getName(){
        return name;
    }
}
