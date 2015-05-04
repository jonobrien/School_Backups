package carRadio;

/*
 * CarRadio.java
 * 
 * 
 * Version:
 *  $Id: CarRadio.java,v 1.5 2014/02/16 00:29:00 jvo7822 Exp $
 * Revisions:
 *  $Log: CarRadio.java,v $
 *  Revision 1.5  2014/02/16 00:29:00  jvo7822
 *  Final maybe.
 *
 *  Revision 1.4  2014/02/11 22:42:58  jvo7822
 *  Display formatting was worked on.
 *
 *  Revision 1.3  2014/02/11 19:48:51  jvo7822
 *  Everything works except presets, still conducting tests and formatting Display.
 *
 *  Revision 1.2  2014/02/11 03:15:15  jvo7822
 *  Commit 2: hopefully just need to finish display.
 *
 *  Revision 1.1  2014/02/09 03:43:17  jvo7822
 *  Initial commit.  Some {} errors in CarRadio.java.
 *
 * 
 */

import java.util.*;

/**
 * @author Jon O'Brien jvo7822@rit.edu
 * 
 */


public class CarRadio {

	/**
	 * @param args
	 */
	private FreqBand currentBand = FreqBand.AM;
	private static final int VOL_MIN = 0;
	private static final int VOL_MAX = 20;
	private static final int VOL_STEP = 1;
	private StationData stationData;
	private boolean power = false;
	private boolean set = false;
	private boolean mute = false;
	private int volume = 0;
	private final int defAMband = 520;
	private final int maxAMBand = 1610;
	private final int defFMband = 87900;
	private final int maxFMBand = 107900;
	private int amBand = defAMband;
	private int fmBand = defFMband;
	private int[] amPresets = { amBand, amBand, amBand, amBand, amBand };
	private int[] fmPresets = { fmBand, fmBand, fmBand, fmBand, fmBand };

	public static void main(String[] args) {
		/**
		 * DAT MAIN
		 */
		// return;
	}

	/**
	 * Construct a car radio with factory default settings and with the supplied station data.
	 * @param stationData
	 */
	public CarRadio(StationData stationData) {
		this.stationData = stationData;
	}

	/**
	 * Turns the car radio on and off. 
	 */
	public void powerBtn() {
		this.power = !this.power;
	}

	/**
	 * Increases the car radio volume by one unit. 
	 */
	public void volumeUpBtn() {
		if (this.power == true)
		{
			if (volume < VOL_MAX)
				volume += VOL_STEP;
			// System.out.println(volume);
		}
	}

	/**
	 * Decreases the car radio volume by one unit. 
	 */
	public void volumeDownBtn() {
		if (this.power == true)
		{
			if (volume > VOL_MIN)
				volume -= VOL_STEP;
			// System.out.println(volume);
		}
	}

	/**
	 * Toggles the mute status of the car radio. 
	 */
	public void muteBtn() {
		if (this.power == true)
		{
			this.mute = !this.mute;
		}
	}

	/**
	 * Toggle the frequency band of the car radio.
	 */
	public void amfmBtn() {
		if (this.power == true)
		{
			if (currentBand == FreqBand.FM)
				currentBand = FreqBand.AM;
			else
				currentBand = FreqBand.FM;
			set = false;
		}
	}

	/**
	 * Increases the tuned frequency by one unit. 
	 */
	public void tuneUpBtn() {
		if (this.power == true)
		{
			if (currentBand == FreqBand.AM) { // AM mode
				amBand += FreqBand.AM.spacing();
				//System.out.println(amBand);
				if (amBand > maxAMBand)
					amBand = defAMband;

			} else if (currentBand == FreqBand.FM) {
				fmBand += FreqBand.FM.spacing();
				if (fmBand > maxFMBand) //+ FreqBand.FM.spacing())
					fmBand = defFMband;
				//set = false;
			}
		}
	}

	/**
	 * Decreases the tuned frequency by one unit. 
	 */
	public void tuneDownBtn() {
		if (this.power == true)
		{
			if (currentBand == FreqBand.AM) {
				// am mode
				amBand -= FreqBand.AM.spacing();
				if (amBand < defAMband)
					amBand = maxAMBand;

			} else if (currentBand == FreqBand.FM) {
				//fm mode
				fmBand -= FreqBand.FM.spacing();
				if (fmBand < defFMband)
					fmBand = maxFMBand;
				//set = false;
			}
		}
	}
	
	/**
	 * Increases the tuned frequency until a viable station is tuned. 
	 */
	public void seekUpBtn() {
		if (this.power == true)
		{

			if (currentBand == FreqBand.AM) {
				// am band
				int originalFreq = amBand;
				
				do {
					tuneUpBtn();
				} while (stationData.lookupFreq(currentBand, amBand) == null && amBand != originalFreq);
				
			} else {
				// fm band
				int originalFreq = fmBand;
				
				do {
					tuneUpBtn();
				} while (stationData.lookupFreq(currentBand, fmBand) == null && fmBand != originalFreq);
				
				// check for fmBand switch to FM from AM and additions
				// accordingly
				//set = false;
			}
		}
	}
	
	/**
	 * Decreases the tuned frequency until a viable station is tuned. 
	 */
	public void seekDownBtn() {
		if (this.power == true)
		{
			if (currentBand == FreqBand.AM) {
				// am band
				int originalFreq = amBand;
				
				do {
					tuneDownBtn();
				} while (stationData.lookupFreq(currentBand, amBand) == null && amBand != originalFreq);
				
			} else {
				//fm band
				int originalFreq = fmBand;
				
				do {
					tuneDownBtn();
					
				} while (stationData.lookupFreq(currentBand, fmBand) == null && fmBand != originalFreq);
				
				// check for fmBand switch to FM from AM and additions
				// accordingly
				//set = false;
			}
		}
	}
	
	/**
	 * Toggles the set function for the radio if power is on.
	 */
	public void setBtn() {
		if (this.power == true)
		{
			this.set = !this.set;
		}
	}
	
	/**
	 * 
	 * @param n (n) is the requested preset button 1-5 on the car radio.
	 * This method assigns the station to the preset button requested if set and power are true.
	 */
	public void preset(int n) {
		if (this.power == true)
		{
			if (set) {
				if (currentBand == FreqBand.AM) {
					amPresets[n] = amBand;
				} else {
					fmPresets[n] = fmBand;
				}
			}
			else {
				if (currentBand == FreqBand.AM) {
					amBand = amPresets[n];
				} else {
					fmBand = fmPresets[n];
				}
			}
		}
	}
	
	/**
	 * Tune to or set preset #1. 
	 */
	public void preset1Btn() {
		if (this.power == true)
		{
			preset(0);
			set = false;
		}
	}
	
	/**
	 * Tune to or set preset #2. 
	 */
	public void preset2Btn() {
		if (this.power == true)
		{
			preset(1);
			set = false;
		}
	}
	
	/**
	 * Tune to or set preset #3. 
	 */
	public void preset3Btn() {
		if (this.power == true)
		{
			preset(2);
			set = false;
		}
	}
	
	/**
	 * Tune to or set preset #4. 
	 */
	public void preset4Btn() {
		if (this.power == true)
		{
			preset(3);
			set = false;
		}
	}
	
	/**
	 * Tune to or set preset #5. 
	 */
	public void preset5Btn() {
		if (this.power == true)
		{
			preset(4);
			set = false;
		}
	}
	
	/**
	 * 
	 * @return (returns) arrayList of the required display for the final car radio.
	 */
	public ArrayList<String> display() {
		ArrayList<String> displayList = new ArrayList<String>();
		
		if (this.power == false)
		{
		displayList.add("---------------------");
		displayList.add("|                   |");
		displayList.add("|                   |");
		displayList.add("---------------------");

		}
		else
		{
			displayList.add("---------------------");
			if (currentBand == FreqBand.AM)
			{
				String station = stationData.lookupFreq(FreqBand.AM, amBand);
				String amNum = Integer.toString(amBand);
				if (station == null)
				{
					station = "****";
				}
				if ((amNum).length()<4)
					//TODO checking length for AM
					displayList.add("|  AM   " + amNum + "   " + station + "  |");
				else//                                  edit these 2
					displayList.add("|  AM   " + amNum + "  " + station + "  |");
			}
			else
			{
				String fm = (Double.toString((double)fmBand/1000.0));
				//converts FM double to string for formatting
				
				String station = stationData.lookupFreq(FreqBand.FM, fmBand);
				if (station == null)
				{
					station = "****";
				}
				if (fm.length() < 5)
					//TODO checking length for FM
					displayList.add("|  FM   " + fm + "  " + station + "  |");
				else//                                edit these 2
					displayList.add("|  FM   " + fm + " " + station + "  |");
			}
			if (mute == true)
			{
				if (set)
				{
					//don't need to check length here as they are constant for this block.
					displayList.add("|  Vol: " + "--    " + "SET   |");
				}
				else
				{
					displayList.add("|  Vol: " + "--   " + "       |");
				}
				
			}
			else
			{
				if (set)
				{
					if ((this.volume) < 10)
					{
						displayList.add("|  Vol: " + this.volume + "     SET   |");
					}
					else
						displayList.add("|  Vol: " + this.volume + "    SET   |");
				}
				else
				{
					if ((this.volume) < 10)
					{
						displayList.add("|  Vol: " + this.volume + "           |");
					}
					else
						displayList.add("|  Vol: " + this.volume + "          |");
				}
			}
			
			displayList.add("---------------------");
		}
		

		return displayList;
	}
}
