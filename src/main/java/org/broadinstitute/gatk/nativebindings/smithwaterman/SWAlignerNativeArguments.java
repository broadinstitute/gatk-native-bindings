package org.broadinstitute.gatk.nativebindings.smithwaterman;

/**
 * Struct used to pass arguments to the Smith-Waterman aligner
 */
public final class SWAlignerNativeArguments {
    /** how to treat overhangs **/
    public final OverhangStrategy strategy;

    /** match value **/
    public final int w_match;

    /** mismatch penalty **/
    public final int w_mismatch;

    /** gap open penalty **/
    public final int w_open;

    /** gap extension penalty **/
    public final int w_extend;

    public SWAlignerNativeArguments(final OverhangStrategy strategy, final int w_extend, final int w_match, final int w_mismatch, final int w_open)
    {
        if ( strategy == null ) {
            throw new IllegalArgumentException("strategy must not be null");
        }
        if( w_extend > 0 ) {
            throw new IllegalArgumentException("w_extend must be <= 0 but was passed as " + w_extend);
        }
        if( w_mismatch > 0 ) {
            throw new IllegalArgumentException("w_mismatch must be <= 0 but was passed as " + w_mismatch);
        }
        if( w_open > 0 ) {
            throw new IllegalArgumentException("w_open must be <= 0 but was passed as " + w_open);
        }

        this.strategy = strategy;
        this.w_extend = w_extend;
        this.w_match = w_match;
        this.w_mismatch = w_mismatch;
        this.w_open = w_open;
    }

    /**
     * How overhangs should be treated during Smith-Waterman alignment
     */
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

}
