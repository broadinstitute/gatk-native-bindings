package org.broadinstitute.gatk.nativebindings.pairhmm;

/**
 * Struct used to pass arguments to the PairHMM computation.
 */
public class PairHMMNativeArguments {
    /**
     * The maximum number of threads to use in the PairHMM computation.
     */
    int maxNumberOfThreads;

    /**
     * True if the PairHMM calculations should use double precision floating-point arithmetic, false otherwise.
     */
    boolean useDoublePrecision;
}
