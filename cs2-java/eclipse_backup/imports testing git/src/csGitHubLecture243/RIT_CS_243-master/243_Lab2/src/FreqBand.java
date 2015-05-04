/*
 * FreqBand.java
 *
 * Version:
 *  $Id: FreqBand.java,v 1.1 2013/03/14 01:37:16 njm7461 Exp $
 * Revisions:
 *  $Log: FreqBand.java,v $
 *  Revision 1.1  2013/03/14 01:37:16  njm7461
 *  Initial commit
 *
 *
 */

/**
 * Represents a radio frequency band (AM or FM).
 *
 * @author Matthew Fluet (mtf)
 */
public enum FreqBand { 
    /**
     * The AM frequency band; 520kHz &ndash; 1610kHz, 10kHz spacing.
     */
    AM(520,1610,10), 
    /** 
     * The FM frequency band; 87.9 MHz &ndash; 107.9 MHz, 200kHz spacing.
     */
    FM(87900,107900,200);

    private final int minFreq;
    private final int maxFreq;
    private final int spacing;
    private FreqBand(int minFreq, int maxFreq, int spacing) {
        this.minFreq = minFreq;
        this.maxFreq = maxFreq;
        this.spacing = spacing;
    }
    /**
     * The minimum valid frequency of the frequency band, in kHz.
     */
    public int minFreq() { return minFreq; }
    /**
     * The maximum valid frequency of the frequency band, in kHz.
     */
    public int maxFreq() { return maxFreq; }
    /**
     * The spacing between stations broadcasting on the frequency band, in kHz.
     */
    public int spacing() { return spacing; }
};