package factorymethods.products;
/**
 * <h1>Factory Method</h1>Cung cấp 1 giao diện để tạo ra đối tượng nhưng để lớp
 * con quyết định kiểu đối tượng nào sẽ dc tạo.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class Client {

    public static void main(String[] args) {

        CreatFactory mCreatFactory=new CreatFactory();
        Product mProduct=mCreatFactory.creatProduct(Product1.class);
        mProduct.start();
        mProduct.end();
        Product mProduct1=mCreatFactory.creatProduct(Product2.class);
        mProduct1.start();
        mProduct1.end();



    }
}