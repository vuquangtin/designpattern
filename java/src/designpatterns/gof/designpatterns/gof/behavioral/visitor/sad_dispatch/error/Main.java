package designpatterns.gof.behavioral.visitor.sad_dispatch.error;

abstract class ComposantOrdi {
	protected void equiv(ComposantOrdi c) {
		Equivalence.equiv(this, c);
	}
}

class Montage extends ComposantOrdi {
	
	protected void equiv(Montage montage) {
		Equivalence.equiv(this, montage);
	}
}

class Equivalence {
	public static void equiv(Montage m, ComposantOrdi c) {
		System.out.println("Montage - ComposantOrdi");
	}

	public static void equiv(Montage m, Montage c) {
		System.out.println("Montage - Montage");
	}

	public static void equiv(ComposantOrdi m, ComposantOrdi c) {
		System.out.println("ComposantOrdi - ComposantOrdi");
	}
}

public class Main {
	public static void main(String[] args) {
		// o day m2 luon luon nho co 2 phuong thuc override la:
		// 1.cua chinh no protected void equiv(Montage montage)
		// 2.cua super protected void equiv(ComposantOrdi c)
		Montage m2 = new Montage();
		// m3 la ComposantOrdi se hidden cac phuong thuc cua Montage
		ComposantOrdi m3 = new Montage();
		// call in ComposantOrdi (tu dong ep kieu Montage thanh ComposantOrdi)
		m3.equiv(m2);
		// call in ComposantOrdi
		m3.equiv(m3);
		// call in ComposantOrdi
		m3.equiv((Montage) m3);

		// call in super is ComposantOrdi
		m2.equiv(m3);
		// call in Montage
		m2.equiv(m2);
		// call in super is ComposantOrdi
		m2.equiv((ComposantOrdi) m3);

		Equivalence.equiv(m2, m3);
	}
}