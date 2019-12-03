package javacodegeeks.com.gkatzioura.design.behavioural.interpreter1;

public class QueryExpression implements Expression {

    @Override
    public SelectClause interpret(String context) {

        SelectClause selectClause = new SelectExpression().interpret(context);

        if(context.contains("WHERE")) {

            WhereClause whereClause = new WhereExpression().interpret(context);
            selectClause.setWhereClause(whereClause);
        }

        return selectClause;
    }

}
