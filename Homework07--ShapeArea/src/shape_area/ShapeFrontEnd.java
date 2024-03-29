package shape_area;
import java.util.Scanner;

public class ShapeFrontEnd {
  
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    ShapeCollection shapes = new ShapeCollection();
    String userShape = "";
    int userInt = 0;
    double shapeLength = 0.0;
    double shapeHeight = 0.0;
    double userDouble = 0.0;
    boolean continueProgram = true;
    
    System.out.println("Welcome to the Shapes collections");
    while (continueProgram == true) {
      System.out.println("Enter 1: Add a shape"
          +"\nEnter 2: Remove a shape"
          +"\nEnter 9: Quit");
      userInt = keyboard.nextInt();
      keyboard.nextLine();
      
      switch (userInt) {
        case 1:
          System.out.println("What type of shape?\n"
              +"Rectangle, Triangle, or Circle?");
          userShape = keyboard.nextLine();
          
          if (userShape.equalsIgnoreCase("circle")) {
            System.out.println("Enter a radius");
            shapeLength = keyboard.nextDouble();
            keyboard.nextLine();
            if (shapeLength <= 0.0) {
              System.out.println("Invalid Input.");
              break;
            }
            Circle newCircle = new Circle(shapeLength);
            shapes.addShape(newCircle);
          } else if (userShape.equalsIgnoreCase("rectangle")) {
            System.out.println("Enter a length, followed by a height.");
            shapeLength = keyboard.nextDouble();
            shapeHeight = keyboard.nextDouble();
            keyboard.nextLine();
            if (shapeLength <= 0.0 || shapeHeight <= 0.0) {
              System.out.println("Invalid Input.");
              break;
            }
            Rectangle newRectangle = new Rectangle(shapeLength, shapeHeight);
            shapes.addShape(newRectangle);
          } else if (userShape.equalsIgnoreCase("triangle")) {
            System.out.println("Enter a base, followed by a height.");
            shapeLength = keyboard.nextDouble();
            shapeHeight = keyboard.nextDouble();
            keyboard.nextLine();
            if (shapeLength <= 0.0 || shapeHeight <= 0.0) {
              System.out.println("Invalid Input.");
              break;
            }
            Triangle newTriangle = new Triangle(shapeLength, shapeHeight);
            shapes.addShape(newTriangle);
          } else {
            System.out.println("Invalid Input.");
            break;
          }
          break;
        case 2:
          System.out.println("Enter the shape type");
          userShape = keyboard.nextLine();
          if (userShape.equalsIgnoreCase("circle")) {
            userShape = "Circle";
          } else if (userShape.equalsIgnoreCase("rectangle")) {
            userShape = "Rectangle";
          } else if (userShape.equalsIgnoreCase("triangle")) {
            userShape = "Triangle";
          } else {
            System.out.println("Invalid Input.");
            break;
          }
          System.out.println("Enter an area");
          userDouble = keyboard.nextDouble();
          keyboard.nextLine();
          
          shapes.removeShape(userDouble, userShape);
          break;
        case 9:
          System.out.println("Goodbye.");
          continueProgram = false;
          break;
        default:
          System.out.println("Invalid Input.");
          break;
      }
    } // end of loop
    keyboard.close();
  } // end of main method

} // end of ShapeFrontEnd
