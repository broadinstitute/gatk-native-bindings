package org.broadinstitute.gatk.nativebindings.pairhmm;

import org.broadinstitute.gatk.nativebindings.NativeLibrary;

/**
 * Provides access to the native kernel of the PairHMM computation.
 * GATK will call {@link #initialize(Class, Class, PairHMMNativeArguments)} once, then
 * call {@link #computeLikelihoods(int, int, ReadDataHolder[], HaplotypeDataHolder[], double[])}
 * multiple times and then call {@link #done()} once at the end.
 *
 * Only one thread will call methods on any given object of classes that implement this interface.
 */
public interface PairHMMNativeBinding extends NativeLibrary {

    /**
     * Function to initialize the fields of ReadDataHolder and HaplotypeDataHolder from JVM.
     * C++ code gets FieldIDs for these classes once and re-uses these IDs for the remainder of the program. Field IDs do not
     * change per JVM session
     *
     * @param readDataHolderClass      class type of ReadDataHolderClass
     * @param haplotypeDataHolderClass class type of HaplotypeDataHolderClass
     * @param args                     arguments used for pairHMM computation
     */
    void initialize(Class<ReadDataHolder> readDataHolderClass,
                    Class<HaplotypeDataHolder> haplotypeDataHolderClass,
                    PairHMMNativeArguments args);

    /**
     * Real compute kernel. Computes the all-reads vs all-haplotype array of likelihoods.
     *
     * @param numReads number of reads (length of readDataArray)
     * @param numHaplotypes number of haplotypes (length of haplotypeDataArray)
     * @param readDataArray struct that stores data about reads
     * @param haplotypeDataArray struct that stores data about haplotypes
     * @param likelihoodArray output argument of size readListSize * numHaplotypes
     */
    void computeLikelihoods(int numReads,
                            int numHaplotypes,
                            ReadDataHolder[] readDataArray,
                            HaplotypeDataHolder[] haplotypeDataArray,
                            double[] likelihoodArray);

    /**
     * Print final profiling information from native code and close any resources.
     */
    void done();
}
