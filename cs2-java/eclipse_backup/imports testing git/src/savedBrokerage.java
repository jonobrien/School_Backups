/*
 * Brokerage.java
 * 
 * Version:
 *   $Id: Brokerage.java,v 1.4 2014/04/06 15:59:19 jvo7822 Exp $
 *   
 * Revisions:
 *   $Log: Brokerage.java,v $
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
import java.util.Comparator;
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
	//TODO define initial investment and pass in INVESTOR_MONEY to this class from investor
	private int total;//the total amount of money the person has
	private Map<String, Stock> stocks= new HashMap<String, Stock>();
    
	
    /* Map containing stocks available and their current price per share.
     */
    private Map<String, Integer> market = 
            new HashMap<String, Integer>();
    
    /**
     * Have to ctrl + click the link
     * 
     * OLYMPICS!!!!
     * http://imgur.com/gallery/sSZNfK0">Imgur</a>
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
        //is there supposed to be something here?
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
        //positive share input, the stock exists in the hashmap, the buyer won't go negative
    	//by buying that amount of stock
    	if (shares > 0 && stocks.get(tickerSymbol) != null 
    			&& (total - stocks.get(tickerSymbol).getWorth()) >= 0) {
    		//create new instance of stock to add to currently owned stock
    		Stock add = new Stock(tickerSymbol, market.get(tickerSymbol));
    		stocks.put(tickerSymbol, add);
    		//add the stocks being bought to the currently owned stocks
    		total = total - stocks.get(tickerSymbol).getWorth();
    		//stocks = new stocks.put(tickerSymbol, add);
    		return true;
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
    	//the stock exists, and the input value is positive
    	if (stocks.get(tickerSymbol) != null && shares > 0) {
        	//stocks.get(tickerSymbol).getShares() = new stocks.get(tickerSymbol).getShares().put()
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
        List<Stock> ListStocks = new ArrayList<Stock>();
    	for (Map.Entry<String, Integer> instance : market.entrySet()) {
    		ListStocks.add(new Stock(instance.getKey(), instance.getValue()));
    	}
        if (choice.equals("N")) {
    		Collections.sort(ListStocks);
        }
        else if (choice.equals("V")) {
        	Collections.sort(ListStocks, new Stock());
    		
    		
    		Comparator<Stock> sortOrder = new Comparator<Stock>() {
    			public int compare(Stock stock1, Stock stock2) {
    				//return stock1.rank - stock2.rank;
    			}
    		};
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        return "";
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
    
        return output;
    }
    
    //maybe the compareTo here or in stock or in a separate interface entirely...
    
    /**
     * Sell all remaining stocks in the portfolio.
     * @return the cash value of the portfolio.
     */
    public int closeAccount() { 
        //probably call reduce holding for each ticker until zero is reached or while not zero
    	//maybe a for each loop with tickers in the portfolio
        return 0;
    }
}
