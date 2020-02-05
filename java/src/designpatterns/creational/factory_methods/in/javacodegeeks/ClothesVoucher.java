package in.javacodegeeks;

import java.util.UUID;
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
public class ClothesVoucher implements Voucher {

    private UUID code;
    private static final String htmlMessage = "<html><body><h1>Clothes Voucher</h1></body></html>";

    public ClothesVoucher() {
        code = UUID.randomUUID();
    }

    public String code() {
        return code.toString();
    }

    public String htmlMessage() {
        return htmlMessage;
    }
}
