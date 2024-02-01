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

  public static void makeClasses() {
    int tempPlace = 0;
    for (int i = 1; i < session.size(); i++) {
      if (session.get(tempPlace).retPop() < session.get(i).retPop()) {
        tempPlace = i;
      }
    }
    String class1 = session.get(tempPlace).retName();
    addMates(tempPlace);
    availSession.remove(tempPlace);
    tempPlace = 0;
    for (int i = 1; i < availSession.size(); i++) {
      if (availSession.get(tempPlace).retPop() < session.get(i).retPop()) {
        tempPlace = i;
      }
    }
    String class2 = session.get(tempPlace).retName();
    addMates(tempPlace);
    availSession.remove(tempPlace);
    tempPlace = 0;
    for (int i = 1; i < availSession.size(); i++) {
      if (availSession.get(tempPlace).retPop() < session.get(i).retPop()) {
        tempPlace = i;
      }
    }
    String class3 = session.get(tempPlace).retName();
    addMates(tempPlace);
    availSession.remove(tempPlace);
    tempPlace = 0;
    for (int i = 1; i < availSession.size(); i++) {
      if (availSession.get(tempPlace).retPop() < session.get(i).retPop()) {
        tempPlace = i;
      }
    }
    String class4 = session.get(tempPlace).retName();
    addMates(tempPlace);
    availSession.remove(tempPlace);
    tempPlace = 0;
    for (int i = 1; i < availSession.size(); i++) {
      if (availSession.get(tempPlace).retPop() < session.get(i).retPop()) {
        tempPlace = i;
      }
    }
    String class5 = session.get(tempPlace).retName();
    addMates(tempPlace);
    availSession.remove(tempPlace);
    tempPlace = 0;
    TimeSesh b1 = new TimeSesh(seshCounter, class1, class2, class3, class4, class5);
    timeSlot.add(b1);
    seshCounter++;
  }

  public static void addMates(int temp) {
    int occ = 0;
    int startInt = availRoster.size();
    for (int i = 0; i < startInt; i++) {
      if (occ < 16) {
        if (roster.get(i).retFir().equals(session.get(temp).retName())) {
          session.get(temp).addPeep(roster.get(i).retName());
          availRoster.remove(i);
          occ++;
        }
      }
    }
    startInt = availRoster.size();
    for (int i = 0; i < startInt; i++) {
      if (occ < 16) {
        if (roster.get(i).retSec().equals(session.get(temp).retName())) {
          session.get(temp).addPeep(roster.get(i).retName());
          availRoster.remove(i);
          occ++;
        }
      }
    }
    startInt = availRoster.size();
    for (int i = 0; i < startInt; i++) {
      if (occ < 16) {
        if (roster.get(i).retThi().equals(session.get(temp).retName())) {
          session.get(temp).addPeep(roster.get(i).retName());
          availRoster.remove(i);
          occ++;
        }
      }
    }
    startInt = availRoster.size();
    for (int i = 0; i < startInt; i++) {
      if (occ < 16) {
        if (roster.get(i).retFou().equals(session.get(temp).retName())) {
          session.get(temp).addPeep(roster.get(i).retName());
          availRoster.remove(i);
          occ++;
        }
      }
    }
    startInt = availRoster.size();
    for (int i = 0; i < startInt; i++) {
      if (occ < 16) {
        if (roster.get(i).retFif().equals(session.get(temp).retName())) {
          session.get(temp).addPeep(roster.get(i).retName());
          availRoster.remove(i);
          occ++;
        }
      }
    }
    startInt = availRoster.size();
    if (occ < 16) {
      for (int i = 0; i < startInt; i++) {
        if (occ < 16) {
          session.get(temp).addPeep(roster.get(i).retName());
          availRoster.remove(i);
          occ++;
        }
      }
    }
    for (int i = 0; i > session.size(); i++) {
      session.get(i).updatePop(popScore(session.get(i).retName()));
      availSession.get(i).updatePop(popScore(availRoster.get(i).retName()));
    }
  }
}
