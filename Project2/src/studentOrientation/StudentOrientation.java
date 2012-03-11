package studentOrientation;

import studentOrientation.activity.BuyingBooksActivity;
import studentOrientation.activity.CampusTourActivity;
import studentOrientation.activity.DormSelectionActivity;
import studentOrientation.activity.RegistrationActivity;

import studentOrientation.util.Currency;

public class StudentOrientation {
  private BuyingBooksActivity buyingBooksActivity;
  private CampusTourActivity campusTourActivity;
  private DormSelectionActivity dormSelectionActivity;
  private RegistrationActivity registrationActivity;

  /**
   * @param activity The book buying activity
   */
  public void setBuyingBooksActivity(BuyingBooksActivity activity) {
    buyingBooksActivity = activity;
  }

  /**
   * @param activity The campus tour activity
   */
  public void setCampusTourActivity(CampusTourActivity activity) {
    campusTourActivity = activity;
  }

  /**
   * @param activity The dorm selection activity
   */
  public void setDormSelectionActivity(DormSelectionActivity activity) {
    dormSelectionActivity = activity;
  }

  /**
   * @param activity The registration activity
   */
  public void setRegistrationActivity(RegistrationActivity activity) {
    registrationActivity = activity;
  }

  public int getCarbonFootprint() {
    return buyingBooksActivity.getCarbonFootprint() +
      campusTourActivity.getCarbonFootprint() +
      dormSelectionActivity.getCarbonFootprint() +
      registrationActivity.getCarbonFootprint();
  }

  public Currency getCost() {
    return buyingBooksActivity.getCost().add(
      campusTourActivity.getCost()).add(
      dormSelectionActivity.getCost()).add(
      registrationActivity.getCost());
  }

  public int getEffort() {
    return buyingBooksActivity.getEffort() +
      campusTourActivity.getEffort() +
      dormSelectionActivity.getEffort() +
      registrationActivity.getEffort();
  }

  public int getTime() {
    return buyingBooksActivity.getTime() +
      campusTourActivity.getTime() +
      dormSelectionActivity.getTime() +
      registrationActivity.getTime();
  }

  public String toString() {
    return "Carbon footprint: " + getCarbonFootprint() + " tons\n" +
      "Cost: " + getCost() + "\n" +
      "Effort: " + getEffort() + " Calories\n" +
      "Time: " + getTime() + " minutes\n";
  }
}
