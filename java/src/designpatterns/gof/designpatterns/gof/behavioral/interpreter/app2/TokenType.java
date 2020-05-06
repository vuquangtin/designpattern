package designpatterns.gof.behavioral.interpreter.app2;

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
public enum TokenType
{
    ID_TOK, ADD_TOK, MUL_TOK, ASSIGN_TOK, CONST_TOK, EOS_TOK,
    SUB_TOK, DIV_TOK, REV_DIV_TOK, EXP_TOK, MOD_TOK,
    LE_TOK, LT_TOK, GE_TOK, GT_TOK, EQ_TOK, NE_TOK,
    LEFT_PAREN_TOK, RIGHT_PAREN_TOK,
    IF_TOK, ELSE_TOK,
    FOR_TOK, WHILE_TOK,
    FUNCTION_TOK, THEN_TOK, END_TOK, PRINT_TOK, REPEAT_TOK, UNTIL_TOK,
    COL_TOK
}