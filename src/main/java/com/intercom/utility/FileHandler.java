package com.intercom.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileHandler {

    /***
     * Returns the contents of the file as a string
     * @param filePath File path of customers.txt
     * @return String containing entire file
     * @throws IOException In-case any I/O Exception occurs
     * @throws FileNotFoundException In-case file path is invalid
     */
    public static String getFileContents(String filePath) throws IOException {
        String content;
        if (filePath == null || !Files.exists(Paths.get(filePath))) {
            throw new FileNotFoundException("File does not exist");
        }
        content = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)
                .collect(Collectors.joining(System.lineSeparator()));

        return content;
    }

}
