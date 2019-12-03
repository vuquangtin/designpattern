package com.designpattern.web.itsenka;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ClientComposite {
    public static void main(String[] args) {
        Composite comp1 = new Composite("A");
        Composite comp11 = new Composite("AB");
        Composite comp12 = new Composite("AC");
        Composite comp13 = new Composite("AD");
        Composite comp111 = new Composite("ABE");
        Composite comp112 = new Composite("ABF");
        try {
            comp1.add(comp11);
            comp1.add(comp12);
            comp1.add(comp13);
            comp11.add(comp111);
            comp11.add(comp112);
            comp11.add(new Leaf("a", 1));
            comp11.add(new Leaf("b", 2));
            comp11.add(new Leaf("c", 3));
            comp13.add(new Leaf("d", 4));
            comp112.add(new Leaf("e", 5));
            int sum = comp1.sumValue();
            System.out.println("----");
            System.out.println("  " + sum);
            System.out.println("");
            comp1.printTree("");
        } catch (ComponentAddException e) {
            e.printStackTrace();
        }
    }
}