import java.util.HashSet;
import java.util.Set;

public class DailyActiveUsers implements IDailyActiveUsers{

    private final String date;
    private final Set<Integer> users;
    private int userCount;

    public DailyActiveUsers(String date) {
        this.users = new HashSet<>();
        this.date = date;
        this.userCount = 0;
    }

    public String getDate() {
        return date;
    }

    public int getUserCount() {
        return userCount;
    }

    public boolean containsUser(int id){
        return users.contains(id);
    }

    public void addUser(int id){
        users.add(id);
        userCount++;
    }
}
