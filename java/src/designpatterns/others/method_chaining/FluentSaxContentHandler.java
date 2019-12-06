package method_chaining;

import org.xml.sax.SAXException;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public interface FluentSaxContentHandler
{
	void startDoc() throws SAXException;

	void endDoc() throws SAXException;

	FluentSaxContentHandler openElem(String qName) throws SAXException;

	FluentSaxContentHandler openElem(String qName, FluentSaxAttributes attributes) throws SAXException;

	FluentSaxContentHandler setText(String text) throws SAXException;

	void closeElem(String qName) throws SAXException;
}
