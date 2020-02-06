package abstractfactories.lectures;

import abstractfactories.lectures.products.courseproduct.Course;
import abstractfactories.lectures.products.degreedocumentproduct.DegreeDocument;
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
public class Student {

	private String type;
	private Course course;
	private Paper paper;
	private DegreeDocument degreeDocument;

	public Student(String type, Course course, Paper paper,
			DegreeDocument degreeDocument) {
		this.type = type;
		this.course = course;
		this.paper = paper;
		this.degreeDocument = degreeDocument;
	}

	public String getType() {
		return type;
	}

	public Course getCourse() {
		return course;
	}

	public Paper getPaper() {
		return paper;
	}

	public DegreeDocument getDegreeDocument() {
		return degreeDocument;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public void setDegreeDocument(DegreeDocument degreeDocument) {
		this.degreeDocument = degreeDocument;
	}

	public void printInfo() {
		System.out.println("Type: " + this.type);
		System.out.println("Course: " + this.course.getCourseName());
		System.out.println("Paper: " + this.paper.getPaperName());
		System.out.println("Degree Document: "
				+ this.degreeDocument.getDegreeDocName());
	}

}
