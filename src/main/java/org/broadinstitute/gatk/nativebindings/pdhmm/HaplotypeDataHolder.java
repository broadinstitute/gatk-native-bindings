package org.broadinstitute.gatk.nativebindings.pdhmm;

/**
 * Struct used to copy references to byteArrays to JNI from haplotypes.
 */
public final class HaplotypeDataHolder {
    public byte[] haplotypeBases = null;
    public byte[] haplotypePDBases = null;
}
