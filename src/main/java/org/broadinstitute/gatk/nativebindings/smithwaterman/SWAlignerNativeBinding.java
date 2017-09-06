package org.broadinstitute.gatk.nativebindings.smithwaterman;


import org.broadinstitute.gatk.nativebindings.NativeLibrary;

import java.io.Closeable;

/**
 * Provides access to the native kernel of the Smith-Waterman computation.
 * GATK will call {@link #align(byte[], byte[], SWParameters, SWOverhangStrategy)} to perform
 * an alignment.
 *
 * Subclasses may override {@link #close()} if they need to release resources.
 *
 * Only one thread will call methods on any given object of classes that implement this interface.
 */
public interface SWAlignerNativeBinding extends NativeLibrary, Closeable {

    /**
     * Perform a Smith-Waterman alignment and return the result
     *
     * @param ref reference sequence
     * @param alt alternate sequence
     * @return alignment result
     */
    SWNativeAlignerResult align(byte[] ref, byte[] alt, SWParameters parameters, SWOverhangStrategy overhangStrategy);


    /**
     * Subclasses may optionally implement close in order to release any native resources that they are holding.
     * Subclasses that rely on close to recover resources should fail with {@link IllegalStateException} if
     * {@link #align(byte[], byte[], SWParameters, SWOverhangStrategy)} is called after close.
     */
    @Override
    default void close() {
        //do nothing by default
    }

}
