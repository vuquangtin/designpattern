package designpatterns.gof.behavioral.visitor.doubledispatch;

public class DoubleDispatch {
	public static void main(String[] args) {
		MyPrinter p = new MyPrinter();
		Document docA = new PDFDoc();
		Document docB = new DOCDoc();
		p.print(docA);
		p.print(docB);
		System.out.println("using bad print");
		p.badPrint(docA);
		p.badPrint(docB);
	}

	public static abstract class Document {
		public abstract void printMe(Printer p);
	}

	public static interface Printer {
		public void print(Document document);

		public void print(PDFDoc document);

		public void print(DOCDoc document);
	}

	public static class PDFDoc extends Document {

		@Override
		public void printMe(Printer p) {
			System.out.println("PDFDoc accepting a print call");
			p.print(this);

		}

	}

	public static class DOCDoc extends Document {

		@Override
		public void printMe(Printer p) {
			System.out.println("DOCDoc accepting a print call");
			p.print(this);

		}

	}

	public static class MyPrinter implements Printer {
		public void badPrint(Document document) {
			if (document instanceof PDFDoc) {
				print((PDFDoc) document);
			} else if (document instanceof DOCDoc) {
				print((DOCDoc) document);
			} else {
				System.out.println("What to do???");
			}
		}

		@Override
		public void print(Document document) {
			System.out.println("Dispatching method <<print>> called");
			document.printMe(this);

		}

		@Override
		public void print(PDFDoc document) {
			System.out.println("printing a PDF Doc");

		}

		@Override
		public void print(DOCDoc document) {
			System.out.println("printing a DOC Doc");

		}
	}
}
