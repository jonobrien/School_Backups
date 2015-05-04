/**
 * CarRadio.java
 *
 * File:
 *	$Id: CarRadio.java,v 1.3 2013/03/14 02:20:12 njm7461 Exp $
 *
 * Revisions:
 *	$Log: CarRadio.java,v $
 *	Revision 1.3  2013/03/14 02:20:12  njm7461
 *	Made one generic preset function
 *	Fixed power states for several functions
 *
 *	Revision 1.2  2013/03/14 02:01:30  njm7461
 *	Volume does not change when power is off
 *
 *	Revision 1.1  2013/03/14 01:37:16  njm7461
 *	Initial commit
 *
 */

/**
 * Represents an AM/FM car radio.
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */
import java.util.ArrayList;
public class CarRadio
{
	/**
	 * Constant value of 0 representing the minimum volume of the radio.
	 */
	public static final int MAX_VOLUME = 20;
	/**
	 * Constant value of 20 representing the maximum volume of the radio.
	 */
	public static final int MIN_VOLUME = 0;
	
	/**
	 * Integer representation of volume limited from MIN_VOLUME to MAX_VOLUME
	 */
	private static int volume;
	/**
	 * Boolean if the system is muted
	 */
	private static boolean mute;
	/**
	 * Integer representation of the last stored AM frequency
	 */
	private static int amFreq;
	/**
	 * Integer representation of the last stored FM frequency
	 */
	private static int fmFreq;
	/**
	 * StationData holding formation about the AM and FM stations in different locations
	 */
	private static StationData station;
	/**
	 * Frequency band data holding information about AM and FM stations
	 */
	private static FreqBand band;
	/**
	 * Boolean to represent whether or not the system is on
	 */
	private static boolean power;
	private static int prepared;
	private static int[] amPrimaryPresets;
	private static int[] fmPrimaryPresets;
	private static int[] amSecondaryPresets;
	private static int[] fmSecondaryPresets;
	
	/**
	 * Construct a car radio with factory default settings and with the supplied station data
	 * @param stationData The local station data, used to determine viable stations and station ids
	 */
	public CarRadio(StationData stationData)
	{
		volume = 0;
		mute = false;
		station = stationData;
		band = FreqBand.AM;
		amFreq = 520;
		fmFreq = 87900;
		power = false;
		amPrimaryPresets = new int[5];
		fmPrimaryPresets = new int[5];
		amSecondaryPresets = new int[5];
		fmSecondaryPresets = new int[5];
		for (int i = 0; i < 5; i++)
		{
			amPrimaryPresets[i] = 520;
			fmPrimaryPresets[i] = 87900;
			amSecondaryPresets[i] = 520;
			fmSecondaryPresets[i] = 87900;
		}
		prepared = 0;
	}
	
	/**
	 * Toggle the frequency band of the car radio
	 */
	public void amfmBtn()
	{
		if (band == FreqBand.FM)
			band = FreqBand.AM;
		else
			band = FreqBand.FM;
	}
	
	/**
	 * Turns the car radio on and off
	 */
	public void powerBtn()
	{
		power = !power;
		prepared = 0;
	}
	
	/**
	 * Increases the car radio volume by one unit
	 */
	public void volumeUpBtn()
	{
		if (volume < 20 && power)
		{
			volume++;
		}
	}
	
	/**
	 * Decreases the car radio volume by one unit
	 */
	public void volumeDownBtn()
	{
		if (volume > 0 && power)
		{
			volume--;
		}
	}
	
	/**
	 * Toggles the mute status of the car radio
	 */
	public void muteBtn()
	{
		if (power)
		{
			mute = !mute;
		}
	}
	
	/**
	 * Increases the tuned frequency by one unit
	 */
	public void tuneUpBtn()
	{
		if (power)
		{
			prepared = 0;
			if (band == FreqBand.AM)
			{
				if (amFreq + band.spacing() <= band.maxFreq())
				{
					amFreq += band.spacing();
				}
				else
				{
					amFreq = band.minFreq();
				}
			}
			else
			{
				if (fmFreq + band.spacing() <= band.maxFreq())
				{
					fmFreq += band.spacing();
				}
				else
				{
					fmFreq = band.minFreq();
				}
			}
		}

	}
	
	/**
	 * Decreases the tuned frequency by one unit
	 */
	public void tuneDownBtn()
	{
		if (power)
		{
			prepared = 0;
			if (band == FreqBand.AM)
			{
				if (amFreq - band.spacing() >= band.minFreq())
				{
					amFreq -= band.spacing();
				}
				else
				{
					amFreq = band.maxFreq();
				}
			}
			else
			{
				if (fmFreq - band.spacing() >= band.minFreq())
				{
					fmFreq -= band.spacing();
				}
				else
				{
					fmFreq = band.maxFreq();
				}
			}
		}
	}
	
	/**
	 * Increases the tuned frequency until a viable station is tuned
	 */
	public void seekUpBtn()
	{
		if (band == FreqBand.AM)
		{
			int originalFrequency = amFreq;
			do
			{
				tuneUpBtn();
			}
			while (station.lookupFreq(band, amFreq) == null && amFreq != originalFrequency);
		}
		else
		{
			int originalFrequency = fmFreq;
			do
			{
				tuneUpBtn();
			}
			while (station.lookupFreq(band, fmFreq) == null && fmFreq != originalFrequency);
		}
	}
	
	/**
	 * Decreases the tuned frequency until a viable station is tuned
	 */
	public void seekDownBtn()
	{
		if (band == FreqBand.AM)
		{
			int originalFrequency = amFreq;
			do
			{
				tuneDownBtn();
			}
			while (station.lookupFreq(band, amFreq) == null && amFreq != originalFrequency);
		}
		else
		{
			int originalFrequency = fmFreq;
			do
			{
				tuneDownBtn();
			}
			while (station.lookupFreq(band, fmFreq) == null && fmFreq != originalFrequency);
		}
	}
	
	/**
	 * Prepare to set a primary or secondary preset frequency
	 */
	public void setBtn()
	{
		if (prepared >= 2)
		{
			prepared = 0;
		}
		else
		{
			prepared++;
		}
	}
	
	/**
	 * Tune to or set preset n 
	 * @param n integer position in array
	 */
	public void presetNBtn(int n)
	{
		if (power)
		{
			if (band == FreqBand.AM)
			{
				switch (prepared)
				{
				case 0:
					if (amFreq != amPrimaryPresets[n])
					{
						amFreq = amPrimaryPresets[n];
					}
					else
					{
						amFreq = amSecondaryPresets[n];
					}
					break;
				case 1:
					amPrimaryPresets[n] = amFreq;
					prepared = 0;
					break;
				case 2:
					amSecondaryPresets[n] = amFreq;
					prepared = 0;
					break;
				}
			}
			else
			{
				switch (prepared)
				{
				case 0:
					if (fmFreq != fmPrimaryPresets[n])
					{
						fmFreq = fmPrimaryPresets[n];
					}
					else
					{
						fmFreq = fmSecondaryPresets[n];
					}
					break;
				case 1:
					fmPrimaryPresets[n] = fmFreq;
					prepared = 0;
					break;
				case 2:
					fmSecondaryPresets[n] = fmFreq;
					prepared = 0;
					break;
				}
			}
		}
	}
	
	/**
	 * Tune to or set preset #1
	 */
	public void preset1Btn()
	{
		presetNBtn(0);
	}
	
	
	/**
	 * Tune to or set preset #2
	 */
	public void preset2Btn()
	{
		presetNBtn(1);
	}
	
	/**
	 * Tune to or set preset #3
	 */
	public void preset3Btn()
	{
		presetNBtn(2);
	}
	
	/**
	 * Tune to or set preset #4
	 */
	public void preset4Btn()
	{
		presetNBtn(3);
	}
	
	/**
	 * Tune to or set preset #5
	 */
	public void preset5Btn()
	{
		presetNBtn(4);
	}

		
	/**
	 * Return the car radio display
	 * @return A sequence of four strings depicting the current car radio state.
	 */
	public ArrayList<String> display()
	{
		String line = "---------------------";
		String line2 = "";
		String line3 = "";
		
		if (power == false)
		{
			line2 = "|                   |";
			line3 = line2;
		}
		else
		{
			String bandStr = (band == FreqBand.AM ? "AM" : "FM");
			int bandFreq = (band == FreqBand.AM ? amFreq : fmFreq);
			String bandFreqStr = "";
			if(band == FreqBand.AM)
			{
				bandFreqStr += amFreq;
			}
			else
			{
				bandFreqStr += ((double)fmFreq) / 1000;
			}
			
			switch (bandFreqStr.length())
			{
			case(3):
				bandFreqStr = "    " + bandFreqStr;
				break;
			case(4):
				bandFreqStr = "   " + bandFreqStr;
				break;
			case(5):
				bandFreqStr = "  " + bandFreqStr;
				break;
				
			}

			String stationStr = (station.lookupFreq(band, bandFreq) == null ? "****" : station.lookupFreq(band, bandFreq));
			
			String setStr = "    ";
			switch (prepared)
			{
			case 0:
				setStr = "    ";
				break;
			case 1:
				setStr = "SET1";
				break;
			case 2:
				setStr = "SET2";
				break;
			}
			line2 = "|  " + bandStr + bandFreqStr + "  " + stationStr + "  |";
			
			String volStr = "";
			if (!mute)
			{
				volStr = "" + (volume <= 9 ? " " + volume : volume);
			}
			else
			{
				volStr = "--";
			}
			line3 = "|  Vol: " + volStr + "    " + setStr + "  |";
		}
		ArrayList<String> strList = new ArrayList<String>(4);
		strList.add(line);strList.add(line2);strList.add(line3);strList.add(line);
		return strList;

	}
}
