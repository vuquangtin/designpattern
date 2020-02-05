package in.javacodegeeks;
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
public class VoucherFactory {

    public Voucher create(Integer discountPoints) {

        if(discountPoints<=0) {
            throw new IllegalArgumentException("Invalid number of discount points!");
        }

        if(discountPoints<30) {
            return new FoodVoucher();
        } else {
            return new ClothesVoucher();
        }
    }

}
