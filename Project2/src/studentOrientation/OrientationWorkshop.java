package studentOrientation;

import studentOrientation.activity.BuyingBooksActivity;
import studentOrientation.activity.CampusTourActivity;
import studentOrientation.activity.DormSelectionActivity;
import studentOrientation.activity.RegistrationActivity;

import studentOrientation.activity.CampusWalkingTour;
import studentOrientation.activity.CampusBusTour;
import studentOrientation.activity.OnlineDormSelection;
import studentOrientation.activity.InPersonDormSelection;
import studentOrientation.activity.OnlineRegistration;
import studentOrientation.activity.InPersonRegistration;

import studentOrientation.bookstore.Bookstore;
import studentOrientation.bookstore.UniversityBookstore;

import studentOrientation.bookstore.MandoBooks;
import studentOrientation.util.Currency;

public class OrientationWorkshop {
  public void construct(StudentOrientationBuilder builder) {
    // Bookstore bookstore = new UniversityBookstore();
    Bookstore bookstore = new MandoBooks();

    BuyingBooksActivity buyingBooks = new BuyingBooksActivity(bookstore, new Currency(300, 0));
    builder.buildBuyingBooksActivity(buyingBooks);

    // CampusTourActivity campusTour = new CampusWalkingTour();
    CampusTourActivity campusTour = new CampusBusTour();
    builder.buildCampusTourActivity(campusTour);

    // DormSelectionActivity dormSelection = new OnlineDormSelection();
    DormSelectionActivity dormSelection = new InPersonDormSelection();
    builder.buildDormSelectionActivity(dormSelection);

    // RegistrationActivity registration = new OnlineRegistration();
    RegistrationActivity registration = new InPersonRegistration();
    builder.buildRegistrationActivity(registration);
  }
}
