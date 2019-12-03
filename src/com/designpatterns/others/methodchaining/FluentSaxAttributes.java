package com.designpatterns.others.methodchaining;

import org.xml.sax.helpers.AttributesImpl;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public interface FluentSaxAttributes
{
	FluentSaxAttributes create(String qName, String value);

	FluentSaxAttributes add(String qName, String value);

	AttributesImpl toAttributesImpl();
}
