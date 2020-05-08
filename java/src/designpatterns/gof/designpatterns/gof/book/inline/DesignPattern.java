package designpatterns.gof.book.inline;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

/***
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target(value = { ElementType.TYPE, ElementType.FIELD, ElementType.METHOD,
		ElementType.PARAMETER, ElementType.CONSTRUCTOR,
		ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE,
		ElementType.PACKAGE })
public @interface DesignPattern {
	Pattern value() default Pattern._;

	String description() default "";
}