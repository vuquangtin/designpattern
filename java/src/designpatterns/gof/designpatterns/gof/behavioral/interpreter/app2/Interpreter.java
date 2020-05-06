package designpatterns.gof.behavioral.interpreter.app2;

import java.io.FileNotFoundException;

import app.abstractclass.Resource;

/**
 * <h1>Interpreter</h1> Định nghĩa 1 biểu diễn ngữ pháp của 1 ngôn ngữ cụ thể,
 * cùng với 1 thông dịch viên sử dụng biểu diễn này để diễn dịch các câu trong
 * ngôn ngữ.<br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class Interpreter {

	public static void main(String[] args) {
		String name;
		for (int i = 1; i <= 6; i++) {
			name = "test" + i + ".jl";
			run(name);
		}

	}

	public static void run(String name) {
		try {
			System.out.println("---------------" + name + "---------------------------------------------");
			Parser p = new Parser(Resource.PATH_INTERPRETER + name);
			Program prog = p.parse();
			prog.execute();
			// to see chart of tokens and lexemes
			LexicalAnalyzer lex = new LexicalAnalyzer(Resource.PATH_INTERPRETER + name);
			lex.printLex();
			// Memory.displayMemory(); // to see results of assignment statement
		} catch (ParserException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (LexicalException e) {
			e.printStackTrace();
		}
	}

}