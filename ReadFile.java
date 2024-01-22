mport java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
    
  public static ArrayList<Roster> roster = new ArrayList<Roster>();
  public static ArrayList<Sessions> session = new ArrayList<Sessions>();
  public static void main(String[] args) {
    addRoster();
    
  }

  public static void addRoster(){
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
        if(fifReader.hasNextLine()){
          firstData = firReader.nextLine();
          secondData = secReader.nextLine();
          thirdData = thiReader.nextLine();
          fourthData = fouReader.nextLine();
          fifthData = fifReader.nextLine();
        }
        else {
          firstData = null;
          secondData = null;
          thirdData = null;
          fourthData = null;
          fifthData = null;
        }
        Roster b1 = new Roster(studData, emailData, firstData, secondData, thirdData, fourthData, fifthData);
        roster.add(b1);
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

  public static void addSession(){
    try {
      File sesObj = new File("sessionName.txt");
      Scanner sesScanner = new Scanner(sesObj);
      File alumObj = new File("alumName.txt");
      Scanner alScanner = new Scanner(alumObj);
      int popInput = 1;
      while (sesScanner.hasNextLine()) {
        String sesData = sesScanner.nextLine();
        int popScore = popScore(popInput);
        String alumNameStr = alScanner.nextLine();
        Sessions b1 = new Sessions(sesData, popScore, alumNameStr);
        session.add(b1);
      }
      sesScanner.close();
      alScanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static int popScore(int sesId){
    return 0;
    //Go down list from first to fifth and make a score 
  }
  
}
