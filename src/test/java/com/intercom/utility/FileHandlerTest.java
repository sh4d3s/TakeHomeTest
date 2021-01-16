package com.intercom.utility;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void getFileContents() {

        String nonExistentPath = String.valueOf(java.nio.file.Paths.get(System.getProperty("user.dir"), "SomeRandomFile.txt"));
        assertThrows(FileNotFoundException.class, () -> FileHandler.getFileContents(nonExistentPath), "Invalid Path");


        assertThrows(FileNotFoundException.class, () -> FileHandler.getFileContents(null), "Null Path");


        String existentPath = String.valueOf(java.nio.file.Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "test.txt"));
        assertDoesNotThrow(() -> {
            FileHandler.getFileContents(existentPath);
        }, "Unsupported content");


        try {
            assertEquals("tasty test data", FileHandler.getFileContents(existentPath), "File contents did not match with expected content");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}