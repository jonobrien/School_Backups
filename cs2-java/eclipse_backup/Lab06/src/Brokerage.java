/*
 * Brokerage.java
 * 
 * Version:
 *   $Id: Brokerage.java,v 1.8 2014/04/08 21:00:23 jvo7822 Exp $
 *   
 * Revisions:
 *   $Log: Brokerage.java,v $
 *   Revision 1.8  2014/04/08 21:00:23  jvo7822
 *   Fixed total updating in close account and increase/decrease holding.
 *
 *   Revision 1.7  2014/04/08 01:21:20  jvo7822
 *   Fixed updateStocks to work with stocks in stocks HashMap after calling tickerUpdate.
 *
 *   Revision 1.6  2014/04/08 00:56:45  jvo7822
 *   Finished, adding more comments.
 *
 *   Revision 1.5  2014/04/08 00:23:08  jvo7822
 *   Increase/Decrease Holding work. Working on accessPortfolio()...
 *
 *   Revision 1.4  2014/04/06 15:59:19  jvo7822
 *   Working on increase/decrease holding, working with the hashMaps.
 *
 *   Revision 1.3  2014/04/06 13:55:34  jvo7822
 *   Added Stock Class, added comments.
 *
 *   Revision 1.2  2014/04/06 00:14:45  jvo7822
 *   Added initial Stock class for use in Brokerage.java, this will aid in the completion, similar to pieces was for Gobblet.
 *
 *   Revision 1.1  2014/04/03 12:25:18  jvo7822
 *   Initial  commit.
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the Brokerage class.  In this simplified simulation
 * the brokerage will manage a single client's investments.  It will
 * also track the movement of the market as a whole.
 * 
 * @author atd: Aaron T Deever
 * @author Jon O'Brien
 *
 */
public class Brokerage {
	private int total; /* the total amount of money the person has */
	private Map<String, Stock> stocks= new HashMap<String, Stock>(); /* the portfolio of Stock objects */    
	
    /* Map containing stocks available and their current price per share.
     */
    private Map<String, Integer> market = 
            new HashMap<String, Integer>();
    
    /**
     * MEMES FOR DAYS!!
     * ***Have to ctrl + click the link in here, or just click on it in javadocs tab***
     * <a href="http://i.imgur.com/ju1CgAo.jpg">Every Time!</a>
     * 
     * 
     * Constructor.  Initializes the investor and the market as a whole.
     * In this simplified simulation there is just a single investor and the
     * whole market is tracked by the brokerage.
     * @param initialInvestment initial investment
     */
    public Brokerage(int initialInvestment) { 
        
        /* initialize the market */
        market.put("GOOG", 1183);
        market.put("AMZN", 360);
        market.put("AAPL", 532);
        market.put("YHOO", 38);
        market.put("MSFT", 40);
        market.put("EBAY", 57);
        this.total = initialInvestment;
    }
    
    /**
     * THAT MOMENT WHEN YOU ENCOUNTER THAT ERROR-TEXT
     * http://i.imgur.com/v1QA0AZ.jpg
     * 
     * Add to Investor's holding.  This function should error-check to 
     * ensure the ticker symbol exists, the number of shares requested
     * is a positive value, and that the client has sufficient funds.
     * @param tickerSymbol the particular stock to buy
     * @param shares the number of shares requested
     * @return true if transaction is completed.  False otherwise.
     */
    public boolean increaseHolding(String tickerSymbol, int shares) { 
        /*positive share input, the stock exists in the market, the buyer won't go negative by buying that amount of stock */
    	if (shares > 0 && market.containsKey(tickerSymbol) && (total - (market.get(tickerSymbol)*shares)) >= 0) { 
    		
    		/*create new instance of stock Title, add shares (requested + old shares), with current price */ 
    		if (!stocks.containsKey(tickerSymbol)) {
    			/* first time buying that stock type */
    			Stock add = new Stock(tickerSymbol, shares, (market.get(tickerSymbol)));
    			stocks.put(tickerSymbol, add); /*add the stocks being bought to the currently owned stocks */    			
    			
    			//System.out.println("total amount before initial: " + total);
    			total = total - (market.get(tickerSymbol)*shares); 
    			//System.out.println("total amount after initial: " + total);
    			return true;
    		}
    		else { //has stocks of that type already
    			Stock add = new Stock(tickerSymbol,(shares + stocks.get(tickerSymbol).getShares()), (market.get(tickerSymbol)));
    			stocks.put(tickerSymbol, add); /*add the stocks being bought to the currently owned stocks */

    			//System.out.println("total amount before **: " + total);
    			total = total - (market.get(tickerSymbol)*shares); 
    			//System.out.println("total amount after **: " + total);
    			
    			return true;
    		}
    	}
    		return false;
    }
    
    /**
     * Reduce Investor's holding.  This function should error-check to 
     * ensure the ticker symbol exists, and the number of shares to reduce
     * is a positive value no greater than the number currently held.
     * @param tickerSymbol the particular stock to sell
     * @param shares the number of shares to sell
     * @return true if transaction is completed.  False otherwise.
     */
    public boolean reduceHolding(String tickerSymbol, int shares) { 
		/* enought stocks in the portfolio, portfolio has that stock, price is current */
    	if (market.containsKey(tickerSymbol) && stocks.containsKey(tickerSymbol) && shares > 0 
    			&& shares <= stocks.get(tickerSymbol).getShares()) {
    		/*create new instance of stock Title, add shares (requested + old shares), with current price  */
    		Stock reduce = new Stock(tickerSymbol, stocks.get(tickerSymbol).getShares() - shares, (market.get(tickerSymbol)));
    		stocks.put(tickerSymbol, reduce); 
    		
    		//System.out.println("total amount before: " + total);
    		total = total + (market.get(tickerSymbol)*shares);
    		//System.out.println("total after: " + total);
    		
    		return true;
    	}
        return false;
    }
    
    /**
     * Generates a string to represent the investor's portfolio.  Can be
     * requested in alphabetical order, or in decreasing order of the
     * value of the holdings (shares * price per share).
     * @param choice "N" for by name, "V" for by value
     * @return String representing the portfolio.  This string must
     * include the name, number of shares, price per share, and total 
     * value for each stock in the portfolio.  The entries must be
     * sorted according to the input request.
     */
    public String accessPortfolio(String choice) { 
    	List<Stock> portfolio = new ArrayList<Stock>();    	
    	for (Map.Entry<String, Stock> entry : stocks.entrySet()) {
    		String key = entry.getKey();
    		Stock value = stocks.get(key);
    		portfolio.add(value);
    	}
       String print;
       print = "CURRENT PORTFOLIO\n";
       print += "Cash Available: " + total + "\n";
       print += "SYMBOL SHARES PRICE TOTAL VALUE\n";
       print += "===============================\n";
    	
        if (choice.equals("N")) {
    		Collections.sort(portfolio);
        }
        else if (choice.equals("V")) {
        	Collections.sort(portfolio, new Stock());
    	}
        for (Stock stock : portfolio) {
        	  /* the formatting statements for the portfolio printing */
        	print =print+String.format("%5s", stock.getName());
        	print=print+String.format("%7d", stock.getShares());		
        	print=print+String.format("%7d", stock.getPrice());
        	print=print+String.format("%11d", stock.getWorth());
        	print = print + "\n";
        }
        return print;
    }
    
    /**
     * Update the price per share of each stock using a random value to
     * determine the change.  A multiplier is applied to the stock price and
     * the result is rounded to the nearest integer.  A minimum price of $1 is
     * required. (For the given inputs, this constraint will always hold
     * without checking). This method can also be used to update the price of
     * a stock inside any stock object that contains that information.
     * @return A string "ticker" that indicates
     *         the ticker symbols and their prices.
     */
    public String tickerUpdate() { 
        String output = "";
        for(String str : market.keySet()) { 
            int currVal = market.get(str);
            int num = (int)(Math.random() * 5);
            int newVal;
            switch(num) { 
            case 0:
                newVal = (int)(currVal * .9 + 0.5);
                break;
            case 1:
                newVal = (int)(currVal * .95 + 0.5);
                break;
            case 2:
                newVal = currVal;
                break;
            case 3:
                newVal = (int)(currVal * 1.1 + 0.5);
                break;
            case 4:
            default:
                newVal = (int)(currVal * 1.2 + 0.5);
                break;
            }
            market.put(str,  newVal);
            output += str + " " + newVal + "      ";
        }
        updateStocks();
        return output;
    }
    	
    
    /**
     * updates the list of prices of stocks after updating the market ticker prices.
     */
    public void updateStocks() {

    	for (Map.Entry<String, Stock> entry : stocks.entrySet()) {
    		Integer currentShares = stocks.get(entry.getKey()).getShares();
    		String name = stocks.get(entry.getKey()).getName();
    		Integer price = market.get(entry.getKey());
    		//System.out.println("key " + stocks.get(entry.getKey()) + " value " + currentShares);
    		Stock update = new Stock(name, currentShares, price );
    		stocks.put(entry.getKey(), update);
    	}
    }

    
    /**
     * Sell all remaining stocks in the portfolio.
     * @return the cash value of the portfolio.
     */
    public int closeAccount() { 
    	for (Map.Entry<String, Stock> entry : stocks.entrySet())
    	{
    		String key = entry.getKey();
    		Stock value = entry.getValue();
    		reduceHolding(key, value.getShares());
    		//System.out.println("total " +total);
    	}
        return total;
    }
}
