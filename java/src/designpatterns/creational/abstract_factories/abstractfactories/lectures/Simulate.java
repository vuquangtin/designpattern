package abstractfactories.lectures;


import abstractfactories.lectures.factory.MsStudentFactory;
import abstractfactories.lectures.factory.StudentFactory;
/**
 * <h1>Abstract Factory</h1> Cung cấp một interface để tạo ra 1 họ các object
 * (đối tượng) có liên quan hoặc phụ thuộc lẫn nhau mà không chỉ rõ các lớp cụ
 * thể của chúng (concrete classes)
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class Simulate {
    public static void main(String[] args) {
        
        StudentFactory msStudentFactory = new MsStudentFactory();
        
        Student msStudent = new Student("MS Student", msStudentFactory.createCourse(), 
                msStudentFactory.createPaper(), msStudentFactory.createDegreeErnDoc());
        
        msStudent.printInfo();
        System.out.println();
        
        StudentFactory underGrStudentFactory = new MsStudentFactory();
        
        Student underGrStudent = new Student("Under Graduate Student", underGrStudentFactory.createCourse(), 
                underGrStudentFactory.createPaper(), underGrStudentFactory.createDegreeErnDoc());
        
        underGrStudent.printInfo();
        
        System.out.println();
        StudentFactory phdStudentFactory = new MsStudentFactory();
        
        Student phdStudent = new Student("Under Graduate Student", phdStudentFactory.createCourse(), 
                phdStudentFactory.createPaper(), phdStudentFactory.createDegreeErnDoc());
        
        phdStudent.printInfo();
        
        
    }
}
