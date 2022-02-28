public interface IDailyActiveUsers {

    boolean containsUser(int id);

    void addUser(int id);

    String getDate();

    int getUserCount();
}
