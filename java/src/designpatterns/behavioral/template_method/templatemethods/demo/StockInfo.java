package templatemethods.demo;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * <h1>Template Method</h1> Định nghĩa 1 bộ khung của 1 thuật toán trong 1 chức
 * năng (thao tác) chuyển giao việc thực hiện nó cho lớp con. Mẫu Template
 * Method cho phép lớp con định nghĩa lại cách thực hiện của 1 thuật toán mà
 * không phải thay đổi cấu trúc thuật toán. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class StockInfo {
	/**
	 * Pick the best stock to buy, given a Set of stocks. The returned Set
	 * usually has a single element. In the case of a tie, it will contain more
	 * than 1 element.
	 * 
	 * @param stocks
	 *            the set of stocks being analyzed.
	 * @param toRecommendation
	 *            the stock analysis algorithm.
	 * @return an empty Set only if stocks is itself empty.
	 */
	public Set<Recommendation> strongestRecommendationIn(Set<Stock> stocks,
			Function<Stock, Recommendation> toRecommendation) {
		Set<Recommendation> result = Collections.emptySet();
		if (!stocks.isEmpty()) {
			// gather data related to the stocks, presumably by talking to a
			// database
			int FOR_A_TEN_YEAR_PERIOD = 10;
			for (Stock stock : stocks) {
				addCoreCompanyInfo(stock);
				addQuarterlyReports(stock, FOR_A_TEN_YEAR_PERIOD);
				addMarketPrice(stock);
			}

			// now that all of the data has been gathered together,
			// do the analysis of the stocks; return all that
			// share the max score

			// this fails to handle ties, so we can't use it here
			Optional<Recommendation> best = stocks.stream()
					.map(toRecommendation).max(Recommendation::compareTo);
			if (best.isPresent()) {
				log("Best (no ties found):" + best.get());
			}

			// we need a data structure that has an order, so we use List, not
			// Set
			List<Recommendation> allRecs = stocks.stream()
					.map(toRecommendation).collect(toList());
			Collections.sort(allRecs, Collections.reverseOrder()); // Recommendation.compareTo
			Integer topScore = allRecs.get(0).getScore();
			log("Best :" + topScore);
			result = allRecs.stream()
					.filter(rec -> rec.getScore().equals(topScore))
					.collect(toSet());
			log(result);
		}
		return result;
	}

	/** Puts data into the stock object. */
	public void addCoreCompanyInfo(Stock stock) {
		// ..elided
	};

	/** Puts data into the stock object. */
	public void addQuarterlyReports(Stock stock, Integer numYears) {
		// ..elided
	}

	/** Puts data into the stock object. */
	public void addMarketPrice(Stock stock) {
		// ..elided
	}

	/** Informal test. */
	public static void main(String... args) {
		Set<Stock> stocks = new LinkedHashSet<>();
		stocks.add(new Stock("T"));
		stocks.add(new Stock("ENB"));
		stocks.add(new Stock("BNS"));
		stocks.add(new Stock("CM"));
		stocks.add(new Stock("KO"));

		StockInfo stockInfo = new StockInfo();
		Set<Recommendation> best = stockInfo.strongestRecommendationIn(stocks,
				StockInfo::toyAnalyzer);

		log("Stocks: " + stocks, "Best: " + best);
	}

	/**
	 * This is a silly way to score stocks, based on the length of its name! In
	 * the real world, it would depend on a large data set.
	 */
	private static Recommendation toyAnalyzer(Stock stock) {
		Recommendation result = new Recommendation(stock, stock.getSymbol()
				.length(), new BigDecimal("10.0"));
		return result;
	}

	private static void log(Object... msgs) {
		Stream.of(msgs).forEach(System.out::println);
	}

}

/** Simply holds data related to a stock. */
final class Stock {

	public Stock(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	// ..plus a lot of other data, not included here

	// ..elided

	// PRIVATE

	private String symbol;
}

/** A stock analyst's recommendation for a stock. */
final class Recommendation implements Comparable<Recommendation> {

	public Recommendation(Stock stock, Integer score,
			BigDecimal maxPercentOfHoldings) {
		this.stock = stock;
		this.score = score;
		this.maxPercentOfHoldings = maxPercentOfHoldings;
	}

	/**
	 * Some range, such as -10..+10. Buy-sell-hold recommendations could be
	 * encoded here, as parts of the range.
	 */
	public Integer getScore() {
		return score;
	}

	public BigDecimal getMaxPercentOfHoldings() {
		return maxPercentOfHoldings;
	}

	public Stock getStock() {
		return stock;
	}

	@Override
	public int compareTo(Recommendation that) {
		return this.score.compareTo(that.score);
	}

	@Override
	public String toString() {
		return stock.toString() + ": score=" + score + " max-%-of-holdings="
				+ maxPercentOfHoldings;
	}

	// ..elided

	// PRIVATE

	private Stock stock;
	private Integer score;
	private BigDecimal maxPercentOfHoldings;
}
