package prog2;

public class Course implements Comparable<Course>{
    private int year;
    private int term;
    private String courseCode;
    private String courseName;
    private int units;
    private int grades;

    public Course(int year, int term, String courseCode, String courseName, int units, int grades){
        this.year = year;
        this.term = term;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.units = units;
        this.grades = grades;
    }

    @Override
    public int compareTo(Course o) {
        return Integer.compare(grades, o.grades);
    }

    public int getYear(){
        return year;
    }

    public int getTerm(){
        return term;
    }

    public String getCourseCode(){
        return courseCode;
    }

    public String getCourseName(){
        return courseName;
    }

    public int getUnits(){
        return units;
    }

    public int getGrades(){
        return grades;
    }
}
