package com.designpatterns.behavioral.mediators;

import java.util.ArrayList;

//mediator
abstract class Colleague {
	private Mediator mediator;
	private int colleagueCode;

	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}

	public void saleOffer(String stock, int shares) {
		mediator.saleOffer(stock, shares, this.colleagueCode);
	}

	public void buyOffer(String stock, int shares) {
		mediator.buyOffer(stock, shares, this.colleagueCode);
	}

	public void setColleagueCode(int colleagueCode) {
		this.colleagueCode = colleagueCode;
	}
}

// mediator
interface Mediator {
	public void saleOffer(String stock, int shares, int colleagueCode);

	public void buyOffer(String stock, int shares, int colleagueCode);

	public void addColleague(Colleague colleague);
}

// mediator
class StockOffer {
	private int stockShares = 0;
	private String stockSymbol = "";
	private int colleagueCode = 0;

	public StockOffer(int stockShares, String stockSymbol, int colleagueCode) {
		this.stockShares = stockShares;
		this.stockSymbol = stockSymbol;
		this.colleagueCode = colleagueCode;
	}

	public int getStockShares() {
		return stockShares;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public int getColleagueCode() {
		return colleagueCode;
	}

}

// mediatorimpl
class GormanSlacks extends Colleague {

	public GormanSlacks(Mediator mediator) {
		super(mediator);
		System.out.println("Gorman Slacks signed up for the exchange\n");
	}
}

// mediatorimpl
class JTPorman extends Colleague {

	public JTPorman(Mediator mediator) {
		super(mediator);
		System.out.println("JTPorman signed up for the exchange\n");
	}
}

// mediatorimpl
class StockMediator implements Mediator {
	private ArrayList<Colleague> colleagues;
	private ArrayList<StockOffer> stockBuyOffers;
	private ArrayList<StockOffer> stockSellOffers;

	private int colleagueCodes = 0;

	public StockMediator() {
		colleagues = new ArrayList<>();
		stockBuyOffers = new ArrayList<>();
		stockSellOffers = new ArrayList<>();
	}

	@Override
	public void addColleague(Colleague newColleague) {
		colleagues.add(newColleague);
		colleagueCodes++;
		newColleague.setColleagueCode(colleagueCodes);
	}

	@Override
	public void saleOffer(String stock, int shares, int colleagueCode) {
		boolean stockSold = false;
		for (StockOffer offer : stockBuyOffers) {
			if ((offer.getStockSymbol() == stock)
					&& (offer.getStockShares() == shares)) {
				System.out
						.println(shares + " shares of " + stock
								+ " sold to colleague code "
								+ offer.getColleagueCode());
				stockBuyOffers.remove(offer);
				stockSold = true;
			}

			if (stockSold) {
				break;
			}
		}

		if (!stockSold) {
			System.out.println(shares + " share of " + stock
					+ " added to inventory ");
			StockOffer newOffering = new StockOffer(shares, stock,
					colleagueCode);
			stockSellOffers.add(newOffering);
		}
	}

	@Override
	public void buyOffer(String stock, int shares, int colleagueCode) {
		boolean stockBought = false;
		for (StockOffer offer : stockSellOffers) {
			if ((offer.getStockSymbol() == stock)
					&& (offer.getStockShares() == shares)) {
				System.out.println(shares + " shares of " + stock
						+ " bought by colleague code "
						+ offer.getColleagueCode());
				stockSellOffers.remove(offer);
				stockBought = true;
			}

			if (stockBought) {
				break;
			}
		}

		if (!stockBought) {
			System.out.println(shares + " share of " + stock
					+ " added to inventory ");
			StockOffer newOffering = new StockOffer(shares, stock,
					colleagueCode);
			stockBuyOffers.add(newOffering);
		}
	}

	public void getStockOfferings() {
		System.out.println("\nStocks for Sale");

		for (StockOffer offer : stockSellOffers) {
			System.out.println(offer.getStockShares() + " of "
					+ offer.getStockSymbol());
		}

		System.out.println("\nStocks Buy Offers");

		for (StockOffer offer : stockBuyOffers) {
			System.out.println(offer.getStockShares() + " of "
					+ offer.getStockSymbol());
		}
	}

}

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class MediatorDemo {
	public static void main(String[] args) {
		StockMediator nyse = new StockMediator();

		GormanSlacks broker1 = new GormanSlacks(nyse);
		JTPorman broker2 = new JTPorman(nyse);

		broker1.saleOffer("MSFT", 100);
		broker1.saleOffer("GOOG", 50);

		broker2.buyOffer("MSFT", 100);
		broker2.saleOffer("NRG", 10);

		broker1.buyOffer("NRG", 10);

		nyse.getStockOfferings();

	}
}