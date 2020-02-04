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
public class TwoYearPlanDiscount extends DiscountDecorator {

	public static final BigDecimal NINETY_NINE = new BigDecimal(95);
	public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

	public TwoYearPlanDiscount(Discount discount) {
		super(discount);
	}

	@Override
	public BigDecimal apply(BigDecimal originalPrice) {
		return super.apply(originalPrice).multiply(NINETY_NINE)
				.divide(ONE_HUNDRED);
	}

}
