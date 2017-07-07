package org.broadinstitute.gatk.nativebindings.smithwaterman;

/**
 * Struct used to pass arguments to the Smith-Waterman aligner
 */
public class SWAlignerNativeArguments {

    /**
     * What strategy should we use when the best path does not start/end at the corners of the matrix?
     */

    public SWAlignerNativeArguments(final OverhangStrategy strategy, final int w_extend, final int w_match, final int w_mismatch, final int w_open)
    {
        
        if( w_mismatch > 0) {
            throw new IllegalArgumentException("w_mismatch must be <= 0");
        }
        if( w_open > 0) {
            throw new IllegalArgumentException("w_open must be <= 0");
        }
        if( w_extend > 0) {
            throw new IllegalArgumentException("w_extend must be <= 0");
        }
        
        this.strategy = strategy;
        this.w_extend = w_extend;
        this.w_match = w_match;
        this.w_mismatch = w_mismatch;
        this.w_open = w_open;
    }


    public enum OverhangStrategy {
        /*
         * Add softclips for the overhangs
         */
        SOFTCLIP,

        /*
         * Treat the overhangs as proper insertions/deletions
         */
        INDEL,

        /*
         * Treat the overhangs as proper insertions/deletions for leading (but not trailing) overhangs.
         * This is useful e.g. when we want to merge dangling tails in an assembly graph: because we don't
         * expect the dangling tail to reach the end of the reference path we are okay ignoring trailing
         * deletions - but leading indels are still very much relevant.
         */
        LEADING_INDEL,

        /*
         * Just ignore the overhangs
         */
        IGNORE
    }
    public OverhangStrategy strategy;

    /**
     * Smith-Waterman alignment parameters:
     * match value, and mismatch, gap open and gap extension penalties
     */
    public final int w_match;
    public final int w_mismatch;
    public final int w_open;
    public final int w_extend;
}
