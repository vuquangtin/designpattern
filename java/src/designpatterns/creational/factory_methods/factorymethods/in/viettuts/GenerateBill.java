package factorymethods.in.viettuts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>Factory Method</h1>Cung cấp 1 giao diện để tạo ra đối tượng nhưng để lớp
 * con quyết định kiểu đối tượng nào sẽ dc tạo.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class GenerateBill {
	public static void main(String args[]) throws IOException {
		GetPlanFactory planFactory = new GetPlanFactory();

		System.out.print("Nhap ten cua plan de tao hoa don: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String planName = br.readLine();
		System.out.print("Nhap so luong don vi cho hoa don: ");
		int unit = Integer.parseInt(br.readLine());

		Plan p = planFactory.getPlan(planName);

		System.out.print("Hoa don " + planName + " cua  " + unit + " don vi la: ");
		p.getRate();
		p.calculateBill(unit);
	}
}