package com.intercom.utility;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileHelperTest {

    @Test
    void getFileContents()throws IOException {

        String nonExistentPath = String.valueOf(java.nio.file.Paths.get(System.getProperty("user.dir"), "SomeRandomFile.txt"));
        assertThrows(FileNotFoundException.class, () -> FileHelper.getFileContents(nonExistentPath), "Invalid Path");


        assertThrows(FileNotFoundException.class, () -> FileHelper.getFileContents(null), "Null Path");


        String existentPath = String.valueOf(java.nio.file.Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "test.txt"));
        assertDoesNotThrow(() -> {
            FileHelper.getFileContents(existentPath);
        }, "Unsupported content");

        assertEquals("tasty test data", FileHelper.getFileContents(existentPath), "File contents did not match with expected content");

    }
}