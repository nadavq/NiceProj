import java.io.*;
import java.util.LinkedList;

public class DAULogics implements IDAULogics{

    private static final LinkedList<IDailyActiveUsers> allUsersCountsByDates = new LinkedList<>();

    public LinkedList<IDailyActiveUsers> countDAU(InputStream fin) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(fin));

        if(!reader.ready())
            return null;

        String currentLine, currentDate;
        int currentID;

        currentLine = reader.readLine();
        IDailyActiveUsers dailyActiveUsers = addFirstUser(currentLine);
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

    public String extractDate(String currentLine){
        String []idDateAndTime = currentLine.split(",");
        return idDateAndTime[1].split(" ")[0];
    }

    public int extractID(String currentLine){
        return Integer.parseInt(currentLine.split(",")[0]);
    }

    public IDailyActiveUsers addFirstUser(String currentLine){
        String currentDate = extractDate(currentLine);
        IDailyActiveUsers dailyActiveUsers = new DailyActiveUsers(currentDate);
        dailyActiveUsers.addUser(extractID(currentLine));
        return  dailyActiveUsers;
    }

    public void addUserIfNeeded(int id, IDailyActiveUsers dailyActiveUsers){
        if(!dailyActiveUsers.containsUser(id))
            dailyActiveUsers.addUser(id);
    }
}


