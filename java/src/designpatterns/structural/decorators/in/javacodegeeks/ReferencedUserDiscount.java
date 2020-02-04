package in.javacodegeeks;

import java.math.BigDecimal;
/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class ReferencedUserDiscount extends DiscountDecorator {

    public static final BigDecimal FIVE = new BigDecimal(5);

    public ReferencedUserDiscount(Discount discount) {
        super(discount);
    }

    @Override
    public BigDecimal apply(BigDecimal originalPrice) {

        BigDecimal discountedPrice = super.apply(originalPrice);

        if(discountedPrice.compareTo(FIVE)<=0) {
            return discountedPrice;
        }

        return discountedPrice.subtract(FIVE);
    }
}
