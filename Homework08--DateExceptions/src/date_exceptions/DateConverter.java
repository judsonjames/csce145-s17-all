package date_exceptions;

//------------------------------------------------------------------------------
/**
 * @author judsonjames
 * @version 1.0
 * @date 04-12-2017
 */
//------------------------------------------------------------------------------
public class DateConverter {
  
  public static String dateConverter(String anInput) 
      throws MonthException, DayException {
    
    // Variables
    String correctDate = "";
    String[] months = {"January", "February", "March", "April", "May",
        "June", "July", "August", "September", "October", "November",
        "December"};
    int month = 0;
    int day = 0;
    int slashIndex = 0;
    
    // Parse the Data so that we can isolate months and days
    slashIndex = anInput.indexOf("/");
    month = Integer.parseInt(anInput.substring(0, slashIndex));
    day = Integer.parseInt(anInput.substring(slashIndex+1, anInput.length()));
    
    // Based on the User Input, we should check for valid values
    try {
      // First-Level Check: Months Check
      if (month < 1 || month > 12) {
        throw new MonthException();
      } 
      
      // Second-Level Check: Valid Days in Respect to Month
      if (day < 1 || day > 31) {
        throw new DayException();
      }
      else  if (month == 2 && day > 29) {
        throw new DayException();
      }
      else if (day > 30 && 
          month == 4 || month == 6 || month == 9 || month == 11) {
        throw new DayException();
      }
      
      // Because the Day in respect to Month is valid, we will append it to the 
      // return String, but if any of the exceptions are thrown, then the string
      // will remain empty.
      correctDate = "The date is " + months[month-1] + " " + day;

    } 
    catch (MonthException e) {
      System.out.println(e);
    } 
    catch (DayException e) {
      System.out.println(e);
    }
    
    // Return the Correct Date
    return correctDate;
  }
}
