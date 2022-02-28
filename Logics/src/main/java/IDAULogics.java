import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public interface IDAULogics {
    LinkedList<IDailyActiveUsers> countDAU(InputStream fin) throws IOException;

    String extractDate(String currentLine);

    int extractID(String currentLine);

    IDailyActiveUsers addFirstUser(String currentLine);

    void addUserIfNeeded(int id, IDailyActiveUsers dailyActiveUsers);
}
