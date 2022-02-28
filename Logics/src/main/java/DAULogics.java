import java.io.*;
import java.util.LinkedList;

public class DAULogics {

    private static final LinkedList<DailyActiveUsers> allUsersCountsByDates = new LinkedList<>();

    public static LinkedList<DailyActiveUsers> countDAU(InputStream fin) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(fin));

        if(!reader.ready())
            return null;

        String currentLine, currentDate;
        int currentID;

        currentLine = reader.readLine();
        DailyActiveUsers dailyActiveUsers = addFirstUser(currentLine);
        currentDate = dailyActiveUsers.getDate();

        while(reader.ready()){
            currentLine = reader.readLine();
            currentID = extractID(currentLine);
            String extractedDate = extractDate(currentLine);
            if(!currentDate.equals(extractedDate)){
                allUsersCountsByDates.add(dailyActiveUsers);
                currentDate = extractedDate;
                dailyActiveUsers = new DailyActiveUsers(currentDate);
            }
            addUserIfNeeded(currentID,dailyActiveUsers);
        }
        allUsersCountsByDates.add(dailyActiveUsers);
        return allUsersCountsByDates;
    }

    public static String extractDate(String currentLine){
        String []idDateAndTime = currentLine.split(",");
        return idDateAndTime[1].split(" ")[0];
    }

    public static int extractID(String currentLine){
        return Integer.parseInt(currentLine.split(",")[0]);
    }

    public static DailyActiveUsers addFirstUser(String currentLine){
        String currentDate = extractDate(currentLine);
        DailyActiveUsers dailyActiveUsers = new DailyActiveUsers(currentDate);
        dailyActiveUsers.addUser(extractID(currentLine));
        return  dailyActiveUsers;
    }

    public static void addUserIfNeeded(int id, DailyActiveUsers dailyActiveUsers){
        if(!dailyActiveUsers.containsUser(id))
            dailyActiveUsers.addUser(id);
    }
}


