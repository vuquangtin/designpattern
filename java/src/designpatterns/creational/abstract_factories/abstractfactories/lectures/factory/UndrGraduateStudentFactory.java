
package abstractfactories.lectures.factory;

import abstractfactories.lectures.products.courseproduct.Course;
import abstractfactories.lectures.products.courseproduct.UndrGraduateStudentCourse;
import abstractfactories.lectures.products.degreedocumentproduct.DegreeDocument;
import abstractfactories.lectures.products.degreedocumentproduct.ProjectReport;
import abstractfactories.lectures.products.paperproduct.Paper;
import abstractfactories.lectures.products.paperproduct.TechnicalReport;

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
public class UndrGraduateStudentFactory implements StudentFactory {

    @Override
    public Course createCourse() {
        
        return new UndrGraduateStudentCourse();
    }

    @Override
    public Paper createPaper() {
        
        return  new TechnicalReport();
    }

    @Override
    public DegreeDocument createDegreeErnDoc() {
        
        return new ProjectReport();
    } 
}
