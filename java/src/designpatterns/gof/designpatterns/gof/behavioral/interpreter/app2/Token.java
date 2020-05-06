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
public class Token
{

    private int rowNumber;

    private int columnNumber;

    private String lexeme;

    private TokenType tokType;

    /**
     * @param rowNumber - must be positive
     * @param columnNumber - must be positive
     * @param lexeme - cannot be null nor empty
     * @param tokType - cannot be null
     * @throws IllegalArgumentException if any precondition is not satisfied
     */
    public Token(int rowNumber, int columnNumber, String lexeme,
                 TokenType tokType)
    {
        if (rowNumber <= 0)
            throw new IllegalArgumentException ("invalid row number argument");
        if (columnNumber <= 0)
            throw new IllegalArgumentException ("invalid column number argument");
        if (lexeme == null || lexeme.length() == 0)
            throw new IllegalArgumentException ("invalid lexeme argument");
        if (tokType == null)
            throw new IllegalArgumentException ("invalid TokenType argument");
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.lexeme = lexeme;
        this.tokType = tokType;
    }

    public int getRowNumber()
    {
        return rowNumber;
    }

    public int getColumnNumber()
    {
        return columnNumber;
    }

    public String getLexeme()
    {
        return lexeme;
    }

    public TokenType getTokType()
    {
        return tokType;
    }


}