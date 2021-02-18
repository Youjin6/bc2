package code.wk2_W;

/**
 * @author youjin
 */
public class Course {
    private String courseName;
    private Instructor instructor;
    private TextBook textBook;


    public Course(String courseName, Instructor instructor, TextBook textBook) {
        this.courseName = courseName;
        instructor = new Instructor(instructor); /* 这里我用了 copy 的构造器 为什么?? */
        textBook = new TextBook(textBook);
    }

    public Course(Course object2) {
        courseName = object2.courseName;
//        instructor = object2.instructor;
//        textBook = object2.textBook;
          instructor = new Instructor(object2.instructor);
          textBook = new TextBook(object2.textBook);
    }

    public String getCourseName() {
        return courseName;
    }

    public Instructor getInstructor() {
        return new Instructor(instructor);
    }

    public TextBook getTextBook() {
        return new TextBook(textBook);
    }

    @Override
    public String toString() {
        String str = "Course{" +
                "courseName='" + courseName + '\'' +
                ", instructor=" + instructor +
                ", textBook=" + textBook +
                '}';
        return str;

    }
}
