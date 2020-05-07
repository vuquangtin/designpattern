package designpatterns.gof.creational.builder.inline;

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
public class BuilderDemo {
	// Client
	public static void main(String[] args) {

		// method 1
		Director director = new Director(new Builder());
		Product product1 = director.construct();
		System.out.println(product1);

		// method2
		Product product2 = Product.builder().info("info 3").name("name 3")
				.build();
		System.out.println(product2);
	}

	/**
	 * 产品类
	 */

	static class Product {

		private String name;

		private String info;

		public Product(String name, String info) {
			this.name = name;
			this.info = info;
		}

		public Product() {
			// TODO Auto-generated constructor stub
		}

		public static Product.ProductBuilder builder() {
			return new Product.ProductBuilder();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		// 方法2 和lombok里面一样
		public static class ProductBuilder {

			private String name;

			private String info;

			ProductBuilder() {
			}

			Product.ProductBuilder name(String name) {
				this.name = name;
				return this;
			}

			Product.ProductBuilder info(String info) {
				this.info = info;
				return this;
			}

			public Product build() {
				return new Product(this.name, this.info);
			}
		}
	}

	/**
	 * 方法1 有builder 和 director 一个是构建 一个是逻辑 创造者
	 */
	static class Builder {
		private Product product = new Product();

		Builder name(String name) {
			product.setName(name);
			return this;
		}

		Builder info(String info) {
			product.setInfo(info);
			return this;
		}

		Product build() {
			return product;
		}
	}

	/**
	 * 指挥者
	 */
	static class Director {
		private Builder builder;

		public Director(Builder builder) {
			this.builder = builder;
		}

		public Product construct() {
			builder.name("name 2");
			builder.info("info 2");
			return builder.build();
		}
	}

}