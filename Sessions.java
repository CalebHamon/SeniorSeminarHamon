import java.util.ArrayList;

public class Sessions {
    private String nameIn;
    private int popIn;
    private String alumIn;
    public static ArrayList<String> roster;


    //Arraylist setup for each session
    public Sessions(String nameG, int popG, String alumG){
        nameIn = nameG;
        popIn = popG;
        alumIn = alumG;
        roster = new ArrayList<String>();
    }

    public void updatePop(int popG){
        popIn = popG;
    }

    public void addPeep(String perG){
        roster.add(perG);
    }    

    public ArrayList<String> retPeep(){
        return roster;
    }

    public String retName(){
        return nameIn;
    }

    public int retPop(){
        return popIn;
    }

    public String retAlum(){
        return alumIn;
    }
}
