public class Sessions {
    private String nameIn;
    private int popIn;
    private String alumIn;

    public Sessions(String nameG, int popG, String alumG){
        nameIn = nameG;
        popIn = popG;
        alumIn = alumG;
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
