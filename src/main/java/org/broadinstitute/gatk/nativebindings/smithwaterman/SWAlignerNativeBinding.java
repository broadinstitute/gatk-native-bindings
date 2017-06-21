package org.broadinstitute.gatk.nativebindings.smithwaterman;


import org.broadinstitute.gatk.nativebindings.NativeLibrary;
import org.broadinstitute.gatk.nativebindings.smithwaterman.SWAlignerNativeArguments;
import org.broadinstitute.gatk.nativebindings.smithwaterman.SWAlignmentResult;

/**
 * Provides access to the native kernel of the Smith-Waterman computation.
 * GATK will call {@link #initialize(SWAlignerNativeArguments)} to set the
 * parameter values and will call {@link #align(byte[], byte[])} to perform
 * an alignment.
 *
 * Only one thread will call methods on any given object of classes that implement this interface.
 */
public interface SWAlignerNativeBinding extends NativeLibrary {

    /**
     * Initialize the native Smith-Waterman
     *
     * @param args arguments used for Smith-Waterman
     */
    void initialize(SWAlignerNativeArguments args);

    /**
     * Perform a Smith-Waterman alignment and return the result
     *
     * @param ref reference sequence
     * @param alt alternate sequence
     * @return alignment result
     */
    SWAlignmentResult align(byte[] ref, byte[] alt);

    /**
     * Print final profiling information from native code and close any resources.
     */
    void done();
}
