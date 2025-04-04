package org.broadinstitute.gatk.nativebindings.pdhmm;

import org.broadinstitute.gatk.nativebindings.NativeLibrary;

/**
 * Provides access to the native kernel of the PDHMM computation.
 * GATK will call {@link #initialize(PDHMMNativeArguments)} once, then
 * call {@link #computeLikelihoods(ReadDataHolder[], HaplotypeDataHolder[], double[])}
 * multiple times and then call {@link #done()} once at the end.
 *
 * Only one thread will call methods on any given object of classes that implement this interface.
 */
public interface PDHMMNativeBinding extends NativeLibrary {

    /**
     * Function to initialize native PDHMM
     *
     * @param args                     arguments used for PDHMM computation
     */
    void initialize(PDHMMNativeArguments args);

    /**
     * Real compute kernel. Computes the all-reads vs all-haplotype array of likelihoods.
     *
     * @param readDataArray struct that stores data about reads
     * @param haplotypeDataArray struct that stores data about haplotypes
     * @param likelihoodArray output argument of size readListSize * numHaplotypes
     */
    void computeLikelihoods(ReadDataHolder[] readDataArray,
                            HaplotypeDataHolder[] haplotypeDataArray,
                            double[] likelihoodArray);

    /**
     * Print final profiling information from native code and close any resources.
     */
    void done();
}
