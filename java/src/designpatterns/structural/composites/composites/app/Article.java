package composites.app;

/**
 * <h1>Composite</h1> Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn
 * bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng
 * riêng biệt và các thành phần của đối tượng một cách thống nhất.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Article {
	String ref;
	String marque;
	int prixUnitaire;

	public Article(String ref, String marque, int prixUnitaire) {
		this.ref = ref;
		this.marque = marque;
		this.prixUnitaire = prixUnitaire;
	}

	public String getRef() {
		return ref;
	}

	public String getMarque() {
		return marque;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void addArticle() {

	}

	public void removeArticle() {

	}

	public void facturerArticles() {

	}

}