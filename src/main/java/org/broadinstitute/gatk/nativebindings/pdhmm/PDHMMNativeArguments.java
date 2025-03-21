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
        FASTEST_AVAILABLE,
        SCALAR,
        AVX2,
        AVX512
    }

    /**
     * Enum representing OpenMP settings.
     */
    public enum OpenMPSetting {
        FASTEST_AVAILABLE, // Use OpenMP if available, otherwise fallback to non-OMP
        ENABLE, // Require OpenMP; fail if not available
        DISABLE // Disable OpenMP explicitly
    }

    /**
     * The AVX level to use in the PDHMM computation.
     */
    public AVXLevel avxLevel;

    /**
     * The OpenMP setting to use in the PDHMM computation.
     */
    public OpenMPSetting openMPSetting = OpenMPSetting.FASTEST_AVAILABLE; // Default

    /**
     * The maximum memory to use in the PDHMM computation (in megabytes).
     */
    private int maxMemoryInMB;

    /**
     * Sets the maximum memory, ensuring it is a positive integer.
     *
     * @param maxMemoryInMB the maximum memory to use (in megabytes)
     * @throws IllegalArgumentException if maxMemoryInMB is not positive
     */
    public void setMaxMemoryInMB(int maxMemoryInMB) {
        if (maxMemoryInMB <= 0) {
            throw new IllegalArgumentException("maxMemoryInMB must be a positive integer.");
        }
        this.maxMemoryInMB = maxMemoryInMB;
    }

    /**
     * Gets the maximum memory value.
     *
     * @return maxMemoryInMB
     */
    public int getMaxMemoryInMB() {
        return maxMemoryInMB;
    }

}
