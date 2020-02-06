
package abstractfactories.lectures.factory;

import abstractfactories.lectures.products.courseproduct.Course;
import abstractfactories.lectures.products.courseproduct.MsStudentCourse;
import abstractfactories.lectures.products.degreedocumentproduct.DegreeDocument;
import abstractfactories.lectures.products.degreedocumentproduct.MsThesis;
import abstractfactories.lectures.products.paperproduct.ConferencePaper;
import abstractfactories.lectures.products.paperproduct.Paper;

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
public class MsStudentFactory implements StudentFactory {
    
    @Override
    public Course createCourse() {
        
        return new MsStudentCourse();
    }

    @Override
    public Paper createPaper() {
        
        return new ConferencePaper();
    }

    @Override
    public DegreeDocument createDegreeErnDoc() {
        
        return new MsThesis();
    }
    
}
