package org.broadinstitute.gatk.nativebindings.smithwaterman;

/**
 * Struct used to hold results of the Smith-Waterman alignment result
 */
public class SWAlignmentResult {
    // CIGAR string of the alignment
    public String cigar;

    // offset of the alignment
    public int alignment_offset;
}
