package com.designpatterns.behavioral.visitor.SingleDispatchandDoubleDispatch2;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public interface Visitor {
    void visit(AmericanLady lady);

    void visit(JapanLady lady);
}