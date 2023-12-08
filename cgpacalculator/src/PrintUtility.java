public class PrintUtility {
    public static void printHeader() {
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE              | COURSE UNIT           | GRADE      | GRADE-UNIT          |");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
    }

    public static void printCourseInfo(Course course) {
        double grade = course.calculateQualityPoint();
        double gradeUnit = course.getUnit() * grade;
        String gradeAlpha = course.calculateGradeAlpha();

        System.out.printf("| %-27s| %-22d| %-11S|%-21d|%n",
                course.getCode(), course.getUnit(), gradeAlpha, (int) gradeUnit);
    }

    public static void printFooter() {
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
    }

    public static void printGPA(double gpa) {
        System.out.printf("Your GPA is = %.2f to 2 decimal places.%n", gpa);
    }
}
