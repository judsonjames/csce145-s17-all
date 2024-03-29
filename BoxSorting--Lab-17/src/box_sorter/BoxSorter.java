package box_sorter;
import java.util.Scanner;
//-----------------------------------------------------------------------------
/**
 * @author judsonjames
 * @since 03-15-2017
 * @version 1.0
 * 
 * <h1><b>Lab 17 -- BoxSorter Driver</b></h1>
 * <p>
 * This class is meant to simulate a collection of box objects of various 
 * dimensions, sort them by volume, and print to the user the list of boxes.
 * </p>
 */
public class BoxSorter {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int numberOfBoxes = 5;
    Box[] boxes = new Box[numberOfBoxes];
    String aLabel = "";
    double aLength = 0.0;
    double aWidth = 0.0;
    double aHeight = 0.0;
    boolean doneSorting = false;
    
    // Program Introduction
    System.out.println("Welcome to the box sorter!\n"
        + "Enter the information about boxes and I'll sort them!");
    
    // Gather user input
    for (int i = 0; i < boxes.length; ++i) {
      
      System.out.println("Enter the label, length, width"
          + ", and height (all feet) of box " + (i+1));
      
      aLabel = keyboard.nextLine();
      aLength = keyboard.nextDouble();
      aWidth = keyboard.nextDouble();
      aHeight = keyboard.nextDouble();
      keyboard.nextLine();
      
      boxes[i] = new Box(aLabel, aLength,
                         aWidth, aHeight);
    }
    keyboard.close();
    
    // Sort Boxes by Volume using Bubble Sort
    while (doneSorting == false) {
      doneSorting = true;
      for (int i = 0; i < boxes.length-1; ++i) {
        if (boxes[i].getVolume() > boxes[i+1].getVolume()) {
          Box temp = boxes[i];
          boxes[i] = boxes[i+1];
          boxes[i+1] = temp;
          doneSorting = false;
        }
      }
    } // end of bubble sorting
    
    // Print the Sorted List to the User
    System.out.println("Sorted Boxes:");
    for (int i = 0; i < boxes.length; ++i) {
      System.out.println(boxes[i]);
    }
  } // end of main method
} // end of BoxSorter
