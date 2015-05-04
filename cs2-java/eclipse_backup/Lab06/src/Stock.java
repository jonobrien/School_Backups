import java.util.Comparator;

/*
 * Stock.java
 * 
 * Version:
 * $Id: Stock.java,v 1.5 2014/04/08 21:00:22 jvo7822 Exp $
 * 
 * Revisions:
 * $Log: Stock.java,v $
 * Revision 1.5  2014/04/08 21:00:22  jvo7822
 * Fixed total updating in close account and increase/decrease holding.
 *
 * Revision 1.4  2014/04/08 01:21:20  jvo7822
 * Fixed updateStocks to work with stocks in stocks HashMap after calling tickerUpdate.
 *
 * Revision 1.3  2014/04/08 00:23:08  jvo7822
 * Increase/Decrease Holding work. Working on accessPortfolio()...
 *
 * Revision 1.2  2014/04/06 13:55:34  jvo7822
 * Added Stock Class, added comments.
 *
 * Revision 1.1  2014/04/06 00:14:45  jvo7822
 * Added initial Stock class for use in Brokerage.java, this will aid in the completion, similar to pieces was for Gobblet.
 *
 * 
 * 
 */

/**
 * A Stock class to hold separate information
 * for each different stock in the market
 * and is used in brokerage.java
 * 
 * @author Jon O'Brien
 *
 */
public class Stock implements Comparator<Stock>, Comparable<Stock>{
	private String name;//the name of the stock
	private Integer CurrOwned;//the current amount of a particular stock owned
	private int pps;//price per share of the particular stock
	Stock() {	
	}
	
	/**
	 * a stock object for the portfolio.  Called stocks in Brokerage.java
	 * @param name - the tickerSymbol name of the stock.
	 * @param CurrOwned - the number of stocks you own.
	 * @param pps - the price per share of stock.
	 */
	public Stock(String name,int CurrOwned, int pps) {
	this.name = name;
	this.CurrOwned = CurrOwned;
	this.pps = pps;
	}

	/**
	 * the name of the stock.
	 * @return - name of stock.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Amount of stock owned at that moment.
	 * @return integer of number of stocks owned.
	 */
	public int getShares() {
		return CurrOwned;
	}
	
	/**
	 * how much each individual stock costs.
	 * @return double of price per share of stock.
	 */
	public int getPrice() {
		return pps;
	}
	
	/**
	 * how much current amount of stock owned is worth.
	 * @return worth of stock at current price.
	 */
	public int getWorth() {
		int worth = (pps * CurrOwned);
		return worth;
	}
	

    /**
     * compareTo for the comparing stocks' names.
     */
	@Override
	public int compareTo(Stock other) {
		return ((this.name).compareTo(other.getName()));
	}

	/**
	 * comparing for values of stocks.
	 */
	@Override
	public int compare(Stock first, Stock second) {
		
		return second.getWorth() - first.getWorth();
		
	}
	
	/**
	 * to string for name of stock.
	 */
	public String toString() {
		return name;
	}
}