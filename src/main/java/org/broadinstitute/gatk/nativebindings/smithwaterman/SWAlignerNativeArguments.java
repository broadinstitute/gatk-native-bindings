package org.broadinstitute.gatk.nativebindings.smithwaterman;

/**
 * Struct used to pass arguments to the Smith-Waterman aligner
 */
public class SWAlignerNativeArguments {

    /**
     * What strategy should we use when the best path does not start/end at the corners of the matrix?
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
    public OverhangStrategy strategy;

    /**
     * Smith-Waterman alignment parameters:
     * match value, and mismatch, gap open and gap extension penalties
     */
    public int w_match;
    public int w_mismatch;
    public int w_open;
    public int w_extend;
}
