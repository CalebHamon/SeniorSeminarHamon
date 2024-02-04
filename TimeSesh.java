import java.util.ArrayList;

public class TimeSesh {
    
    private int slotIn;
    private String classIn1;
    private String classIn2;
    private String classIn3;
    private String classIn4;
    private String classIn5;
    public  ArrayList<String> class1Roster;
    public  ArrayList<String> class2Roster;
    public  ArrayList<String> class3Roster;
    public  ArrayList<String> class4Roster;
    public  ArrayList<String> class5Roster;


    public TimeSesh(int timeSlot, String class1, String class2, String class3, String class4, String class5){
        slotIn = timeSlot;
        classIn1 = class1;
        classIn2 = class2;
        classIn3 = class3;
        classIn4 = class4;
        classIn5 = class5;
        class1Roster = new ArrayList<String>();
        class2Roster = new ArrayList<String>();
        class3Roster = new ArrayList<String>();
        class4Roster = new ArrayList<String>();
        class5Roster = new ArrayList<String>();
    }

    public void addTimeRost(ArrayList<String> roster1, ArrayList<String> roster2, ArrayList<String> roster3, ArrayList<String> roster4, ArrayList<String> roster5){
        class1Roster = roster1;
        class2Roster = roster2;
        class3Roster = roster3;
        class4Roster = roster4;
        class5Roster = roster5;
    }

    public int getPeep1Size(){
        return class1Roster.size();
    }

    public String getPeep1(int i){
       return class1Roster.get(i);
    }

    public int whatTime() {
        return slotIn;
    }

    public String whatClasses() {
        return classIn1 + " \n" + classIn2 + " \n" + classIn3 + " \n" + classIn4 + " \n" + classIn5;
    }
}
