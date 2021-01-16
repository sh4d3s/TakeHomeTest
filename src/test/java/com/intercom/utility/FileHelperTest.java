package com.intercom.utility;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileHelperTest {

    String existentPath = String.valueOf(java.nio.file.Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "test.txt"));
    String nonExistentPath = String.valueOf(java.nio.file.Paths.get(System.getProperty("user.dir"), "SomeRandomFile.txt"));

    @Test
    void getFileContents_NonExistentPathAsInput_ThrowsFileNotFoundException() {

        assertThrows(FileNotFoundException.class, () -> FileHelper.getFileContents(nonExistentPath), "Invalid Path");
    }

    @Test
    void getFileContents_NullAsInput_ThrowsFileNotFoundException() {
        assertThrows(FileNotFoundException.class, () -> FileHelper.getFileContents(null), "Null Path");
    }
    @Test
    void getFileContents_ExistentPathAsInput_DoesNotThrowAnyException() {

        assertDoesNotThrow(() -> {
            FileHelper.getFileContents(existentPath);
        }, "Unsupported content");
    }

    @Test
    void getFileContents_FetchDataFromTestTXT_FetchedDataMatchesWithKnownData() throws IOException {
        assertEquals("tasty test data", FileHelper.getFileContents(existentPath), "File contents did not match with expected content");

    }
}