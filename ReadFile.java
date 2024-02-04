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
    System.out.println();
    addSession();
    for (int i = 0; i < 5; i++) {
      makeClasses();
    }
    // masterSched();
    classLookup();
    // studSearch();

  }

  public static void masterSched() {
    try (Scanner scan = new Scanner(System.in)) {
      String yesser = "y";
      System.out.println("Would you like the Master Schedule? (y/n)");
      System.out.println("The classes will be arranged in order of time (first set is period 1, etc)");
      yesser = scan.nextLine();
      if (yesser.equals("y")) {
        System.out.println("\n");
        System.out.println(timeSlot.get(0).whatClasses() + "\n\n\n\n");
        System.out.println(timeSlot.get(1).whatClasses() + "\n\n\n\n");
        System.out.println(timeSlot.get(2).whatClasses() + "\n\n\n\n");
        System.out.println(timeSlot.get(3).whatClasses() + "\n\n\n\n");
        System.out.println(timeSlot.get(4).whatClasses() + "\n\n\n\n");
      }
    }
  }

  public static void classLookup() {
    try (Scanner scan = new Scanner(System.in)) {
      String yesser = "y";
      int lastOne = 0;
      int key = 0;
      do {
        System.out.println("Would you like to search for a session's schedule? (y/n)");
        yesser = scan.nextLine();
        if (yesser.equals("y")) {
          key = 1; 
          do {
            System.out.println("What time slot is the session in (1, 2, 3, 4, 5)? (please use number 1, 2, etc)");
            lastOne = scan.nextInt();
          } while (!(lastOne >= 1) && !(lastOne <= 5));
          classLookupP2(lastOne);
        }
        else{
          key = 0;
        }
      } while (!(key == 1));
    }
  }

  public static void classLookupP2(int lastOne) {
    try (Scanner scan = new Scanner(System.in)) {
      String seshName;
      System.out.println("What is the session name? (Write it exactly how it is)");
      seshName = scan.nextLine();
      if (lastOne == 1) {
        for (int i = 0; i < roster.size(); i++) {
          if (seshName.equals(roster.get(i).retClass1())) {
            System.out.println(roster.get(i).retName());
          }
        }
      }
      if (lastOne == 2) {
        for (int i = 0; i < roster.size(); i++) {
          if (seshName.equals(roster.get(i).retClass2())) {
            System.out.println(roster.get(i).retName());
          }
        }
      }
      if (lastOne == 3) {
        for (int i = 0; i < roster.size(); i++) {
          if (seshName.equals(roster.get(i).retClass3())) {
            System.out.println(roster.get(i).retName());
          }
        }
      }
      if (lastOne == 4) {
        for (int i = 0; i < roster.size(); i++) {
          if (seshName.equals(roster.get(i).retClass4())) {
            System.out.println(roster.get(i).retName());
          }
        }
      }
      if (lastOne == 5) {
        for (int i = 0; i < roster.size(); i++) {
          if (seshName.equals(roster.get(i).retClass5())) {
            System.out.println(roster.get(i).retName());
          }
        }
      }
    }
  }

  public static void studSearch() {
    try (Scanner scan = new Scanner(System.in)) {
      String yesser = "y";
      String person;
      do {
        System.out.println("Would you like to search for a student's schedule? (y/n)");
        yesser = scan.nextLine();
        if (yesser.equals("y")) {
          System.out.println("Who would you like to search up (Must be first, middle and last name!)");
          person = scan.nextLine();
          for (int i = 0; i < roster.size(); i++) {
            if (person.equals(roster.get(i).retName())) {
              System.out.println("\n\n\n");
              roster.get(i).StudSchedule();
              System.out.println();
            }
          }
        }
      } while (yesser.equals("y"));
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
        if (seshCounter == 1) {
          roster.add(b1);
        }
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

  public static int availConverter(int temp) {
    int perm = 0;
    for (int i = 0; i < session.size(); i++) {
      if (session.get(i).retName().equals(availSession.get(temp).retName())) {
        perm = i;
      }
    }
    return perm;
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
    addMates(availConverter(tempPlace));
    availSession.remove(tempPlace);
    for (int i = 0; i < availSession.size(); i++) {
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
    addMates(availConverter(tempPlace));
    availSession.remove(tempPlace);
    for (int i = 0; i < availSession.size(); i++) {
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
    addMates(availConverter(tempPlace));
    availSession.remove(tempPlace);
    for (int i = 0; i < availSession.size(); i++) {
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
    addMates(availConverter(tempPlace));
    availSession.remove(tempPlace);
    for (int i = 0; i < availSession.size(); i++) {
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
    addMates(availConverter(tempPlace));
    for (int i = 0; i < session.size(); i++) {
      session.get(i).updatePop(popScore(session.get(i).retName()));
    }
    TimeSesh b1 = new TimeSesh(seshCounter, class1, class2, class3, class4, class5);
    timeSlot.add(b1);
    seshCounter++;
    addRoster();
    availSession = session;
  }

  public static void addClasses(int j, int temp) {
    if (seshCounter == 1) {
      roster.get(j).changeFirClass(session.get(temp).retName());
    }
    if (seshCounter == 2) {
      roster.get(j).changeSecClass(session.get(temp).retName());
    }
    if (seshCounter == 3) {
      roster.get(j).changeThiClass(session.get(temp).retName());
    }
    if (seshCounter == 4) {
      roster.get(j).changeFouClass(session.get(temp).retName());
    }
    if (seshCounter == 5) {
      roster.get(j).changeFifClass(session.get(temp).retName());
    }
  }

  public static boolean inClass(int temp, int alTh) {
    if (session.get(temp).retName().equals(roster.get(alTh).retClass1())) {
      return false;
    } else if (session.get(temp).retName().equals(roster.get(alTh).retClass2())) {
      return false;
    } else if (session.get(temp).retName().equals(roster.get(alTh).retClass3())) {
      return false;
    } else if (session.get(temp).retName().equals(roster.get(alTh).retClass4())) {
      return false;
    } else if (session.get(temp).retName().equals(roster.get(alTh).retClass5())) {
      return false;
    } else {
      return true;
    }
  }

  public static boolean isFilled(int temp) {
    int occ = 0;
    if (seshCounter == 1) {
      for (int i = 0; i < roster.size(); i++) {
        if (session.get(temp).retName().equals(roster.get(i).retClass1())) {
          occ = occ + 1;
        }
      }
      if (occ >= 16) {
        return false;
      } else {
        return true;
      }
    }
    if (seshCounter == 2) {
      for (int i = 0; i < roster.size(); i++) {
        if (session.get(temp).retName().equals(roster.get(i).retClass2())) {
          occ = occ + 1;
        }
      }
      if (occ >= 16) {
        return false;
      } else {
        return true;
      }
    }
    if (seshCounter == 3) {
      for (int i = 0; i < roster.size(); i++) {
        if (session.get(temp).retName().equals(roster.get(i).retClass3())) {
          occ = occ + 1;
        }
      }
      if (occ >= 16) {
        return false;
      } else {
        return true;
      }
    }
    if (seshCounter == 4) {
      for (int i = 0; i < roster.size(); i++) {
        if (session.get(temp).retName().equals(roster.get(i).retClass4())) {
          occ = occ + 1;
        }
      }
      if (occ >= 16) {
        return false;
      } else {
        return true;
      }
    }
    for (int i = 0; i < roster.size(); i++) {
      if (session.get(temp).retName().equals(roster.get(i).retClass5())) {
        occ = occ + 1;
      }
    }
    if (occ >= 16) {
      return false;
    } else {
      return true;
    }
  }

  public static void addMates(int temp) {
    int occ = 0;
    if (isFilled(temp)) {
      for (int i = 0; i < availRoster.size(); i++) {
        if (occ < 16) {
          if (availRoster.get(i).retFir().equals(session.get(temp).retName())) {
            session.get(temp).addPeep(availRoster.get(i).retName());
            for (int j = 0; j < roster.size(); j++) {
              if (isFilled(temp)) {
                if (i < availRoster.size()) {
                  if (roster.get(j).retName().equals(availRoster.get(i).retName())) {
                    if (inClass(temp, j)) {
                      roster.get(j).changeFir();
                      addClasses(j, temp);
                      occ = 1 + occ;
                      availRoster.remove(i);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (isFilled(temp)) {
      for (int i = 0; i < availRoster.size(); i++) {
        if (isFilled(temp)) {
          if (availRoster.get(i).retSec().equals(session.get(temp).retName())) {
            session.get(temp).addPeep(availRoster.get(i).retName());
            for (int j = 0; j < roster.size(); j++) {
              if (isFilled(temp)) {
                if (i < availRoster.size()) {
                  if (roster.get(j).retName().equals(availRoster.get(i).retName())) {
                    if (inClass(temp, j)) {
                      roster.get(j).changeSec();
                      addClasses(j, temp);
                      occ = 1 + occ;
                      availRoster.remove(i);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (isFilled(temp)) {
      for (int i = 0; i < availRoster.size(); i++) {
        if (isFilled(temp)) {
          if (availRoster.get(i).retThi().equals(session.get(temp).retName())) {
            session.get(temp).addPeep(availRoster.get(i).retName());
            for (int j = 0; j < roster.size(); j++) {
              if (isFilled(temp)) {
                if (i < availRoster.size()) {
                  if (roster.get(j).retName().equals(availRoster.get(i).retName())) {
                    if (inClass(temp, j)) {
                      roster.get(j).changeThi();
                      addClasses(j, temp);
                      occ = 1 + occ;
                      availRoster.remove(i);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (isFilled(temp)) {
      for (int i = 0; i < availRoster.size(); i++) {
        if (isFilled(temp)) {
          if (availRoster.get(i).retFou().equals(session.get(temp).retName())) {
            session.get(temp).addPeep(availRoster.get(i).retName());
            for (int j = 0; j < roster.size(); j++) {
              if (isFilled(temp)) {
                if (i < availRoster.size()) {
                  if (roster.get(j).retName().equals(availRoster.get(i).retName())) {
                    if (inClass(temp, j)) {
                      roster.get(j).changeFou();
                      addClasses(j, temp);
                      occ = 1 + occ;
                      availRoster.remove(i);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (isFilled(temp)) {
      for (int i = 0; i < availRoster.size(); i++) {
        if (isFilled(temp)) {
          if (availRoster.get(i).retFif().equals(session.get(temp).retName())) {
            session.get(temp).addPeep(availRoster.get(i).retName());
            for (int j = 0; j < roster.size(); j++) {
              if (isFilled(temp)) {
                if (i < availRoster.size()) {
                  if (roster.get(j).retName().equals(availRoster.get(i).retName())) {
                    if (inClass(temp, j)) {
                      roster.get(j).changeFif();
                      addClasses(j, temp);
                      occ = 1 + occ;
                      availRoster.remove(i);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (isFilled(temp)) {
      for (int i = 0; i < availRoster.size(); i++) {
        if (isFilled(temp)) {
          session.get(temp).addPeep(availRoster.get(i).retName());
          for (int j = 0; j < roster.size(); j++) {
            if (isFilled(temp)) {
              if (i < availRoster.size()) {
                if (roster.get(j).retName().equals(availRoster.get(i).retName())) {
                  if (inClass(temp, j)) {
                    addClasses(j, temp);
                    availRoster.remove(i);
                    occ = 1 + occ;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}