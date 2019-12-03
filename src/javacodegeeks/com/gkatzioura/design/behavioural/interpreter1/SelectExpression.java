package javacodegeeks.com.gkatzioura.design.behavioural.interpreter1;

public class SelectExpression implements Expression {

    @Override
    public SelectClause interpret(String context) {
        SelectClause selectClause = new SelectClause();

        /**
         * Parse text and check for expressions like `SELECT * FROM ` or `SELECT A,B,C FROM` .
         */

        return selectClause;
    }

}
