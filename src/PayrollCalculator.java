import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PayrollCalculator {
    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("employees.txt"));
            String line;

            while ((line = bufferedReader.readLine()) != null){
                if (line.trim().isEmpty()){
                    continue; // skips empty lines
                }

                String[] parts = line.split("\\|");

                if (parts.length != 4) {
                    System.out.println(line);
                    continue;
                }

                try {
                    // Parse Values from the line
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double hoursWorked = Double.parseDouble(parts[2].trim());
                    double payRate = Double.parseDouble(parts[3].trim());

                    // Create Employee Object
                    Employee emp = new Employee(id, name, hoursWorked, payRate);

                    // Print employee details
                    System.out.printf("ID: %d, Name: %s, Gross Pay: $%.2f%n",  // ✅ FIXED format string
                            emp.getEmployeeId(),
                            emp.getName(),
                            emp.getGrossPay());

                } catch (NumberFormatException e) {
                    System.out.println("Skipping line due to number format issue: " + line);
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }


    }

}