package in.javacodegeeks;

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
