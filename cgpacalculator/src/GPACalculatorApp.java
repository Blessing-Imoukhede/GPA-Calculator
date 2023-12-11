import java.util.ArrayList;
import java.util.Scanner;

public class GPACalculatorApp {
    private static ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter course code (or 'exit' to finish): ");
            String courseCode = scanner.nextLine();

            if (courseCode.equalsIgnoreCase("exit")) {
                break;
            }

            // Input validation for course unit
            int courseUnit;
            while (true) {
                System.out.print("Enter course unit: ");
                if (scanner.hasNextInt()) {
                    courseUnit = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (courseUnit >= 0) {
                        break; // Valid input, exit the loop
                    } else {
                        System.out.println("Invalid input. Please enter a non-negative integer for course unit.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid integer for course unit.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }

            // Input validation for course score
            int courseScore;
            while (true) {
                System.out.print("Enter course score: ");
                if (scanner.hasNextInt()) {
                    courseScore = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (courseScore >= 0 && courseScore <= 100) {
                        break; // Valid input, exit the loop
                    } else {
                        System.out.println("Invalid input. Please enter a score between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid integer for course score.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }

            Course course = new Course(courseCode, courseUnit, courseScore);
            courses.add(course);
        }

        PrintUtility.printHeader();
        double totalGradeUnit = 0;
        int totalCourseUnit = 0;

        for (Course course : courses) {
            PrintUtility.printCourseInfo(course);
            totalGradeUnit += course.getUnit() * course.calculateQualityPoint();
            totalCourseUnit += course.getUnit();
        }

        PrintUtility.printFooter();
        double gpa = totalGradeUnit / totalCourseUnit;
        PrintUtility.printGPA(gpa);
    }
}
