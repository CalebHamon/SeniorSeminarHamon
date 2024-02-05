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
  private static Scanner scan = new Scanner(System.in);

  /*
   * Senior Seminar sorts everyone into sessions in which they
   * signed up for to the best of the program's ability.
   * It accomplishes this by creating a variey of Arraylists
   * that keep track of the rosters, sessions, and the time
   * periods. The main method has almost nothing to reflect 
   * the amount that went into outside methods
   */
  public static void main(String[] args) {
    addRoster();
    addSession();
    for (int i = 0; i < 5; i++) {
      makeClasses();
    }
    masterSched();
    classLookup();
    studSearch();

  }

  //Gets the schedule of the time periods (with fairly simple code)
  public static void masterSched() {
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

  //part one not to decultter
  //Uses Roster to then print out everyone who is in each class
  public static void classLookup() {
    String yesser = "y";
    System.out.println("Would you like to search for a session's schedule? (y/n)");
    do {
      yesser = scan.nextLine();
      if (yesser.equals("y")) {
        classLookupP2(classLookupP3());
        System.out.println("Would you like to conduct another search?");
      }
    } while (yesser.equals("y"));
  }

  //A continuation of ClassLookup, this time actually doing the searching of the classes
  public static void classLookupP2(int lastOne) {
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

  //Finds all students classes
  public static void studSearch() {
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

  //Part 3 of classLookup
  public static int classLookupP3() {
    int lastOne;
    do {
      System.out.println("What time slot is the session in (1, 2, 3, 4, 5)? (please use number 1, 2, etc)");
      lastOne = scan.nextInt();
      scan.nextLine();
      System.out.println();
    } while (!(lastOne >= 1) && !(lastOne <= 5));
    return lastOne;
  }

  //ReadFile from w3Schools in order to convert the txt into an Arraylist
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
        if (fifReader.hasNextLine()) {//make sure the ones who didnt sign up do not throw an error
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
        if (seshCounter == 1) {//only create the roster one to ensure it does not reset
          roster.add(b1);
        }
        availRoster.add(b1);//dynamic in terms of adding and subtracting people
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

  public static void addSession() {//Same as the other ReadFile
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

  //Ensures that no class that has the same period also has the same alum
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

  //Same with duplicate Alum, except this time ensuring a class is not duplicated
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

  //Finds the "popularity" score of a class
  //It accomplishes this by weighing preferences with first choice to last choice and adding them up to give it a unique score
  //Used later to determine scheduling 
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

  //Converts available session positions to (reg) sessions
  public static int availConverter(int temp) {
    int perm = 0;
    for (int i = 0; i < session.size(); i++) {
      if (session.get(i).retName().equals(availSession.get(temp).retName())) {
        perm = i;
      }
    }
    return perm;
  }

  //The actual making of the classes, using popScore to see what it should schedule
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
    availSession.remove(tempPlace);//remove to ensure no repeats
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
    //Adds new period with all the classes
    TimeSesh b1 = new TimeSesh(seshCounter, class1, class2, class3, class4, class5);
    timeSlot.add(b1);
    seshCounter++;
    addRoster(); //reset avail roster
    availSession = session;
  }

  //Adding the classes to the individual
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

  //Checking if someone is already in a class
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

  //Checing if a session is full
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

  //Adding the people to the rosters, and then the classes to the people
  //Going through all checks (previous methods) to ensure everything is right
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