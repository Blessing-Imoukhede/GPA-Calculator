public class Course {
    private String code;
    private int unit;
    private int score;

    public Course(String code, int unit, int score) {
        this.code = code;
        this.unit = unit;
        this.score = score;
    }

    public String getCode() {
        return code;
    }

    public int getUnit() {
        return unit;
    }

    public int getScore() {
        return score;
    }

    public double calculateQualityPoint() {
        if (score >= 70) {
            return 5.0;
        } else if (score >= 60) {
            return 4.0;
        } else if (score >= 50) {
            return 3.0;
        } else if (score >= 45) {
            return 2.0;
        } else if (score >= 40) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    public String calculateGradeAlpha() {
        if (score >= 70) {
            return "A";
        } else if (score >= 60) {
            return "B";
        } else if (score >= 50) {
            return "C";
        } else if (score >= 45) {
            return "D";
        } else if (score >= 40) {
            return "E";
        } else {
            return "F";
        }
    }
}
