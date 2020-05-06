package designpatterns.gof.behavioral.command.demo;

import java.util.ArrayList;
import java.util.List;

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

public class CommandDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create user and let her compute

		User user = new User();

		// User presses calculator buttons
		user.compute('+', 100);
		user.compute('-', 50);
		user.compute('*', 10);
		user.compute('/', 2);
		// Undo 4 commands
		user.undo(4);
		// Redo 3 commands
		user.redo(3);
	}
}

// / The 'Command' abstract class
abstract class Command {
	public abstract void Execute();

	public abstract void UnExecute();
}

class CalculatorCommand extends Command {

	private char _operator;

	private int _operand;
	private Calculator calculator;

	// Constructor

	public CalculatorCommand(Calculator calculator, char operator, int operand) {

		this.calculator = calculator;
		this._operator = operator;
		this._operand = operand;
	}

	// Execute new command
	@Override
	public void Execute() {
		calculator.Operation(_operator, _operand);
	}

	// Unexecute last command
	@Override
	public void UnExecute() {
		calculator.Operation(Reverse(_operator), _operand);
	}

	// Returns opposite operator for given operator
	private char Reverse(char operator) {

		switch (operator) {
		case '+':
			return '-';
		case '-':
			return '+';
		case '*':
			return '/';
		case '/':
			return '*';
		default:
			throw new IllegalArgumentException("operator " + operator);

		}

	}

}

// / The 'Receiver' class
class Calculator {

	private int curr = 0;

	public void Operation(char operator, int operand) {

		switch (operator) {
		case '+':
			curr += operand;
			break;
		case '-':
			curr -= operand;
			break;

		case '*':
			curr *= operand;
			break;

		case '/':
			curr /= operand;
			break;

		}
		System.out.println("Current value = " + curr
				+ " After executing step of " + operator + " " + operand);

	}

}

// / The 'Invoker' class
class User {
	// Initializers
	private Calculator calculator = new Calculator();
	private List<Command> commands = new ArrayList<Command>();
	private int current = 0;

	public void redo(int levels) {
		System.out.println(" --- Redo " + levels + " Levels ");

		// Perform redo operations
		for (int i = 0; i < levels; i++) {
			if (current < (commands.size() - 1)) {

				Command command = commands.get(current++);

				command.Execute();
			}
		}
	}

	public void undo(int levels) {
		System.out.println(" --- Undo " + levels + " Levels ");

		// Perform undo operations
		for (int i = 0; i < levels; i++) {
			if (current > 0) {
				Command command = commands.get(--current);
				command.UnExecute();
			}
		}
	}

	public void compute(char operator, int operand) {
		// Create command operation and execute it
		Command command = new CalculatorCommand(calculator, operator, operand);
		command.Execute();
		// Add command to undo list
		commands.add(command);
		current++;
	}
}
/*
 * Output Current value = 100 After executing step of + 100 Current value = 50
 * After executing step of - 50 Current value = 500 After executing step of * 10
 * Current value = 250 After executing step of / 2 --- Undo 4 Levels Current
 * value = 500 After executing step of * 2 Current value = 50 After executing
 * step of / 10 Current value = 100 After executing step of + 50 Current value =
 * 0 After executing step of - 100 --- Redo 3 Levels Current value = 100 After
 * executing step of + 100 Current value = 50 After executing step of - 50
 * Current value = 500 After executing step of * 10
 */