package composites.catalogs;
/**
 * <h1>Composite</h1> Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn
 * bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng
 * riêng biệt và các thành phần của đối tượng một cách thống nhất.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Product extends CatalogComponent{

    private String name;
    private double price;
    public Product (String name, double price){
        this.name=name;
        this.price=price;
    }

    @Override
    public String getName() {
        return  this.name;
    }


    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void print(){
        System.out.println("Product name: "+name+" Price: "+price);
    }
}