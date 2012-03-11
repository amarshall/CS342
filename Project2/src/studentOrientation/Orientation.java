package studentOrientation;

import studentOrientation.activity.BuyingBooksActivity;
import studentOrientation.activity.CampusTourActivity;
import studentOrientation.activity.DormSelectionActivity;
import studentOrientation.activity.RegistrationActivity;

import studentOrientation.util.Currency;

public interface Orientation {
  public boolean complete();

  public BuyingBooksActivity getBuyingBooksActivity();
  public CampusTourActivity getCampusTourActivity();
  public DormSelectionActivity getDormSelectionActivity();
  public RegistrationActivity getRegistrationActivity();

  public void setBuyingBooksActivity(BuyingBooksActivity activity);
  public void setCampusTourActivity(CampusTourActivity activity);
  public void setDormSelectionActivity(DormSelectionActivity activity);
  public void setRegistrationActivity(RegistrationActivity activity);

  public int getCarbonFootprint();
  public Currency getCost();
  public int getEffort();
  public int getTime();

  public String toString();
}
