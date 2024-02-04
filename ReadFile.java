import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {

  public static ArrayList<Roster> roster = new ArrayList<Roster>();
  public static ArrayList<Roster> availRoster = new ArrayList<Roster>();
  public static ArrayList<Sessions> session = new ArrayList<Sessions>();
  public static ArrayList<Sessions> availSession = new ArrayList<Sessions>();
  public static ArrayList<TimeSesh> timeSlot = new ArrayList<TimeSesh>();
  public static int seshCounter = 1;

  public static void main(String[] args) {
    addRoster();
    addSession();
    for (int i = 0; i < 5; i++) {
      makeClasses();
    }
  }

  public static void addRoster() {
    try {
      File students = new File("students.txt");
      Scanner studReader = new Scanner(students);
      File email = new File("email.txt");
      Scanner emaReader = new Scanner(email);
      File firc = new File("firstChoice.txt");
      Scanner firReader = new Scanner(firc);
      File sc = new File("secondChoice.txt");
      Scanner secReader = new Scanner(sc);
      File tc = new File("thirdChoice.txt");
      Scanner thiReader = new Scanner(tc);
      File foc = new File("fourthChoice.txt");
      Scanner fouReader = new Scanner(foc);
      File fifc = new File("fifthChoice.txt");
      Scanner fifReader = new Scanner(fifc);
      while (studReader.hasNextLine()) {
        String firstData;
        String secondData;
        String thirdData;
        String fourthData;
        String fifthData;
        String studData = studReader.nextLine();
        String emailData = emaReader.nextLine();
        if (fifReader.hasNextLine()) {
          firstData = firReader.nextLine();
          secondData = secReader.nextLine();
          thirdData = thiReader.nextLine();
          fourthData = fouReader.nextLine();
          fifthData = fifReader.nextLine();
        } else {
          firstData = "";
          secondData = "";
          thirdData = "";
          fourthData = "";
          fifthData = "";
        }
        Roster b1 = new Roster(studData, emailData, firstData, secondData, thirdData, fourthData, fifthData);
        roster.add(b1);
        availRoster.add(b1);
      }
      studReader.close();
      emaReader.close();
      firReader.close();
      secReader.close();
      thiReader.close();
      fouReader.close();
      fifReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void addSession() {
    try {
      File sesObj = new File("sessionName.txt");
      Scanner sesScanner = new Scanner(sesObj);
      File alumObj = new File("alumName.txt");
      Scanner alScanner = new Scanner(alumObj);
      while (sesScanner.hasNextLine()) {
        String sesData = sesScanner.nextLine();
        int popScore = popScore(sesData);
        String alumNameStr = alScanner.nextLine();
        Sessions b1 = new Sessions(sesData, popScore, alumNameStr);
        session.add(b1);
        availSession.add(b1);
      }
      sesScanner.close();
      alScanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static boolean duplicateAlum(int checker, String class1, String class2, String class3, String class4) {
    if (session.get(checker).retAlum().equals(class1)) {
      return false;
    } else if (session.get(checker).retAlum().equals(class2)) {
      return false;
    } else if (session.get(checker).retAlum().equals(class3)) {
      return false;
    } else if (session.get(checker).retAlum().equals(class4)) {
      return false;
    } else {
      return true;
    }
  }

  public static boolean duplicateClass(int checker, String class1, String class2, String class3, String class4) {
    if (availSession.get(checker).retName().equals(class1)) {
      return false;
    } else if (availSession.get(checker).retName().equals(class2)) {
      return false;
    } else if (availSession.get(checker).retName().equals(class3)) {
      return false;
    } else if (availSession.get(checker).retName().equals(class4)) {
      return false;
    } else {
      return true;
    }
  }

  public static int popScore(String sesDataGet) {
    int maxStud = availRoster.size();
    int popScore = 0;
    for (int i = 0; i < maxStud; i++) {
      if (availRoster.get(i).retFir().equals(sesDataGet)) {
        popScore = popScore + 5;
      } else if (availRoster.get(i).retSec().equals(sesDataGet)) {
        popScore = popScore + 4;
      } else if (availRoster.get(i).retThi().equals(sesDataGet)) {
        popScore = popScore + 3;
      } else if (availRoster.get(i).retFou().equals(sesDataGet)) {
        popScore = popScore + 2;
      } else if (availRoster.get(i).retFif().equals(sesDataGet)) {
        popScore = popScore + 1;
      }
    }
    return popScore;
  }

  public static void transferRoster(String class1, String class2, String class3, String class4, String class5){
    ArrayList<String> b1 = new ArrayList<String>();
    ArrayList<String> b2 = new ArrayList<String>();
    ArrayList<String> b3 = new ArrayList<String>();
    ArrayList<String> b4 = new ArrayList<String>();
    ArrayList<String> b5 = new ArrayList<String>();
    for (int i = 0; i < session.size(); i++){
      if(session.get(i).retName().equals(class1)){
        b1 = session.get(i).retPeep();
      }
    }
    for (int i = 0; i < session.size(); i++){
      if(session.get(i).retName().equals(class2)){
        b2 = session.get(i).retPeep();
      }
    }
    for (int i = 0; i < session.size(); i++){
      if(session.get(i).retName().equals(class3)){
        b3 = session.get(i).retPeep();
      }
    }
    for (int i = 0; i < session.size(); i++){
      if(session.get(i).retName().equals(class4)){
        b4 = session.get(i).retPeep();
      }
    }
    for (int i = 0; i < session.size(); i++){
      if(session.get(i).retName().equals(class5)){
        b5 = session.get(i).retPeep();
      }
    }
    timeSlot.get(seshCounter-1).addTimeRost(b1, b2, b3, b4, b5);
  }

  public static void makeClasses() {
    int tempPlace = 0;
    for (int i = 0; i < availSession.size(); i++) {
      if (availSession.get(tempPlace).retPop() < availSession.get(i).retPop()) {
        tempPlace = i;
      }
    }
    String class1 = availSession.get(tempPlace).retName();
    String alumData1 = availSession.get(tempPlace).retAlum();
    addMates(tempPlace);
    availSession.remove(tempPlace);
    for(int i = 0; i < availSession.size(); i++){
      availSession.get(i).updatePop(popScore(availSession.get(i).retName()));
    }
    tempPlace = 0;
    for (int i = 0; i < availSession.size(); i++) {
        if (availSession.get(tempPlace).retPop() < availSession.get(i).retPop()) {
          if (duplicateAlum(i, alumData1, alumData1, alumData1, alumData1)) {
            tempPlace = i;
          }
        }
    }
    String class2 = availSession.get(tempPlace).retName();
    String alumData2 = availSession.get(tempPlace).retAlum();
    addMates(tempPlace);
    availSession.remove(tempPlace);
    for(int i = 0; i < availSession.size(); i++){
      availSession.get(i).updatePop(popScore(availSession.get(i).retName()));
    }
    tempPlace = 0;
    for (int i = 1; i < availSession.size(); i++) {
      if (duplicateClass(i, class1, class2, class1, class2)) {
        if (availSession.get(tempPlace).retPop() < availSession.get(i).retPop()) {
          if (duplicateAlum(i, alumData1, alumData2, alumData1, alumData1)) {
            tempPlace = i;
          }
        }
      }
    }
    String class3 = availSession.get(tempPlace).retName();
    String alumData3 = availSession.get(tempPlace).retAlum();
    addMates(tempPlace);
    availSession.remove(tempPlace);
    for(int i = 0; i < availSession.size(); i++){
      availSession.get(i).updatePop(popScore(availSession.get(i).retName()));
    }
    tempPlace = 0;
    for (int i = 1; i < availSession.size(); i++) {
      if (duplicateClass(i, class1, class2, class3, class3)) {
        if (availSession.get(tempPlace).retPop() < availSession.get(i).retPop()) {
          if (duplicateAlum(i, alumData1, alumData2, alumData3, alumData1)) {
            tempPlace = i;
          }
        }
      }
    }
    String class4 = availSession.get(tempPlace).retName();
    String alumData4 = availSession.get(tempPlace).retAlum();
    addMates(tempPlace);
    availSession.remove(tempPlace);
    for(int i = 0; i < availSession.size(); i++){
      availSession.get(i).updatePop(popScore(availSession.get(i).retName()));
    }
    tempPlace = 0;
    for (int i = 1; i < availSession.size(); i++) {
      if (duplicateClass(i, class1, class2, class3, class4)) {
        if (availSession.get(tempPlace).retPop() < availSession.get(i).retPop()) {
          if (duplicateAlum(i, alumData1, alumData2, alumData3, alumData4)) {
            tempPlace = i;
          }
        }
      }
    }
    String class5 = availSession.get(tempPlace).retName();
    addMates(tempPlace);
    for(int i = 0; i < session.size(); i++){
      session.get(i).updatePop(popScore(session.get(i).retName()));
    }
    TimeSesh b1 = new TimeSesh(seshCounter, class1, class2, class3, class4, class5);
    timeSlot.add(b1);
    transferRoster(class1, class2, class3, class4, class5);
    removeMates();
    seshCounter++;
    availRoster = roster;
    availSession = session;
  }

  public static void addMates(int temp) {
    int getInt = 0;
    for(int i = 0; i < session.size(); i++){
      if(availSession.get(temp).retName().equals(session.get(i).retName())){
        getInt = i;
      }
    }
    temp = getInt;
    int occ = 0;
    for (int i = 0; i < availRoster.size(); i++) {
      if (occ < 16) {
        if (availRoster.get(i).retFir().equals(session.get(temp).retName())) {
          session.get(temp).addPeep(availRoster.get(i).retName());
          for (int j = 0; j < roster.size(); j++) {
            if (roster.get(j).retName().equals(availRoster.get(i).retName())) {
              roster.get(j).changeFir();
              roster.get(j).updateClass(session.get(temp).retName());
            }
          }
          availRoster.remove(i);
          occ++;
        }
      }
    }
    for (int i = 0; i < availRoster.size(); i++) {
      if (occ < 16) {
        if (availRoster.get(i).retSec().equals(session.get(temp).retName())) {
          session.get(temp).addPeep(availRoster.get(i).retName());
          for (int j = 0; j < roster.size(); j++) {
            if (roster.get(j).retName().equals(availRoster.get(i).retName())) {
              roster.get(j).changeSec();
              roster.get(j).updateClass(session.get(temp).retName());
            }
          }
          availRoster.remove(i);
          occ++;
        }
      }
    }
    for (int i = 0; i < availRoster.size(); i++) {
      if (occ < 16) {
        if (availRoster.get(i).retThi().equals(session.get(temp).retName())) {
          session.get(temp).addPeep(availRoster.get(i).retName());
          for (int j = 0; j < roster.size(); j++) {
            if (roster.get(j).retName().equals(availRoster.get(i).retName())) {
              roster.get(j).changeThi();
              roster.get(j).updateClass(session.get(temp).retName());
            }
          }
          availRoster.remove(i);
          occ++;
        }
      }
    }
    for (int i = 0; i < availRoster.size(); i++) {
      if (occ < 16) {
        if (availRoster.get(i).retFou().equals(session.get(temp).retName())) {
          session.get(temp).addPeep(availRoster.get(i).retName());
          for (int j = 0; j < roster.size(); j++) {
            if (roster.get(j).retName().equals(availRoster.get(i).retName())) {
              roster.get(j).changeFou();
              roster.get(j).updateClass(session.get(temp).retName());
            }
          }
          availRoster.remove(i);
          occ++;
        }
      }
    }
    for (int i = 0; i < availRoster.size(); i++) {
      if (occ < 16) {
        if (availRoster.get(i).retFif().equals(session.get(temp).retName())) {
          session.get(temp).addPeep(availRoster.get(i).retName());
          for (int j = 0; j < roster.size(); j++) {
            if (roster.get(j).retName().equals(availRoster.get(i).retName())) {
              roster.get(j).changeFif();
              roster.get(j).updateClass(session.get(temp).retName());
            }
          }
          availRoster.remove(i);
          occ++;
        }
      }
    }
    if (occ < 16) {
      for (int i = 0; i < availRoster.size(); i++) {
        if (occ < 16) {
          session.get(temp).addPeep(availRoster.get(i).retName());
          for (int j = 0; j < roster.size(); j++) {
            if (roster.get(j).retName().equals(availRoster.get(i).retName())) {
              roster.get(j).updateClass(session.get(temp).retName());
            }
          }
          availRoster.remove(i);
          occ++;
        }
      }
    }
  }

  public static void removeMates(){
    for (int i = 0; i < session.size(); i++){
      session.get(i).retPeep().clear();
    }
  }
}
