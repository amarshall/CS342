package studentOrientation;

import studentOrientation.activity.BuyingBooksActivity;
import studentOrientation.activity.CampusTourActivity;
import studentOrientation.activity.DormSelectionActivity;
import studentOrientation.activity.RegistrationActivity;

public class StudentOrientationBuilder {
  private StudentOrientation orientation;

  /**
   * @param orientation The orientation to build
   */
  public StudentOrientationBuilder(StudentOrientation orientation) {
    this.orientation = orientation;
  }

  /**
   * @param activity The book buying activity
   */
  public void buildBuyingBooksActivity(BuyingBooksActivity activity) {
    orientation.setBuyingBooksActivity(activity);
  }

  /**
   * @param activity The campus tour activity
   */
  public void buildCampusTourActivity(CampusTourActivity activity) {
    orientation.setCampusTourActivity(activity);
  }

  /**
   * @param activity The dorm selection activity
   */
  public void buildDormSelectionActivity(DormSelectionActivity activity) {
    orientation.setDormSelectionActivity(activity);
  }

  /**
   * @param activity The registration activity
   */
  public void buildRegistrationActivity(RegistrationActivity activity) {
    orientation.setRegistrationActivity(activity);
  }
}
