package org.broadinstitute.gatk.nativebindings.pairhmm;

/**
 * Struct used to copy references to byteArrays to JNI from haplotypes.
 */
public final class HaplotypeDataHolder {
    public byte[] haplotypeBases = null;
}