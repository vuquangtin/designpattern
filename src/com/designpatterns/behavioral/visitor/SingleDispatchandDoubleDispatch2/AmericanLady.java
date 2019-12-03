package com.designpatterns.behavioral.visitor.SingleDispatchandDoubleDispatch2;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class AmericanLady implements Lady {
    public void sayILoveYou() {
        System.out.println("I love you");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
