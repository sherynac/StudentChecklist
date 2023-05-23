package prog2;

import java.io.Serializable;

public class Course implements Comparable<Course>, Serializable {
    private int year;
    private int term;
    private String courseCode;
    private String courseName;
    private int units;
    private int grades;
    private String preRequisite;

    public Course(int year, int term, String courseCode, String courseName, int units, int grades, String preRequisite){
        this.year = year;
        this.term = term;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.units = units;
        this.grades = grades;
        this.preRequisite = preRequisite;
    }

    @Override
    public int compareTo(Course o) {
        if (year > o.getYear()){
            return 1;
        } else if (year < o.getYear()) {
            return -1;
        } else if (term > o.getYear()) {
            return 1;
        } else if (term < o.getTerm()) {
            return -1;
        } else if (courseCode.compareToIgnoreCase(o.getCourseCode()) > 0){
            return 1;
        } else
            return 0;
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
    public String getPreRequisite() {return preRequisite};

    public void setGrades(int grades) {
        this.grades = grades;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public void setPreRequisite(String preRequisite) {this.preRequisite = preRequisite;}

}
