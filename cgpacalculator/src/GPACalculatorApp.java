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

            System.out.print("Enter course unit: ");
            int courseUnit = scanner.nextInt();
            System.out.print("Enter course score: ");
            int courseScore = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

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
