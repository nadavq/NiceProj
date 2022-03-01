import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

/*
The time complexity of the solution is O(n) while n is the number of entries that appear in the file.
That is obtained by the fact that for every id user we extract from each line, we check
if it already exists in the daily active user's entity set, which takes O(1).
For d - the number of individual dates that appear in the file and for k - the number of individual users that
entered for each date, the space complexity is - O(d+k), as every date appears once in the map
and every user id entered at that date is contained in a set in that key.

The runtime complexity cannot be improved more than that because in each case we will have to go
through each line in the file in order to check if the current id has already entered on that date.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            Map<String, IDailyActiveUsers> DAUList = countDAU();
            printList(DAUList);
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public static Map<String, IDailyActiveUsers> countDAU() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the input file path:");
        String path = scanner.nextLine();
        InputStream fin = new FileInputStream(path);
        IDAULogics dauLogics = new DAULogics();
        return dauLogics.countAllDAU(fin);
    }

    public static void printList( Map<String, IDailyActiveUsers> allUsersByDate){
        if(allUsersByDate == null)
            System.out.println("No data found in file");
        else allUsersByDate.forEach((date, users)  -> System.out.println(date + " : " + users.getUserCount()));
    }
}
