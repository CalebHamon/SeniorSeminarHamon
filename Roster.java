public class Roster {
    
    private String emailIn;
    private String nameIn;
    private String firIn;
    private String secIn;
    private String thiIn;
    private String fouIn;
    private String fifIn;
    private String firClass;
    private String secClass;
    private String thiClass;
    private String fouClass;
    private String fifClass;
    
    /*
     * Setting up for an Arraylist with everything that could be associated with the student
     */

    public Roster(String nameG, String emailG, String firCh, String secCh, String thiCh, String fouCh, String fifCh){
        emailIn = emailG;
        nameIn = nameG;
        firIn = firCh;
        secIn = secCh;
        thiIn = thiCh;
        fouIn = fouCh;
        fifIn = fifCh;
        firClass = "";
        secClass = "";
        thiClass = "";
        fouClass = "";
        fifClass = "";
    }

    public String toString(){
        return nameIn + " '" + emailIn + "' with first choice " + firIn;
    }

    public String retEmail(){
        return emailIn;
    }

    public String retName(){
        return nameIn;
    }

    public String retFir(){
        return firIn;
    }

    public void changeFir(){
        firIn = "";
    }
    
    public String retSec(){
        return secIn;
    }

    public void changeSec(){
        secIn = "";
    }

    public String retThi(){
        return thiIn;
    }

    public void changeThi(){
        thiIn = "";
    }

    public String retFou(){
        return fouIn;
    }

    public void changeFou(){
        fouIn = "";
    }

    public String retFif(){
        return fifIn;
    }

    public void changeFif(){
        fifIn = "";
    }

    public void changeFirClass(String class1){
        firClass = class1;
    }

    public String retClass1(){
        return firClass;
    }

    public void changeSecClass(String class2){
        secClass = class2;
    }

    public String retClass2(){
        return secClass;
    }

    public void changeThiClass(String class3){
        thiClass = class3;
    }

    public String retClass3(){
        return thiClass;
    }

    public void changeFouClass(String class4){
        fouClass = class4;
    }

    public String retClass4(){
        return fouClass;
    }

    public void changeFifClass(String class5){
        fifClass = class5;
    }

    public String retClass5(){
        return fifClass;
    }

    public void StudSchedule(){
        System.out.println("First Block:\n" + firClass + "\n\nSecond Block:\n" + secClass  + "\n\nThird Block:\n" + thiClass  + "\n\nFourth Block:\n" + fouClass  + "\n\nFifth Block:\n" + fifClass);
    }
}

