package designpatterns.gof.book.inline;

/***
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public interface DesignPatternContants {
	enum Purpose {
		/** 创建型 */
		Creational,
		/** 结构型 */
		Structural,
		/** 行为型 */
		Behavioral
	}

	enum Scope {
		/** 类 */
		CLASS,
		/** 对象 */
		OBJECT
	}

	enum Pattern {
		_("未知", null, null, null), //
		AbstractFactory("", Purpose.Creational, Scope.OBJECT, ""), //
		AdapterC("", Purpose.Structural, Scope.CLASS, ""), //
		AdapterO("", Purpose.Structural, Scope.OBJECT, ""), //
		Bridge("", Purpose.Structural, Scope.OBJECT, ""), //
		Builder("", Purpose.Creational, Scope.OBJECT, ""), //
		ChainofResponsibility("", Purpose.Behavioral, Scope.OBJECT, ""), //
		Command("", Purpose.Behavioral, Scope.OBJECT, ""), //
		Composite("", Purpose.Structural, Scope.OBJECT, ""), //
		Decorator("", Purpose.Structural, Scope.OBJECT, ""), //
		Facade("", Purpose.Structural, Scope.OBJECT, ""), //
		FactoryMethod("", Purpose.Creational, Scope.CLASS, ""), //
		Flyweight("", Purpose.Structural, Scope.OBJECT, ""), //
		Interpreter("", Purpose.Behavioral, Scope.CLASS, ""), //
		Iterator("", Purpose.Behavioral, Scope.OBJECT, ""), //
		Mediator("", Purpose.Behavioral, Scope.OBJECT, ""), //
		Memento("", Purpose.Behavioral, Scope.OBJECT, ""), //
		Observer("", Purpose.Behavioral, Scope.OBJECT, ""), //
		Prototype("", Purpose.Creational, Scope.OBJECT, ""), //
		Proxy("", Purpose.Structural, Scope.OBJECT, ""), //
		Singleton("", Purpose.Creational, Scope.OBJECT, ""), //
		State("", Purpose.Behavioral, Scope.OBJECT, ""), //
		Strategy("", Purpose.Behavioral, Scope.OBJECT, ""), //
		TemplateMethod("", Purpose.Behavioral, Scope.CLASS, ""), //
		Visitor("", Purpose.Behavioral, Scope.OBJECT, "");

		String cnName;
		Purpose purpose;
		Scope scope;
		String description;

		Pattern(String cnName, Purpose purpose, Scope scope, String description) {
			this.cnName = cnName;
			this.purpose = purpose;
			this.scope = scope;
			this.description = description;
		}

	}

}