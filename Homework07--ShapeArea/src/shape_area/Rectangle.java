package shape_area;

public class Rectangle implements Shape {
  // Instance Variables
  private double length;
  private double height;
  
  // Constructors
  public Rectangle () {
    this.length = 0.0;
    this.height = 0.0;
  }
  public Rectangle (double aLength, double aHeight) {
    this.setLength(aLength);
    this.setHeight(aHeight);
  }
  
  // Implemented Interface Methods
  public double getArea () {
    return (this.length * this.height);
  }
  
  public String toString() {
    return "Rectangle [length=" + length + ", height=" + height 
        + ", area=" + this.getArea() + "]";
  }
  public String getShapeType () {
    return "Rectangle";
  }
  
  // Object-Specific Method
  public double getLength () {
    return length;
  }
  public void setLength (double aLength) {
    if (aLength > 0.0) {
      this.length = aLength;
    } else {
      System.out.println("Invalid input");
      this.length = 0.0;
    }
  }
  public double getHeight () {
    return height;
  }
  public void setHeight (double aHeight) {
    if (aHeight > 0.0) {
      this.height = aHeight;
    } else {
      System.out.println("Invalid Input");
      this.height = 0.0;
    }
  }  
} // end of Rectangle
