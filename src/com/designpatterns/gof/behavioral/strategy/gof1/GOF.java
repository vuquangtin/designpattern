package com.designpatterns.gof.behavioral.strategy.gof1;

/**
 * Design Patterns
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/strategy.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class GOF {
	public static void main(String[] args) {
		Context context = new Context(ConcreteStrategyA.ID);
		System.out.println(context.contextMeshod());
		context.setStrategy(ConcreteStrategyB.ID);
		System.out.println(context.contextMeshod());
	}

}

interface Strategy {
	public abstract String strategyMethod();
}

class ConcreteStrategyA implements Strategy {
	// ストラテジオブジェクトにIDを保持させる。オブジェクト生成するときの判断に使用する。
	public static final int ID = 1;

	public String strategyMethod() {
		return "戦略A";
	}
}

class ConcreteStrategyB implements Strategy {
	public static final int ID = 2;

	public String strategyMethod() {
		return "戦略B";
	}
}

class Context {
	private Strategy strategy;

	public Context(int id) {
		setStrategy(id);
	}

	public void setStrategy(int id) {
		// オブジェクト生成を「StrategyFactory」に切り出します。
		this.strategy = StrategyFactory.createStrategy(id);
	}

	public String contextMeshod() {
		return strategy.strategyMethod();
	}
}

class StrategyFactory {
	public static Strategy createStrategy(int id) {
		Strategy strategy = null;
		switch (id) {
		case ConcreteStrategyA.ID:
			strategy = new ConcreteStrategyA();
			break;
		case ConcreteStrategyB.ID:
			strategy = new ConcreteStrategyB();
			break;
		}
		return strategy;
	}
}