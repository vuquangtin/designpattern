package com.designpatterns.behavioral.visitor.SingleDispatchandDoubleDispatch2;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class SayLoveVisitor implements Visitor {
    @Override
    public void visit(AmericanLady lady) {
        lady.sayILoveYou();
    }

    @Override
    public void visit(JapanLady lady) {
        lady.sayAishiteImasu();
    }
}