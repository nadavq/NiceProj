import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

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
