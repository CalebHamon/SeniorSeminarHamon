public class Sessions {
    private String nameIn;
    private int popIn;
    private String alumIn;
    private int peepIn;

    public Sessions(String nameG, int popG, String alumG){
        nameIn = nameG;
        popIn = popG;
        alumIn = alumG;
        peepIn = 0;
    }

    public void addPeep(){
        peepIn++;
    }    

    public int retPeep(){
        return peepIn;
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
