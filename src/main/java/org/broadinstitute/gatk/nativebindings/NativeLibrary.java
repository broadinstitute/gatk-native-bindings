package org.broadinstitute.gatk.nativebindings;

import java.nio.file.Path;

/**
 * Common interface for all native libraries.
 */
public interface NativeLibrary {
    /**
     * Returns the path to this native library.
     * Typically this is the path to the shared object file. GATK will use this path to load the native library.
     */
    Path getLibraryPath();

    /**
     * Returns true if this native library is supported on the current combination of hardware, operating system, etc.
     * Return false otherwise.
     */
    boolean isSupported();
}
