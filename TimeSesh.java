public class TimeSesh {
    
    private int slotIn;
    private String classIn1;
    private String classIn2;
    private String classIn3;
    private String classIn4;
    private String classIn5;

    public TimeSesh(int timeSlot, String class1, String class2, String class3, String class4, String class5){
        slotIn = timeSlot;
        classIn1 = class1;
        classIn2 = class2;
        classIn3 = class3;
        classIn4 = class4;
        classIn5 = class5;
    }

    public int whatTime() {
        return slotIn;
    }

    public String whatClasses() {
        return classIn1 + " " + classIn2 + " " + classIn3 + " " + classIn4 + " " + classIn5;
    }
}
