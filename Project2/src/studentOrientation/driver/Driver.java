package studentOrientation.driver;

import studentOrientation.Orientation;
import studentOrientation.OrientationWorkshop;
import studentOrientation.StudentOrientation;
import studentOrientation.StudentOrientationBuilder;

public class Driver {
  public static void main(String[] args) {
    Orientation orientation = new StudentOrientation();
    StudentOrientationBuilder builder = new StudentOrientationBuilder(orientation);

    OrientationWorkshop workshop = new OrientationWorkshop();
    workshop.construct(orientation);

    System.out.println(orientation);
  }
}
