package Logics;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DAULogics implements IDAULogics{

    private final Map<String, IDailyActiveUsers> allUsersCountsByDates = new HashMap<>();

    public Map<String, IDailyActiveUsers> countAllDAU(InputStream fin) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(fin));

        if(!reader.ready())
            return null;

        String currentLine, currentDate;
        int currentID;
        IDailyActiveUsers dailyActiveUsers;

        while(reader.ready()){
            currentLine = reader.readLine();
            currentID = extractID(currentLine);
            currentDate = extractDate(currentLine);
            if(!allUsersCountsByDates.containsKey(currentDate)){
                dailyActiveUsers = new DailyActiveUsers();
                allUsersCountsByDates.put(currentDate, dailyActiveUsers);
            }
            else dailyActiveUsers = allUsersCountsByDates.get(currentDate);
            addUserIfNeeded(currentID,dailyActiveUsers);
        }
        return allUsersCountsByDates;
    }

    public String extractDate(String currentLine){
        String []idDateAndTime = currentLine.split(",");
        return idDateAndTime[1].split(" ")[0];
    }

    public int extractID(String currentLine){
        return Integer.parseInt(currentLine.split(",")[0]);
    }

    public void addUserIfNeeded(int id, IDailyActiveUsers dailyActiveUsers){
        if(!dailyActiveUsers.containsUser(id))
            dailyActiveUsers.addUser(id);
    }
}


