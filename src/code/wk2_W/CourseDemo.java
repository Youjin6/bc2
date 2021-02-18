package code.wk2_W;

public class CourseDemo {
    public static void main(String[] args) {
        Instructor myInstructor = new Instructor("Youjin", "Li", "110");
        TextBook myTextBook = new TextBook("Starting out with java", "Gaddis", "Pearson");
        Course myCourse = new Course("Intro to java", myInstructor, myTextBook);

        Course myCopyCourse = new Course(myCourse);


        System.out.println(myCopyCourse);
        System.out.println(myCourse);
    }
}
