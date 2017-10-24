package rubiconproject.service;

import rubiconproject.model.FileWithHash;
import rubiconproject.hash.HashGenerator;

import java.io.File;
import java.util.List;

/**
 * Calculate hash for {@link File} file or directory using {@link HashGenerator} algorithm
 */
public interface FileHashService {

    /**
     * Calculates hash recursively for each object if {@link File#isDirectory()}
     *
     * @param file {@link File} file or directory
     * @return {@link FileWithHash} result
     */
    FileWithHash recursionHash(File file);

    /**
     * Calculate hash for file
     * The hash of a file is a hash of its contents then hexed encoded.
     *
     * @param file {@link File} file
     * @return {@link FileWithHash} result
     */
    FileWithHash fileHash(File file);

    /**
     * Calculate hash for directory
     * The hash of a directory is generated by hashing each file or subdirectory in alphabetical order,
     * then concatenating the hashed value, then applying SHA-512 hash to the results
     *
     * @param file         {@link File} directory
     * @param internal {@link List} of {@link FileWithHash} internal files or directories
     * @return {@link String} hash result
     */
    String dirHash(File file, List<FileWithHash> internal);
}
