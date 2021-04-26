package School;

public class Course {
    int courseId;
    int year;
    String semester;
    Teacher teacherAssigned;

    public Course(int courseId, int year, String semester, Teacher teacher) {
        this.courseId = courseId;
        this.year = year;
        this.semester = semester;
        this.teacherAssigned = teacher;
    }

    public Teacher getTeacherAssigned() {
        return teacherAssigned;
    }
}
