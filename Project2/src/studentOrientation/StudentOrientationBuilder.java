package studentOrientation;

import studentOrientation.activity.BuyingBooksActivity;
import studentOrientation.activity.CampusTourActivity;
import studentOrientation.activity.DormSelectionActivity;
import studentOrientation.activity.RegistrationActivity;

public class StudentOrientationBuilder {
  private StudentOrientation orientation;

  public StudentOrientationBuilder(StudentOrientation orientation) {
    this.orientation = orientation;
  }

  public void buildBuyingBooksActivity(BuyingBooksActivity activity) {
    orientation.setBuyingBooksActivity(activity);
  }

  public void buildCampusTourActivity(CampusTourActivity activity) {
    orientation.setCampusTourActivity(activity);
  }

  public void buildDormSelectionActivity(DormSelectionActivity activity) {
    orientation.setDormSelectionActivity(activity);
  }

  public void buildRegistrationActivity(RegistrationActivity activity) {
    orientation.setRegistrationActivity(activity);
  }
}
