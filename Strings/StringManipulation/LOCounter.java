package Strings.StringManipulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LOCounter {
    public static int countLines(String filePath) throws IOException {
        int codeLines = 0;
        boolean inBlockComment = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Remove leading/trailing whitespace

                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                // Handle single line comments
                if (line.startsWith("//")) {
                    continue;
                }

                // Handle block comments
                if (line.startsWith("/*")) {
                    inBlockComment = true;
                } else if (line.endsWith("*/")) {
                    inBlockComment = false;
                }

                if (!inBlockComment) {
                    codeLines++;
                }
            }
        }

        return codeLines;
    }

    public static void main(String[] args) throws IOException {
     
 
        int codeLines = countLines("/home/pedrosantos/workspace/estudos/basic-tranning/Strings/StringManipulation/Example.java");
        System.out.println("Number of code lines: " + codeLines);
    }

}
/*
public class LOCounterTest {

    @Test
    public void testEmptyFile() throws IOException {
        File emptyFile = File.createTempFile("empty-file", ".txt");
        emptyFile.deleteOnExit();

        int codeLines = LOCounter.countLines(emptyFile.getAbsolutePath());
        assertEquals(0, codeLines, "Empty file should have zero code lines");
    }

    @Test
    public void testSingleLineComment() throws IOException {
        File file = File.createTempFile("single-line-comment", ".java");
        file.deleteOnExit();

        try (java.io.FileWriter writer = new java.io.FileWriter(file)) {
            writer.write("// This is a single-line comment\n");
        }

        int codeLines = LOCounter.countLines(file.getAbsolutePath());
        assertEquals(0, codeLines, "Single-line comment should not be counted");
    }

    @Test
    public void testMultipleLines() throws IOException {
        File file = File.createTempFile("multiple-lines", ".java");
        file.deleteOnExit();

        try (java.io.FileWriter writer = new java.io.FileWriter(file)) {
            writer.write("public class MyClass {\n");
            writer.write("    public void someMethod() {\n");
            writer.write("        // This is another comment\n");
            writer.write("        System.out.println(\"Hello world!\");\n");
            writer.write("    }\n");
            writer.write("}\n");
        }

        int codeLines = LOCounter.countLines(file.getAbsolutePath());
        assertEquals(4, codeLines, "Multiple lines should count excluding comments");
    }

    @Test
    public void testBlockComment() throws IOException {
        File file = File.createTempFile("block-comment", ".java");
        file.deleteOnExit();

        try (java.io.FileWriter writer = new java.io.FileWriter(file)) {
            writer.write("public class MyClass {\n");
            writer.write("    /* This is a block comment\n");
            writer.write("       spanning multiple lines /\n");
            writer.write("    public void someMethod() {\n");
            writer.write("        System.out.println(\"Hello world!\");\n");
            writer.write("    }\n");
            writer.write("}\n");
        }

        int codeLines = LOCounter.countLines(file.getAbsolutePath());
        assertEquals(2, codeLines, "Block comment lines should not be counted");
    }

    @Test
    public void testEmptyLines() throws IOException {
        File file = File.createTempFile("empty-lines", ".java");
        file.deleteOnExit();

        try (java.io.FileWriter writer = new java.io.FileWriter(file)) {
            writer.write("public class MyClass {\n");
            writer.write("\n");
            writer.write("    public void someMethod() {\n");
            writer.write("        System.out.println(\"Hello world!\");\n");
            writer.write("    }\n");
            writer.write("}\n");
        }

        int codeLines = LOCounter.countLines(file.getAbsolutePath());
        assertEquals(3, codeLines, "Empty lines should be skipped");
    }

    @Test
    public void testInvalidFile() {
        String invalidPath = "invalid/path/to/file.java";
        try {
            LOCounter.countLines(invalidPath);
        } catch (IOException e) {
            // Expected exception for invalid file
            return;
        }
        // If no exception is thrown, fail the test
        assertEquals(1, 0, "IOException expected for invalid file path");
    }
} **/