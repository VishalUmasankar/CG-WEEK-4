import java.util.*;

abstract class CourseType {
    String title;
    public CourseType(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
class ExamCourse extends CourseType {
    public ExamCourse(String title) {
        super(title);
    }
}
class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title) {
        super(title);
    }
}
class ResearchCourse extends CourseType {
    public ResearchCourse(String title) {
        super(title);
    }
}
class Course<T extends CourseType> {
    T courseType;
    public Course(T courseType) {
        this.courseType = courseType;
    }
    public T getCourseType() {
        return courseType;
    }
    public static void printCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            System.out.println(c.getTitle());
        }
    }
}
public class CourseManagementDemo {
    public static void main(String[] args) {
        List<ExamCourse> examCourses = new ArrayList<>();
        examCourses.add(new ExamCourse("Math 101"));
        examCourses.add(new ExamCourse("Physics 102"));
        List<ResearchCourse> researchCourses = new ArrayList<>();
        researchCourses.add(new ResearchCourse("AI Research"));
        researchCourses.add(new ResearchCourse("Quantum Computing"));
        System.out.println("Exam-based Courses:");
        Course.printCourses(examCourses);
        System.out.println("Research-based Courses:");
        Course.printCourses(researchCourses);
    }
}
