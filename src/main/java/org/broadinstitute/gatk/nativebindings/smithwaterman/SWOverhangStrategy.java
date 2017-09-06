package org.broadinstitute.gatk.nativebindings.smithwaterman;

/**
 * How overhangs should be treated during Smith-Waterman alignment
 */
public enum SWOverhangStrategy {
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
