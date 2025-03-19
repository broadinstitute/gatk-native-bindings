package org.broadinstitute.gatk.nativebindings.pdhmm;

/**
 * Struct used to pass arguments to the PDHMM computation.
 */
public class PDHMMNativeArguments {
    /**
     * The maximum number of threads to use in the PDHMM computation.
     */
    public int maxNumberOfThreads;

     /**
     * Enum representing the AVX level.
     */
    public enum AVXLevel {
        SCALAR,
        AVX2,
        AVX512
    }

    /**
     * The AVX level to use in the PDHMM computation.
     */
    public AVXLevel avxLevel;

    /**
     * The maximum memory to use in the PDHMM computation (in megabytes).
     */
    public int maxMemoryInMB;

}
