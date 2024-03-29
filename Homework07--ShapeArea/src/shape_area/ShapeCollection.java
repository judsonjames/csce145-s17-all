package shape_area;

public class ShapeCollection {
  // Instance Variables
  private final int SHAPES_ARRAY_SIZE = 10;
  private Shape[] shapes = new Shape[SHAPES_ARRAY_SIZE];
  
  // Constructors
  public ShapeCollection () {
    for (int i = 0; i < shapes.length; ++i) {
      shapes[i] = null;
    }
  }
  
  // Private Methods
  private void sortShapes () {
    boolean doneSorting = false;
    
    // There should at least be two items inside the shapes
    // array before we begin to sort.
    if (shapes[0] == null || shapes[1] == null) {
      return;
    }
    
    // Sorts the shapes based on the area.
    while (doneSorting == false) {
      doneSorting = true;
      for (int i = 0; shapes[i+1] != null; ++i) {
        if (shapes[i].getArea() > shapes[i+1].getArea()) {
          Shape temp = shapes[i];
          shapes[i] = shapes[i+1];
          shapes[i+1] = temp;
          doneSorting = false;
        }
      }
    } // done sorting
  } // end sortShapes ()
  
  // Public Methods
  public void addShape (Shape aShape) {
    // TODO Code
    int index = 0;
    for (index = 0; shapes[index] != null; ++index);
    shapes[index] = aShape;
    sortShapes();
    printShapes();
  } // end addShape ()
  
  public void removeShape (double anArea, String aShape) {
    // Code
    int index = 0;
    boolean didFindIt = false;
    while (shapes[index] != null) {
      if (shapes[index].getArea() == anArea 
          && (shapes[index].getShapeType().equals(aShape))) {
        didFindIt = true;
        break;
      }
      ++index;
    }
    if (didFindIt == true) {
      shapes[index] = null;
    } else {
      System.out.println("This Shape was not found.");
    }
    
    // Makes sure that there are no null spaces.
    for (int i = 0; i < shapes.length-1; ++i) {
      if (shapes[i] == null && shapes[i+1] != null) {
        shapes[i] = shapes[i+1];
        shapes[i+1] = null;
      }
    }
    sortShapes();
    printShapes();
  } // end removeShape ()
  
  public void printShapes () {
    System.out.println();
    for (int i = 0; shapes[i] != null; ++i) {
      System.out.println(shapes[i]);
    }
    System.out.println();
  } // end printShapes ()
}
