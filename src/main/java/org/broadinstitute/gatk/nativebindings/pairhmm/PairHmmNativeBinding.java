package org.broadinstitute.gatk.nativebindings.pairhmm;

import org.broadinstitute.gatk.nativebindings.NativeLibrary;

/**
 * Provides access to the native kernel of the PairHMM computation.
 * GATK will call {@link #initializeClassFields(Class, Class)} once, the
 * call {@link #computeLikelihoods(int, int, ReadDataHolder[], HaplotypeDataHolder[], double[], int)}
 * multiple times and then call {@link #close()} once at the end.
 *
 * Only one thread will call methods on any given object of classes that implement this interface.
 */
public interface PairHMMNativeBinding extends AutoCloseable, NativeLibrary {

    /**
     * Function to initialize the fields of ReadDataHolder and HaplotypeDataHolder from JVM.
     * C++ code gets FieldIDs for these classes once and re-uses these IDs for the remainder of the program. Field IDs do not
     * change per JVM session
     *
     * @param readDataHolderClass      class type of ReadDataHolderClass
     * @param haplotypeDataHolderClass class type of HaplotypeDataHolderClass
     */
    void initializeClassFields(Class<ReadDataHolder> readDataHolderClass,
                               Class<HaplotypeDataHolder> haplotypeDataHolderClass);

    /**
     * Real compute kernel. Computes the all-reads vs all-haplotype array of likelihoods.
     *
     * @param numReads number of reads (length of readDataArray)
     * @param numHaplotypes number of haplotypes (length of haplotypeDataArray)
     * @param readDataArray struct that stores data about reads
     * @param haplotypeDataArray struct that stores data about haplotypes
     * @param likelihoodArray output argument of size readListSize * numHaplotypes
     * @param maxNumThreadsToUse maximum number of threads that the compute engine may create and use
     */
    void computeLikelihoods(int numReads,
                            int numHaplotypes,
                            ReadDataHolder[] readDataArray,
                            HaplotypeDataHolder[] haplotypeDataArray,
                            double[] likelihoodArray,
                            int maxNumThreadsToUse);

    /**
     * Print final profiling information from native code. Close any resources.
     */
    @Override
    void close();

}
