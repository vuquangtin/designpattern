package commands.banks;
/**
 * <h1>Command</h1> Đóng gói một yêu cầu request như một đối tượng, bằng cách đó
 * cho phép bạn tham số hóa các client với các request khác nhau, các queue và
 * log request, và hỗ trợ các hoạt động (operation) có thể “undo”.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class BankApp {
	 
    private Command openAccount;
    private Command closeAccount;
 
    public BankApp(Command openAccount, Command closeAccount) {
        this.openAccount = openAccount;
        this.closeAccount = closeAccount;
    }
     
    public void clickOpenAccount() {
        System.out.println("User click open an account");
        openAccount.execute();
    }
     
    public void clickCloseAccount() {
        System.out.println("User click close an account");
        closeAccount.execute();
    }
}