package designpatterns.gof.book.inline;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.google.common.collect.Lists;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

/**
 * <h1>Builder</h1> Tách rời việc xây dựng (khởi tạo) của một đối tượng phức tạp
 * khỏi phần biểu diễn của nó sao cho cùng 1 tiến trình xây dựng (khởi tạo) có
 * thể tạo ra các biểu diễn khác nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
@DesignPattern(value = Pattern.Builder, description = "生成器")
public class BuilderPattern implements DesignPatternClient {

	/** token类型 */
	private enum TokenType {
		CHARACTER, FONT, PARAGRAPH
	}

	/** 字体类型 */
	private enum Font {
		Font1, Font2, Font3;

		public static Font parse(String literal) {
			if (Font1.name().equals(literal)) {
				return Font1;
			} else if (Font2.name().equals(literal)) {
				return Font2;
			} else if (Font3.name().equals(literal)) {
				return Font3;
			}

			throw ExceptionUtils.unsupport("不支持的字体");
		}
	}

	/** token */
	private class Token {
		/** 类型 */
		private TokenType tokenType;
		/** 内容 */
		private String content;

		public Token(TokenType tokenType, String content) {
			this.tokenType = tokenType;
			this.content = content;
		}

		public TokenType getTokenType() {
			return tokenType;
		}

		public String getContent() {
			return content;
		}

	}

	/** 生成器接口: 文本转换器，负责转换后格式生成的算法 */
	private interface TextConverter {

		/** 转换字符 */
		void convertCharacter(String literal);

		/** 转换字体 */
		void convertFontChange(Font font);

		/** 转换段落 */
		void convertParagraph();

		/** 获取转换结果 */
		Product getResult();
	}

	private class ASCIIConvertet implements TextConverter {
		private ASCIIText text = new ASCIIText();

		@Override
		public Product getResult() {
			return text;
		}

		@Override
		public void convertCharacter(String literal) {
			text.markCharacter(literal);
		}

		@Override
		public void convertFontChange(Font font) {
			// do nothing
		}

		@Override
		public void convertParagraph() {
			// do nothing
		}

	}

	private class TeXConverter implements TextConverter {
		private TeXText text = new TeXText();

		@Override
		public Product getResult() {
			return text;
		}

		@Override
		public void convertCharacter(String literal) {
			text.markCharacter(literal);
		}

		@Override
		public void convertFontChange(Font font) {
			text.markFont(font);
		}

		@Override
		public void convertParagraph() {
			text.markParagraph();
		}
	}

	private class TextWidgetConverter implements TextConverter {
		private TextWidget text = new TextWidget();

		@Override
		public Product getResult() {
			return text;
		}

		@Override
		public void convertCharacter(String literal) {
			text.markCharacter(literal);
		}

		@Override
		public void convertFontChange(Font font) {
			text.markFont(font);
		}

		@Override
		public void convertParagraph() {
			text.markParagraph();
		}
	}

	/** 产品指示型接口 */
	private interface Product {
	}

	private class ASCIIText implements Product {
		private String content;

		public ASCIIText() {
			content = "<ASCIIText>";
		}

		public void markCharacter(String literal) {
			this.content += literal;
		}

		@Override
		public String toString() {
			return this.getClass().getCanonicalName() + ": " + content;
		}

	}

	private class TeXText implements Product {

		// 忽略展示逻辑对应的数据结构
		private List<String> contents = Lists.newArrayList();

		public TeXText() {
			contents.add("<TeXText>");
		}

		public void markFont(Font font) {
			contents.add("<Font: " + font + ">");
		}

		public void markParagraph() {
			contents.add("<Paragraph>");
		}

		public void markCharacter(String literal) {
			contents.add(literal);
		}

		@Override
		public String toString() {
			return this.getClass().getCanonicalName() + ": " + contents;
		}
	}

	private class TextWidget implements Product {
		// 忽略展示逻辑对应的数据结构
		private List<String> contents = Lists.newArrayList();

		public TextWidget() {
			contents.add("<TextWidget>");
		}

		public void markFont(Font font) {
			contents.add("<Font: " + font + ">");
		}

		public void markParagraph() {
			contents.add("<Paragraph>");
		}

		public void markCharacter(String literal) {
			contents.add(literal);
		}

		@Override
		public String toString() {
			return this.getClass().getCanonicalName() + ": " + contents;
		}
	}

	/** 使用生成器的对象: 负责token的解析算法 */
	private class RTFReader {
		private TextConverter textConverter;

		public RTFReader(TextConverter textConverter) {
			this.textConverter = textConverter;
		}

		/** token的解析算法 */
		public void parseRTF(List<Token> tokens) {
			if (CollectionUtils.isEmpty(tokens)) {
				return;
			}

			String tokenContent = null;
			for (Token token : tokens) {
				tokenContent = token.getContent();

				try {
					switch (token.getTokenType()) {
					case CHARACTER:
						textConverter.convertCharacter(tokenContent);
						break;

					case FONT:
						textConverter.convertFontChange(Font
								.parse(tokenContent));
						break;

					case PARAGRAPH:
						textConverter.convertParagraph();

					default:
						continue;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
	}

	@Override
	public void usage() {

		// 生成token序列
		List<Token> tokens = Lists.newArrayList(//
				new Token(TokenType.CHARACTER, "char"), //
				new Token(TokenType.FONT, "Font1"),//
				new Token(TokenType.PARAGRAPH, "para")//
				);

		TextConverter textConverter = null;
		RTFReader rtfReader = null;
		Product product = null;

		textConverter = new ASCIIConvertet();
		rtfReader = new RTFReader(textConverter);
		rtfReader.parseRTF(tokens);
		product = textConverter.getResult();// 获取转换结果
		System.out.println(product);

		textConverter = new TeXConverter();
		rtfReader = new RTFReader(textConverter);
		rtfReader.parseRTF(tokens);
		product = textConverter.getResult();
		System.out.println(product);

		textConverter = new TextWidgetConverter();
		rtfReader = new RTFReader(textConverter);
		rtfReader.parseRTF(tokens);
		product = textConverter.getResult();
		System.out.println(product);
	}

	public static void main(String[] args) {
		new BuilderPattern().usage();
	}
}