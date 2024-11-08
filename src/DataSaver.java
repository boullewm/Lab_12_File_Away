import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        String continueInput;
        do {
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            int idNum = SafeInput.getInt(in, "Enter ID Number (6 digits)");
            String idNumber = String.format("%06d", idNum);

            String email = SafeInput.getNonZeroLenString(in, "Enter Email");
            int yearOfBirth = SafeInput.getInt(in, "Enter Year of Birth");
            String record = firstName + ", " + lastName + ", " + idNumber + ", " + email + ", " + yearOfBirth;
            records.add(record);
            continueInput = SafeInput.getNonZeroLenString(in, "Do you want to enter another record? (Y/N)");
        } while (continueInput.equalsIgnoreCase("Y"));
        String fileName = SafeInput.getNonZeroLenString(in, "Enter the name of the file to save (with .csv extension)");
        try (FileWriter fileWriter = new FileWriter("src/" + fileName)) {
            for (String record : records) {
                fileWriter.write(record + "\n");
            }
            System.out.println("Records saved successfully in " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}