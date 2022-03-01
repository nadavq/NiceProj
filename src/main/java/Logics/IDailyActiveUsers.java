package Logics;

public interface IDailyActiveUsers {

    boolean containsUser(int id);

    void addUser(int id);

    int getUserCount();
}
