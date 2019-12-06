package interpreters.javacodegeeks;

public interface Expression {

    Clause interpret(String context);

}
