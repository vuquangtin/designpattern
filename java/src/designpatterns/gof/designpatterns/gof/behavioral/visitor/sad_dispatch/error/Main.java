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
		Montage m2 = new Montage();
		ComposantOrdi m3 = new Montage();

		m3.equiv(m2);
		m3.equiv(m3);
		m3.equiv((Montage) m3);

		m2.equiv(m3);
		m2.equiv(m2);
		m2.equiv((ComposantOrdi) m3);

		Equivalence.equiv(m2, m3);
	}
}