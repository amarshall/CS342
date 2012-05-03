package taskManager.data;

import java.util.Observable;

public class User extends Observable {
  private String userName;
  private String status;

  public User(String userName, String status) {
    this.userName = userName;
    this.status = status;
  }

  public String getUserName() { return userName; }
  public String getStatus() { return status; }

  public void setUserName(String userName) { this.userName = userName; setChanged(); }
  public void setStatus(String status) { this.status = status; setChanged(); }


  public String toString() {
    return "User Name: '" + getUserName() + "' | " +
           "Status: '"    + getStatus()   + "'";
  }
}
