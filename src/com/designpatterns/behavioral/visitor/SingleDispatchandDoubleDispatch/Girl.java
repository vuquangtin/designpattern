package com.designpatterns.behavioral.visitor.SingleDispatchandDoubleDispatch;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Girl {
	public static void main(final String[] args) {
        Girl hotGirl = new HotGirl();
        Men ladyKiller = new LadyKiller();
        ladyKiller.kiss(hotGirl);
    }
}

class HotGirl extends Girl {
}

class Men {
	public void kiss(HotGirl hotGirl) {
		System.out.println("a Men kissed a Hot girl");
	}

	public void kiss(Girl girl) {
		System.out.println("a Men kissed a Girl");
	}
}

class LadyKiller extends Men {
	@Override
	public void kiss(HotGirl hotGirl) {
		System.out.println("a LadyKiller kissed a Hot girl");
	}

	@Override
	public void kiss(Girl girl) {
		System.out.println("a LadyKiller kissed a Girl");
	}
}