package lambda.with;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
 
public class LambdaExpressionExample11 {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<Product>();
        list.add(new Product(1, "Samsung A8", 17000f));
        list.add(new Product(3, "Iphone 8X", 65000f));
        list.add(new Product(2, "Sony Xperia X8", 25000f));
        list.add(new Product(4, "Nokia L7", 15000f));
        list.add(new Product(5, "Redmi Note 7", 26000f));
        list.add(new Product(6, "Lenevo Vibe", 19000f));
 
        // sử dụng biểu thức lambda để filter data
        Stream<Product> filtered_data = list.stream()
                .filter(p -> p.price > 20000);
 
        // sử dụng lambda duyệt các phần tử của collection
        filtered_data.forEach(product -> {
            System.out.println(product.name + ": " + product.price);
        });
    }
}