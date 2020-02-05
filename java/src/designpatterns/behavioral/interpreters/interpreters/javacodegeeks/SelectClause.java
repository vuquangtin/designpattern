package interpreters.javacodegeeks;

import java.util.Optional;
/**
 * <h1>Interpreter</h1> Định nghĩa 1 biểu diễn ngữ pháp của 1 ngôn ngữ cụ thể,
 * cùng với 1 thông dịch viên sử dụng biểu diễn này để diễn dịch các câu trong
 * ngôn ngữ.<br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class SelectClause implements Clause {

    private Optional<WhereClause> optWhereClause = Optional.empty();

    public <T> T load(Class<T> valueType) {

        /**
         * Apply filter according to the where clause
         */
        if(optWhereClause.isPresent()) {

        }

        /**
         * Load data
         */

        /**
         * Serialize/Deserialize data based on the type
         * For example if you use jackson it will be:  new ObjectMapper().readValue("text",valueType);
         */


        return null;
    }

    public void setWhereClause(WhereClause whereClause) {
        this.optWhereClause = Optional.of(whereClause);
    }
}
