package Logics;

import java.util.HashSet;
import java.util.Set;

public class DailyActiveUsers implements IDailyActiveUsers{

    private final Set<Integer> users;
    private int userCount;

    public DailyActiveUsers() {
        this.users = new HashSet<>();
        this.userCount = 0;
    }

    public int getUserCount() {
        return userCount;
    }

    public boolean containsUser(int id){ return users.contains(id); }

    public void addUser(int id){
        users.add(id);
        userCount++;
    }
}
