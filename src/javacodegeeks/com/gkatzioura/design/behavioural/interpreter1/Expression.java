package javacodegeeks.com.gkatzioura.design.behavioural.interpreter1;

public interface Expression {

    Clause interpret(String context);

}
