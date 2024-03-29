package date_exceptions;
import java.util.Scanner;

//------------------------------------------------------------------------------
/**
* @author judsonjames
* @version 1.0
* @date 04-12-2017
*/
//------------------------------------------------------------------------------
public class DateConverterDriver {

  public static void main(String[] args) throws MonthException, DayException {
    // Variables
    Scanner keyboard = new Scanner(System.in);
    String userInput = "";
    String correctDate = "";
    boolean endProgram = false;
    
    // Welcome the User to the Program
    System.out.println("Welcome to the Date Converter!");
    
    // Loop the Program until the User wants to quit
    while (endProgram == false) {
      System.out.println("\nEnter a numeric date formatted as month/day "
          + "\nor “Exit” to quit.");
      userInput = keyboard.nextLine();
      
      if (userInput.equalsIgnoreCase("exit") 
          || userInput.equalsIgnoreCase("quit")) {
        endProgram = true;
      } else {
        correctDate = DateConverter.dateConverter(userInput);
        System.out.println(correctDate);
      }      
    } // end of Loop
    
    System.out.println("Goodbye");
    keyboard.close();
  } // end of Main Method
} // end of DateConverterDriver
