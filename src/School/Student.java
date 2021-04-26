package School;

import java.util.HashMap;
import java.util.Map;

public class Student {
    int studentId;
    String name;
    double gradePointAverage;
    Map<Course, Double> gradeBycoursesTaken;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.gradePointAverage = 0.0;
        this.gradeBycoursesTaken = new HashMap<>();
    }

    public double getGradeForCourse(Course course){
        if(this.gradeBycoursesTaken.containsKey(course)){
            return gradeBycoursesTaken.get(course);
        }   else return 0.0;
    }

    public double getGradePointAverage(){
        double total =  this.gradeBycoursesTaken.size()*4.0;
        double totalGrade = 0.0;
        for(double grade : this.gradeBycoursesTaken.values()){
            totalGrade += grade;
        }
        return totalGrade/total;
    }
}
