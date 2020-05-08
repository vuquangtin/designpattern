package designpatterns.gof.book.inline;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

/**
 * <h1>Facade</h1> Cung cấp một interface thống nhất cho một tập các interface
 * trong một hệ thống con (subsystem). Façade định nghĩa một interface mức cao
 * làm cho hệ thống con dễ dàng sử dụng hơn.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
@DesignPattern(value = Pattern.Facade, description = "外观")
public class FacadePattern implements DesignPatternClient {

	private class Compiler {
		public void compile() {
			// 模拟编译过程
			new CompilerSystem.Scanner();

			new CompilerSystem.Parser();

			new CompilerSystem.ProgramNodeBuilder().build();

			new CompilerSystem.RISCCodeGenerator(
					new CompilerSystem.BytecodeStream());
		}
	}

	private static class CompilerSystem {
		static class Stream {
		}

		static class BytecodeStream extends Stream {
		}

		static abstract class CodeGenerator {
			@SuppressWarnings("unused")
			private BytecodeStream bytecodeStream = new BytecodeStream();

			public CodeGenerator(BytecodeStream bytecodeStream) {
				this.bytecodeStream = bytecodeStream;
			}

		}

		@SuppressWarnings("unused")
		static class StackMachineCodeGenerator extends CodeGenerator {
			public StackMachineCodeGenerator(BytecodeStream bytecodeStream) {
				super(bytecodeStream);
			}
		}

		static class RISCCodeGenerator extends CodeGenerator {
			public RISCCodeGenerator(BytecodeStream bytecodeStream) {
				super(bytecodeStream);
			}
		}

		static class Scanner {
		}

		static class Token {
		}

		static class Symbol {
		}

		static class Parser {
		}

		abstract static class ProgramNode {
			@SuppressWarnings("unused")
			public Token token;
			@SuppressWarnings("unused")
			public Symbol symbol;
		}

		static class StatementNode extends ProgramNode {
		}

		static class ExpressionNode extends ProgramNode {
		}

		static class VariableNode extends ProgramNode {
		}

		static class ProgramNodeBuilder {
			private StatementNode statementNode;
			private ExpressionNode expressionNode;
			private VariableNode variableNode;

			public ProgramNodeBuilder() {
				statementNode = new StatementNode();
				expressionNode = new ExpressionNode();
				variableNode = new VariableNode();
			}

			public void build() {
				statementNode.token = null;
				expressionNode.token = null;
				variableNode.token = null;
			}
		}
	}

	@Override
	public void usage() {
		new Compiler().compile();
	}

	public static void main(String[] args) {
		new FacadePattern().usage();
	}

}