package designpatterns.gof.book.inline;

import java.util.List;

import com.google.common.collect.Lists;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

/**
 * <h1>Interpreter</h1> Định nghĩa 1 biểu diễn ngữ pháp của 1 ngôn ngữ cụ thể,
 * cùng với 1 thông dịch viên sử dụng biểu diễn này để diễn dịch các câu trong
 * ngôn ngữ.<br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
@DesignPattern(value = Pattern.Interpreter, description = "解释器")
public class InterpreterPattern implements DesignPatternClient {

	private String SYMBOL_SEP = " | ";
	private String SYMBOL_AND = " & ";
	private String SYMBOL_MUL = " * ";
	private String SYMBOL_LB = " ( ";
	private String SYMBOL_RB = " ) ";

	private enum Literal {
		a('a'), b('b'), c('c'), d('d'), e('e'), f('f'), g('g'), //
		h('h'), i('i'), j('j'), k('k'), l('l'), m('m'), n('n'), //
		o('o'), p('p'), q('q'), r('r'), s('s'), t('t'), //
		u('u'), v('v'), w('w'), x('x'), y('y'), z('z');

		private char literal;

		Literal(char literal) {
			this.literal = literal;
		}

		public char get() {
			return literal;
		}
	}

	private abstract class RegularExpression {
		/** 解释 */
		public abstract String intepret();
	}

	private class LiteralExpression extends RegularExpression {
		public List<Literal> literals;

		@Override
		public String intepret() {
			StringBuffer sb = new StringBuffer();
			for (Literal literal : literals) {
				sb.append(literal.get());
			}
			return sb.toString();
		}
	}

	private class AlternationExpression extends RegularExpression {
		public RegularExpression alternative1;
		public RegularExpression alternative2;

		@Override
		public String intepret() {
			return alternative1.intepret() + SYMBOL_SEP
					+ alternative2.intepret();
		}

	}

	private class SequenceExpression extends RegularExpression {
		public RegularExpression sequence1;
		public RegularExpression sequence2;

		@Override
		public String intepret() {
			return sequence1.intepret() + SYMBOL_AND + sequence2.intepret();
		}
	}

	private class RepetitionExpression extends RegularExpression {
		public RegularExpression repetition;

		@Override
		public String intepret() {
			if (repetition instanceof AlternationExpression
					|| repetition instanceof SequenceExpression) {
				return SYMBOL_LB + repetition.intepret() + SYMBOL_RB
						+ SYMBOL_MUL;
			} else {
				return repetition.intepret() + SYMBOL_MUL;
			}
		}
	}

	@Override
	public void usage() {
		// raining & (dogs | cats) *

		// 基础准备
		List<Literal> raining = Lists.newArrayList(
				//
				Literal.r, Literal.a, Literal.i, Literal.n, Literal.i,
				Literal.n, Literal.g);
		List<Literal> dogs = Lists.newArrayList(Literal.d, Literal.o,
				Literal.g, Literal.s);
		List<Literal> cats = Lists.newArrayList(Literal.c, Literal.a,
				Literal.t, Literal.s);

		// 从最内层的表示开始
		LiteralExpression rainningLE = new LiteralExpression();
		rainningLE.literals = raining;
		LiteralExpression dogsLE = new LiteralExpression();
		dogsLE.literals = dogs;
		LiteralExpression catsLE = new LiteralExpression();
		catsLE.literals = cats;

		AlternationExpression ae = new AlternationExpression();
		ae.alternative1 = dogsLE;
		ae.alternative2 = catsLE;

		RepetitionExpression re = new RepetitionExpression();
		re.repetition = ae;

		SequenceExpression se = new SequenceExpression();
		se.sequence1 = rainningLE;
		se.sequence2 = re;

		// 解释
		System.out.println(se.intepret());
	}

	public static void main(String[] args) {
		new InterpreterPattern().usage();
	}

}