package org.broadinstitute.gatk.nativebindings.pairhmm;

/**
 * Struct used to copy references to byteArrays from reads to the PairHMM compute kernel.
 */
public final class ReadDataHolder {
    public byte[] readBases = null;
    public byte[] readQuals = null;
    public byte[] insertionGOP = null;
    public byte[] deletionGOP = null;
    public byte[] overallGCP = null;
}