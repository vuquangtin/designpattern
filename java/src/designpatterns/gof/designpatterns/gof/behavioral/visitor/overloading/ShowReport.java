package designpatterns.gof.behavioral.visitor.overloading;

/**
 * <h1>What is Double Dispatching?</h1> In Double Dispatching the choosing of
 * the method happens dynamically twice.In the below example the method is
 * chosen similar to strategy pattern first time during call of viewReport
 * method and again during choosing which printReport method to be called based
 * on the class type its is called similar to
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class ShowReport {
	public static void main(String[] args) {
		Principal objPrincipal = new Principal();
		Teacher objTeacher = new Teacher();
		objPrincipal.viewReport(new Report());
		objTeacher.viewReport(new Report());
	}
}

interface Staff {
	void viewReport(Report objReport);
}

class Teacher implements Staff {

	public void viewReport(Report objReport) {
		System.out.println("View Report of Teacher");
		objReport.printReport(this);
	}
}

class Principal implements Staff {

	public void viewReport(Report objReport) {
		System.out.println("View Report of Principal");
		objReport.printReport(this);
	}
}

class Report {
	public void printReport(Teacher objTeacher) {
		System.out.println("Can print report of her class");
	}

	public void printReport(Principal objPrincipal) {
		System.out.println("Can print report of all the class");
	}
}