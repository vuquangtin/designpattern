package factorymethods.atm;

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
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class ATMTestClient {

	public static void main(String[] args) {
		System.out.println("Enter your selection:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String selection = null;
		try {
			selection = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Factory factory = StatementFactory.getUniqueInstance();
		StatementType objStmtType = factory.createStatements(selection);
		System.out.println(objStmtType.print());
	}

}