import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

/*
The time complexity of the solution is O(n) while n is the number of entries that appear in the file.
That is obtained by the fact that for every id user we extract from each line, we check
if it already exists in the daily active user's entity set, which takes O(1).
For d - the number of individual dates that appear in the file and for k - the number of individual users that
entered for each date, the space complexity is - O(d+k), as every date has a different node in the linked list
and every user id entered at that date is contained in a set in that node.

The runtime complexity cannot be improved more than it is because in each case we will have to go
through each line in order to check if the current id has already entered on that date.

The solution assumes that the dates in the file are in ascending order by line.
If not, i would have implemented a map where the date is the key and the set is the value and
searched the map for the requested date.
 */

public class DAUInterface {
    public static void main(String[] args) throws IOException {
        LinkedList<DailyActiveUsers> DAUList = countDAU();
        printList(DAUList);
    }

    public static LinkedList<DailyActiveUsers> countDAU() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the input file path:");
        String path = scanner.nextLine();
        InputStream fin = new FileInputStream(path);
        return DAULogics.countDAU(fin);
    }

    public static void printList(LinkedList<DailyActiveUsers> list){
        if(list == null)
            System.out.println("No data found in file");
        else list.forEach(dailyActiveUsers -> System.out.println(dailyActiveUsers.getDate() + " : " + dailyActiveUsers.getUserCount()));
    }
}
