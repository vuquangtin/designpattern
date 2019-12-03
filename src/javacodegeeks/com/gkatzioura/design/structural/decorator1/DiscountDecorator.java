package javacodegeeks.com.gkatzioura.design.structural.decorator1;

import java.math.BigDecimal;

public class DiscountDecorator implements Discount {

    protected Discount discount;

    public DiscountDecorator(Discount discount) {
        this.discount = discount;
    }

    @Override
    public BigDecimal apply(BigDecimal originalPrice) {
        return discount.apply(originalPrice);
    }
}
