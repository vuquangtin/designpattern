package designpatterns.gof.behavioral.interpreter.apps;

/**
 * <h1>Interpreter</h1> Định nghĩa 1 biểu diễn ngữ pháp của 1 ngôn ngữ cụ thể,
 * cùng với 1 thông dịch viên sử dụng biểu diễn này để diễn dịch các câu trong
 * ngôn ngữ.<br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class BooleanExpression {

    private ArithmeticExpression expr1, expr2;
    private RelativeOperator op;

    public BooleanExpression(RelativeOperator op, ArithmeticExpression expr1, ArithmeticExpression expr2)
    {
        if (op == null)
            throw new IllegalArgumentException ("null relative operator argument");
        if (expr1 == null || expr2 == null)
            throw new IllegalArgumentException ("null arithmetic expression argument");

        this.op = op;
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean evaluate()
    {
        boolean value = false;

        if (op == RelativeOperator.LE_OP)
            value = expr1.evaluate() <= expr2.evaluate();
        else if (op == RelativeOperator.LT_OP)
            value = expr1.evaluate() < expr2.evaluate();
        else if (op == RelativeOperator.GE_OP)
            value = expr1.evaluate() >= expr2.evaluate();
        else if (op == RelativeOperator.GT_OP)
            value = expr1.evaluate() > expr2.evaluate();
        else if (op == RelativeOperator.EQ_OP)
            value = expr1.evaluate() == expr2.evaluate();
        else if (op == RelativeOperator.NE_OP)
            value = expr1.evaluate() != expr2.evaluate();

        return value;
    }
}