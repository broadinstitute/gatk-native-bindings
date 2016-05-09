package org.broadinstitute.gatk.nativebindings;

import java.io.File;

/**
 * Common interface for all native libraries.
 */
public interface NativeLibrary {

    /**
     * Attempts to load this native library. Returns true if loading was successful <bold>and</bold> the library is supported
     * on the current hardware/software stack. Implementations should ensure that this method does not throw an {@link UnsatisfiedLinkError}.
     * Note that the GATK engine will call this method once per instance and multiple instances may use the same tmpDir.
     *
     * @param tmpDir the temporary directory to which all files, including the library itself, are to be extracted.
     * @return true if the library was successfully loaded and is supported on the current hardware/software stack, false otherwise.
     */
    boolean load(File tmpDir);

}
