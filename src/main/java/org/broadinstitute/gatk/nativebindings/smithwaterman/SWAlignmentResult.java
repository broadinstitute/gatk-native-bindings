package org.broadinstitute.gatk.nativebindings.smithwaterman;

/**
 * Struct used to hold results of the Smith-Waterman alignment result
 */
public final class SWAlignmentResult {
    // CIGAR string of the alignment
    public final String cigar;

    // offset of the alignment
    public final int alignment_offset;


    public SWAlignmentResult(final String cigar, final int alignment_offset)
    {
        this.cigar = cigar;
        this.alignment_offset = alignment_offset;
    }
}
