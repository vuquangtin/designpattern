package javacodegeeks.com.gkatzioura.design.structural.decorator1;

import java.math.BigDecimal;

public interface Discount {

    BigDecimal apply(BigDecimal originalPrice);

}
