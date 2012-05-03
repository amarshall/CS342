package taskManager.tabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import taskManager.data.User;

public class UsersTab extends Tab {
  private List<User> users;

  public UsersTab() {
    users = new ArrayList<User>();
  }

  public String display() {
    return users.get(users.size() - 1).toString();
  }

  public void update(Observable o, Object arg) {
    o.addObserver(this);
    users.add((User)o);
    setChanged();
    notifyObservers();
  }
}
