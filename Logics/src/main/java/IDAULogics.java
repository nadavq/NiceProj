import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public interface IDAULogics {
    Map<String, IDailyActiveUsers> countAllDAU(InputStream fin) throws IOException;

    String extractDate(String currentLine);

    int extractID(String currentLine);

    void addUserIfNeeded(int id, IDailyActiveUsers dailyActiveUsers);
}
